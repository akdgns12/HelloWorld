package com.project.helloworld.repository;

import com.project.helloworld.domain.TodayVisit;
import com.project.helloworld.dto.VisitorResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TodayVisitRepository extends JpaRepository<TodayVisit, Long> {
    @Query("SELECT m.todayCnt FROM TodayVisit m WHERE m.user.userSeq = :userSeq AND m.date = :date")
    Long findTodayCntByDateAndUserSeq(@Param("date") LocalDate date, @Param("userSeq") Long userSeq);
    @Query("SELECT m.date, m.todayCnt FROM TodayVisit m WHERE m.user.userSeq = :userSeq AND m.date BETWEEN :startDate AND :endDate")
    List<Object []> findByTodayCntListByUserSeq(@Param("userSeq") Long userSeq, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
