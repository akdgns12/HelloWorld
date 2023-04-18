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
@Table(name = "accessories")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Accessories extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "accessories_seq")
  private Long accessoresSeq;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;

  @Column(name = "img_url")
  private String imgUrl;


}
