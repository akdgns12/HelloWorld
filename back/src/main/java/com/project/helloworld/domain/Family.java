package com.project.helloworld.domain;

import com.project.helloworld.util.BaseTimeEntity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "family")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Family extends BaseTimeEntity {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "family_seq")
  private Long familySeq;

  @Column(name = "relation_name")
  private String relationName;

  @Column(name = "relation_comment")
  private String relationComment;



  @Column(name = "accept")
  private Integer isAccepted;

  @Column(name = "family_user_nickname")
  private String familyUserNickname;

  @Column(name="request_message")
  private String requestMessage;

  @JoinColumn(name="family_user_seq",nullable = false)
  @ManyToOne(fetch=FetchType.LAZY)
  private User familyUser;
  @JoinColumn(name = "user_seq", nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

}
