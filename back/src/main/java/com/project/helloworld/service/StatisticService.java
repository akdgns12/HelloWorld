package com.project.helloworld.service;

import org.springframework.http.ResponseEntity;

public interface StatisticService {
    ResponseEntity<?> getStatisticInfo(Long userSeq) throws Exception;
}
