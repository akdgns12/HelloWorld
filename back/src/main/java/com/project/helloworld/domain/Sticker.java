package com.project.helloworld.domain;

import com.project.helloworld.util.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sticker")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sticker extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sticker_seq")
    private Long stickerSeq;

    @Column(name = "type")
    private int type;

    @JoinColumn(name = "board_seq", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
    
    @JoinColumn(name = "user_seq", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
