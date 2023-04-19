package com.project.helloworld.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value=Exception.class)
    public ResponseEntity exception(Exception e){
        System.out.println("===================CATCH EXECPTION===================");
        System.out.println(e.getClass());
        System.out.println(e.getLocalizedMessage());
        System.out.println("=====================================================");
        Map<String, String> map = new HashMap<>();
        map.put("message", e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
    }
}
