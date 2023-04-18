package com.project.helloworld.domain;

import com.project.helloworld.util.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


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

  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "likes")
  private int likes;


}
