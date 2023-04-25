package com.project.helloworld.service;

import com.project.helloworld.dto.response.GrassResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface GrassService {

    public ResponseEntity<?> getGrass(LocalDate startDate, LocalDate endDate, Long userSeq);
}
