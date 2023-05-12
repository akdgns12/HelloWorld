package com.project.helloworld.dto;

import com.project.helloworld.dto.response.BoardCategoryCountResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class StatisticResponseDto {

    private StatisticInfo statisticInfo;

    @Getter
    @Setter
    @Builder
    public static class StatisticInfo{
        private int likeCnt;
        private int helpfulCnt;
        private int understandCnt;
        private List<BoardCategoryCountResponse> categoryInfo;
        private List<VisitorResponseDto.WeeklyTodayInfo> weeklyTodayInfoList;
    }

    public void setStatisticInfo(StatisticInfo statisticInfo) {
        this.statisticInfo = statisticInfo;
    }

    public void setWeeklyTodayInfoList(List<VisitorResponseDto.WeeklyTodayInfo> weeklyTodayInfoList) {
        this.statisticInfo.setWeeklyTodayInfoList(weeklyTodayInfoList);
    }

    public void setCategoryInfo(List<BoardCategoryCountResponse> categoryInfo){
        this.statisticInfo.setCategoryInfo(categoryInfo);
    }

    public List<VisitorResponseDto.WeeklyTodayInfo> getWeeklyTodayInfoList() {
        return this.statisticInfo.getWeeklyTodayInfoList();
    }
}
