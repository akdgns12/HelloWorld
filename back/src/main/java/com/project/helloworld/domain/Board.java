package com.project.helloworld.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.helloworld.util.BaseTimeEntity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends BaseTimeEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "board_seq")
  private Long boardSeq;

  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  @Column(name = "img_url")
  private String imgUrl;

  @Column(name = "like_cnt")
  private int likeCnt;

  @Column(name = "helpful_cnt")
  private int helpfulCnt;

  @Column(name = "understand_cnt")
  private int understandCnt;

  @JoinColumn(name = "user_seq", nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @JsonIgnore
  @OneToMany(mappedBy = "board")
  List<Comment> comments = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "board")
  List<Grass> grasses = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "board")
  List<Sticker> stickers = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "board")
  List<BookMark> bookMarks = new ArrayList<>();
}
