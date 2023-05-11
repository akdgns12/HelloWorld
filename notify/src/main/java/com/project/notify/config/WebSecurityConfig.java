package com.project.notify.config;

import com.project.notify.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig {

  @Autowired
  private JwtTokenProvider jwtTokenProvider;


  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

    ReactiveAuthenticationManager reactiveAuthenticationManager = (authentication) -> Mono.just(authentication);

    AuthenticationWebFilter jwtAuthenticationFilter = new AuthenticationWebFilter(reactiveAuthenticationManager);
    jwtAuthenticationFilter.setServerAuthenticationConverter(createServerAuthenticationConverter());
    return http.csrf().disable()
        .httpBasic().disable()
        .formLogin().disable()
        .logout().disable()
        .cors().and()
        .authorizeExchange()
        .pathMatchers(HttpMethod.OPTIONS).permitAll()
        .anyExchange().authenticated()
        .and()
        .addFilterAt(jwtAuthenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)
        .build();
  }

  private ServerAuthenticationConverter createServerAuthenticationConverter() {
    return exchange -> {
      String accessToken = getAccessTokenFromRequest(exchange);
      if (accessToken != null) {
        Authentication authentication = jwtTokenProvider.getAuthentication(accessToken);
        return Mono.justOrEmpty(authentication);
      }
      return Mono.empty();
    };
  }

  private String getAccessTokenFromRequest(ServerWebExchange exchange) {
    String authorizationHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      return authorizationHeader.substring(7);
    }
    return null;
  }
}
