package com.project.helloworld.aoplog;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


  @Around("execution(* com.project.helloworld.service.*.*(..))")
  public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("Service Enter - Method: " + joinPoint.getSignature().getName());
    log.info("   Arguments: " + Arrays.toString(joinPoint.getArgs()));

    long startTime = System.currentTimeMillis(); // 추가

    Object result = null;
    try {
      result = joinPoint.proceed();
    } catch (Exception ex) {
      log.error("Exception caught in Service: " + ex.getMessage());
      throw ex; // re-throw the exception after logging
    }

    long endTime = System.currentTimeMillis(); // 추가
    log.info("   Performance Measurement: " + (endTime - startTime) + " milliseconds"); // 추가
    log.info("Service Exit - Method: " + joinPoint.getSignature().getName());

    return result;
  }

}