package com.project.helloworld.interceptor;

import com.project.helloworld.security.jwt.JwtAuthenticationFilter;
import com.project.helloworld.security.jwt.JwtTokenProvider;
import com.project.helloworld.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class VisitorInterceptor implements HandlerInterceptor {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final VisitorService visitorService;
    private String ownerPrefix = "owner:";
    private String  todayVisitor = " todayVisitor";
    private String  totalVisitor = " totalVisitor";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ownerSeq = null;
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();

        if(methodName.equals("getBoard")){ // board로 접속할 때 userSeq 추출
            ownerSeq = request.getParameter("userSeq");
        }else if(methodName.equals("getUserMainInfo")){  // mainpage로 접속할 때 userSeq 추출
            String path = request.getRequestURI();
            String[] pathSplit = path.split("/");
            ownerSeq = pathSplit[3]; // 홈페이지 주인 seq
        }else return true; // 다른 경로에 대해서는 적용 안되게끔

        String token = jwtAuthenticationFilter.parseBearerToken(request);
        Long visitorSeq = jwtTokenProvider.getUserSeq(token); // 방문자 seq
        String visitorId = jwtTokenProvider.getUserEmail(token);

        if(Long.valueOf(ownerSeq) == visitorSeq || ownerSeq == null){ // 자기 홈페이지 조회시엔 카운팅 안되게끔
            return true;
        }

        // HyperLogLog을 사용하여 중복 방문자를 제거한 총 방문자 수 및 하루 방문자 수 갱신
        visitorService.addVisitor(ownerSeq, visitorId);

        return true;
    }
}
