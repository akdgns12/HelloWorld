package com.project.StoryModule.config;

import com.project.StoryModule.security.CustomAuthenticationEntryPoint;
import com.project.StoryModule.security.jwt.JwtAccessDeniedHandler;
import com.project.StoryModule.security.jwt.JwtAuthenticationFilter;
import com.project.StoryModule.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
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
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
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
                );
        };
    }
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .formLogin().disable() // security 기본 로그인 사용 X
                // cors허용
                .cors().and().cors().configurationSource(corsConfigurationSource()).and()
                .csrf().disable() // csrf 보안 설정 비활성화
                // JwtAuthenticationFilter를 UsernamePasswordAuthenticationFilter보다 앞으로 설정
//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider, redisTemplate), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint) // 토큰없는 사용자 요청시 unathorized error
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션 사용 X

                .and()
                .authorizeRequests() // 보호된 리소스 URI에 접근할 수 있는 권한 설정
                // 로그인, 회원가입 접근 허용
                .antMatchers("/**/signIn", "/**/signUp", "/**/user/findId/**", "/**/user/findPassword/**"
                        ,"/reissue").permitAll()
        // swagger 페이지 접근 허용
        /**
         * swagger 테스트 할때는 밑줄을 주석 처리하면 됩니다.
         */
                .anyRequest().authenticated(); // 다른 경로는 인증필요

        return http.build();
    }
    // CORS 허용 적용
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // configuration.setAllowedOriginPatterns();
        configuration.addAllowedOrigin("http://localhost:3000");
        // 추후 도메인 주소에 맞게 변경필요
        configuration.addAllowedOrigin("http://3.34.141.63:3001");
        configuration.addAllowedOrigin("http://localhost:8081");
        configuration.addAllowedOrigin("https://k8a308.p.ssafy.io");
        configuration.addAllowedOrigin("https://k8a308.p.ssafy.io/story/");
        configuration.addAllowedOrigin("http://k8a308.p.ssafy.io/story/");
        configuration.addAllowedOrigin("http://k8a308.p.ssafy.io");

//        configuration.addAllowedOrigin("http://3.34.141.63:443");
//        configuration.addAllowedOrigin("https://i8a805.p.ssafy.io");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);
        //configuration.setExposedHeaders(""); //

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
