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
  private String content;

  @Column(name = "guestbook_user_seq")
  private Long guestbookUserSeq;

  @Column(name = "guestbook_nickname")
  private String guestbookNickname;




}
