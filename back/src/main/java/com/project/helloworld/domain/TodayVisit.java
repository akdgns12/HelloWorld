package com.project.helloworld.domain;

import com.project.helloworld.util.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "today_visit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodayVisit extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "today_visit_seq")
    private Long todayVisitSeq;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "today_cnt")
    private Long todayCnt;

    @JoinColumn(name = "user_seq", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
