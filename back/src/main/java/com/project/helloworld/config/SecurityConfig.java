package com.project.helloworld.config;

import com.project.helloworld.security.CustomAuthenticationEntryPoint;
import com.project.helloworld.security.jwt.JwtAccessDeniedHandler;
import com.project.helloworld.security.jwt.JwtAuthenticationFilter;
import com.project.helloworld.security.jwt.JwtTokenProvider;
import com.project.helloworld.security.oauth2.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTemplate redisTemplate;
    private final CustomOAuth2Service customOAuthService;
    private final Oauth2AuthenticationSuccessHandler oauth2AuthenticationSuccessHandler;
    private final Oauth2AuthenticationFailureHandler oauth2AuthenticationFailureHandler;

    @Bean
    public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
        return new HttpCookieOAuth2AuthorizationRequestRepository();
    }

    // 등록된 AuthenticaionManager를 불러오기 위한 bean
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // 패스워드 인코더
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // security ignore
    @Bean
    public WebSecurityCustomizer configure() {
        return web -> { web.ignoring()
                .antMatchers(
                        "/v2/api-docs/**"
                        , "/swagger.json"
                        , "/swagger-ui.html/**"
                        , "/swagger-resources/**"
                        , "/webjars/**"
                        ,"/swagger-ui/**"
                        ,"/v3/api-docs/**"
                        ,"/**/user/email-certification/**"
                        ,"/**/user/sms-certification/**"
                );
        };
    }

    // HttpSecurity 설정
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .formLogin().disable() // security 기본 로그인 사용 X
                // cors허용
                .cors().and().cors().configurationSource(corsConfigurationSource()).and()
                .csrf().disable() // csrf 보안 설정 비활성화
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션 사용 X
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .and()
                .authorizeRequests() // 보호된 리소스 URI에 접근할 수 있는 권한 설정
                // 로그인, 회원가입 접근 허용
                .antMatchers( "/", "/**/signIn/", "/**/signUp", "/**/redis/", "/reissue").permitAll()
                .antMatchers("/**/user/**").hasRole("USER")
                .antMatchers("/auth", "/**/oauth2/**").permitAll()
                .anyRequest().authenticated() // 다른 경로는 인증필요
                .and()
                .oauth2Login()
                .authorizationEndpoint()
                .baseUri("/oauth2/authorize") // 프론트에서 백엔드로 소셜 로그인 보내는 요청 URI
                // Authorization 과정에서 기본적으로 Session을 사용하지만 jwt 사용하면서 session을 사용하지 않기에 cookie 사용
                .authorizationRequestRepository(cookieAuthorizationRequestRepository())
                .and()
                .redirectionEndpoint() // Authorization 과정이 끝나면 Authorization code와 함께 리다이렉트할 URI
                .baseUri("/oauth2/callback/*")
                .and()
                .userInfoEndpoint()
                .userService(customOAuthService)// Provider로부터 획득한 유저정보 다룰 service class
                .and()
                .successHandler(oauth2AuthenticationSuccessHandler)
                .failureHandler(oauth2AuthenticationFailureHandler);

                // JwtAuthenticationFilter를 UsernamePasswordAuthenticationFilter보다 앞으로 설정
                http.exceptionHandling()
                        .authenticationEntryPoint(customAuthenticationEntryPoint) // 토큰없는 사용자 요청시 unathorized error
                        .accessDeniedHandler(jwtAccessDeniedHandler);

                http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider, redisTemplate), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // CORS 허용 적용
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("http://localhost:3000");
        // 추후 도메인 주소에 맞게 변경필요
        configuration.addAllowedOrigin("http://localhost:8081");
        configuration.addAllowedOrigin("http://localhost:8080");
        configuration.addAllowedOrigin("https://k8a308.p.ssafy.io");
        configuration.addAllowedOrigin("https://k8a308.p.ssafy.io/api");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
