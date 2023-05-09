package com.project.helloworld.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class VisitorResponseDto {

    @Getter
    @Setter
    @Builder
    public static class WeeklyTodayInfo{
        private LocalDate date;
        private Long today;
    }

    public static List<WeeklyTodayInfo> mapToWeeklyTodayInfoList(List<Object[]> data) {
        return data.stream()
                .map(row -> WeeklyTodayInfo.builder()
                        .date((LocalDate) row[0])
                        .today((Long) row[1])
                        .build())
                .collect(Collectors.toList());
    }
}
