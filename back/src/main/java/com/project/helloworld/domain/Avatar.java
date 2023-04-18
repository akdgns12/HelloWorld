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
@Table(name = "avatar")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Avatar extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "avatar_seq")
  private Long avatarSeq;

  @Column(name = "img_url")
  private String imgUrl;



}
