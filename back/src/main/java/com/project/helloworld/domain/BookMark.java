package com.project.helloworld.domain;

import com.project.helloworld.util.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bookmark")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookMark extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookmark_seq")
    private Long bookmarkSeq;

    @JoinColumn(name = "user_seq", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "board_seq", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
}
