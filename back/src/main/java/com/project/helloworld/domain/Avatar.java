package com.project.helloworld.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.helloworld.util.BaseTimeEntity;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "avatar")
@Getter
@Setter
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
  @OneToOne(mappedBy = "avatar")
  private User user;

  @JsonIgnore
  @OneToMany(mappedBy = "avatar")
  List<Accessories> accessories = new ArrayList<>();

}
