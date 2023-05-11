package com.project.notify.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class CorsConfig implements WebFluxConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("http://localhost:3000") // 여기서 '*' 대신 허용하려는 도메인을 명시할 수 있습니다.
        .allowedMethods("*")
        .allowedHeaders("*")
        .allowCredentials(true);
  }

}
