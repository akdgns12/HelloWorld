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
@Table(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_seq")
  private Long userSeq;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;

  @Column(name = "nickname")
  private String nickname;

  @Column(name = "name")
  private String name;

  @Column(name = "bgm_url")
  private String bgmUrl;

  @Column(name = "provider")
  private int provider;

  @Column(name = "today")
  private int today;

  @Column(name = "total")
  private int total;

  @Column(name = "refresh_token")
  private String refreshToken;

  @Column(name = "background_url")
  private String backgroundUrl;

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  List<Board> boards = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  List<Guestbook> guestbooks = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  List<Family> families = new ArrayList<>();

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "avatar_seq")
  private Avatar avatar;
}
