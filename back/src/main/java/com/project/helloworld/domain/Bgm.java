package com.project.helloworld.domain;

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
@Table(name = "bgm")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bgm {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bgm_seq")
  private Long bgmSeq;

  @Column(name="video_id")
  private String videoId;

  @Column(name = "title")
  private String title;

  @Column(name = "artist")
  private String artist;



}
