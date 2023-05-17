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

  @Around("execution(* com.project.helloworld.controller.*.*(..))")
  public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {

    log.info("--> {} : {}() | Arguments: {}", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));

    long startTime = System.currentTimeMillis();

    Object result = null;
    try {
      result = joinPoint.proceed();
    } catch (Exception ex) {
      log.error("!!! Exception caught in Controller: " + ex.getMessage());
      throw ex;
    }

    long endTime = System.currentTimeMillis();

    log.info("<-- {} : {}() | Performance Measurement: {} milliseconds", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), (endTime - startTime));

    return result;
  }

  @Around("execution(* com.project.helloworld.service.*.*(..))")
  public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {



    log.info("--------> {} : {}() | Arguments: {}" , joinPoint.getTarget().getClass().getSimpleName(),joinPoint.getSignature().getName(),Arrays.toString(joinPoint.getArgs()));

    long startTime = System.currentTimeMillis();

    Object result = null;
    try {
      result = joinPoint.proceed();
    } catch (Exception ex) {
      log.error("!!!!!!!!! Exception caught in Service: " + ex.getMessage());
      throw ex;
    }

    long endTime = System.currentTimeMillis();

    log.info("<-------- {} : {}() | Performance Measurement: {} milliseconds", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), (endTime - startTime));

    return result;
  }


}