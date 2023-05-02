package com.project.helloworld.domain;

import com.project.helloworld.util.BaseTimeEntity;

import java.util.Date;
import javax.persistence.*;

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



  @Column(name = "content")
  private String content;

  @Column(name = "date")
  private Date date;

  @JoinColumn(name = "user_seq",nullable = false)
  @ManyToOne(fetch=FetchType.LAZY)
  private User user;

  @JoinColumn(name = "board_seq", nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Board board;


}
