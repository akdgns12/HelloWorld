package com.project.helloworld.service;

import com.project.helloworld.dto.VisitorResponseDto;

import java.util.List;

public interface VisitorService {
    void addVisitor(String email, String visitorId);
    Long getTotalVisitors(String ownerSeq);
    Long getTodayVisitors(String ownerSeq);
    void expireTodayVisitors(String ownerSeq);
    List<VisitorResponseDto.WeeklyTodayInfo> getWeeklyToday(Long userSeq) throws Exception;
}
