package com.project.helloworld.domain;

import com.project.helloworld.util.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "grass")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Grass extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grass_seq")
    private Long grassSeq;

    private LocalDate grassDate;

    @JoinColumn(name = "user_seq", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "board_seq", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
}
