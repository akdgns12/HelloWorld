package com.project.helloworld.domain;

import com.project.helloworld.util.BaseTimeEntity;

import java.util.Date;
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
@Table(name = "comment")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends BaseTimeEntity {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "comment_seq")
  private Long commentSeq;

  @Column(name = "user_seq")
  private Long userSeq;

  @Column(name = "content")
  private String content;

  @Column(name = "date")
  private Date date;




}
