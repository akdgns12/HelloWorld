package com.project.helloworld.security.oauth2;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 사용자가 인증 없이 보호된 리소스에 액세스하려고 할 때 호출, 이 경우 401 반환
@Slf4j
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        log.debug("Responding unauthorized error ", authException.getLocalizedMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                authException.getLocalizedMessage());
    }
}
