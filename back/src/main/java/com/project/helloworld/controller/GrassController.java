package com.project.helloworld.controller;


import com.project.helloworld.dto.response.GrassResponse;
import com.project.helloworld.service.GrassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/grass")
@RequiredArgsConstructor
public class GrassController {

    private final GrassService grassService;
    @GetMapping("")
    public ResponseEntity<?> getGrass( @RequestParam("startDate") String startDate , @RequestParam("endDate") String endDate,@RequestParam("userSeq") Long userSeq){
        //        Long userSeq = jwtTokenProvider.getUserSeq(token);
//        Long userSeq = 1L;
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);

        List<GrassResponse> grassResponse = null;
        return ResponseEntity.ok().body(grassService.getGrass(start,end,userSeq));
    }
}
