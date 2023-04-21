package com.project.helloworld.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.helloworld.util.BaseTimeEntity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "bgm_url")
  private String bgmUrl;

  @Column(name = "provider")
  private int provider;

  @Column(name = "today")
  private int today;

  @Column(name = "total")
  private int total;

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
