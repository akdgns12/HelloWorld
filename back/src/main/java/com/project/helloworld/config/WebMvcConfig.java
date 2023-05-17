package com.project.helloworld.config;

import com.project.helloworld.interceptor.VisitorInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final VisitorInterceptor visitorInterceptor;

    @Override
        public void addInterceptors(InterceptorRegistry registry){
            registry.addInterceptor(visitorInterceptor)
                    // visitorInterceptor가 적용될 경로
                    .addPathPatterns("/user/mainpage/**", "/board/**");
    }
}
