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

  @JsonIgnore
  @OneToMany(mappedBy = "avatar")
  List<Accessories> accessories = new ArrayList<>();

}
