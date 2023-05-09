package com.project.helloworld.repository;

import com.project.helloworld.domain.TodayVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TodayVisitRepository extends JpaRepository<TodayVisit, Long> {
    @Query("SELECT m.todayCnt FROM TodayVisit m WHERE m.user.userSeq = :userSeq AND m.date = :date")
    Long findTodayCntByDateAndUserSeq(@Param("date") LocalDate date, @Param("userSeq") Long userSeq);
}
