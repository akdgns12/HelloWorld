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
@Table(name = "family")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Family extends BaseTimeEntity {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "family_seq")
  private Long avatarSeq;

  @Column(name = "relation_name")
  private String relationName;

  @Column(name = "relation_comment")
  private String relationComment;

  @Column(name = "family_user_seq")
  private Long familyUserSeq;

  @Column(name = "accept")
  private boolean isAccepted;

  @Column(name = "family_user_nickname")
  private String familyUserNickname;





}
