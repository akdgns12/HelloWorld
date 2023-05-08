package com.project.helloworld.domain;

import com.project.helloworld.util.BaseTimeEntity;

import javax.persistence.*;

import lombok.*;


@Entity
@Table(name = "guestbook")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guestbook extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "guestbook_seq")
  private Long guestbookSeq;

  @Column(name = "content")
  @Setter
  private String content;

  @Column(name = "guestbook_user_seq")
  private Long guestbookUserSeq;

  @Column(name = "guestbook_nickname")
  private String guestbookNickname;
  @Column(name = "is_secret")
  private boolean isSecret;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_seq", nullable = false)
  private User user;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "avatar_seq")
  private Avatar avatar;

  @Setter
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "guestbook_comment_seq")
  private Guestbook_Comment guestbook_comment;
}
