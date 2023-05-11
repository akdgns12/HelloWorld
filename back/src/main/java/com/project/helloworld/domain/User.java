package com.project.helloworld.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.helloworld.security.oauth2.AuthProvider;
import com.project.helloworld.util.BaseTimeEntity;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_seq")
  private Long userSeq;

  @Column(name = "password")
  private String password;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "nickname")
  private String nickname;

  @Column(name = "name")
  private String name;

  @Column(name = "comment")
  private String comment;

  @Column(name = "phone_number", unique = true)
  private String phoneNumber;

  @Column(name = "like_cnt")
  @ColumnDefault("0")
  private int likeCnt;

  @Column(name = "helpful_cnt")
  @ColumnDefault("0")
  private int helpfulCnt;

  @Column(name = "understand_cnt")
  @ColumnDefault("0")
  private int understandCnt;

  @Enumerated(EnumType.STRING)
  private AuthProvider authProvider;

  @Column(name = "providerId")
  private String providerId;

  @Column(name = "total")
  private Long total;

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
  @JsonIgnore
  @JoinColumn(name = "avatar_seq")
  private Avatar avatar;

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  List<Grass> grasses = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  List<Badge> badges = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  List<BookMark> bookMarks = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  List<Sticker> stickers = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  List<TodayVisit> todayVisits = new ArrayList<>();

  /**
   * Security 관련 메소드
   */
  @Column
  @ElementCollection(fetch = FetchType.EAGER)
  @Builder.Default
  private List<String> roles = new ArrayList<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.roles.stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
