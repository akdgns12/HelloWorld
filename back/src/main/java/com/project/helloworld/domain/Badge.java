package com.project.helloworld.domain;

import com.project.helloworld.util.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "badge")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Badge extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "badge_seq")
    private String badgeSeq;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "type")
    private int type;

    @JoinColumn(name = "user_seq", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
