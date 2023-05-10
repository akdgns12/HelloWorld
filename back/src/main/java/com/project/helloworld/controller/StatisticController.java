package com.project.helloworld.controller;

import com.project.helloworld.service.StatisticService;
import com.project.helloworld.service.VisitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/statistic")
@Api(tags = "통계 API")
public class StatisticController {

    private final StatisticService statisticService;

    @ApiOperation(value = "통계 페이지에 필요한 정보 조회", notes = "userSeq 인자로 받음")
    @GetMapping("/{userSeq}")
    public ResponseEntity<?> getStatistics(@Validated @RequestParam Long userSeq) throws Exception {
        log.debug("userSeq ", userSeq);

        return statisticService.getStatisticInfo(userSeq);
    }
}
