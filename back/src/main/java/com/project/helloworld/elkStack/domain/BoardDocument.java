package com.project.helloworld.elkStack.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Setter
@Getter
@Document(indexName = "board", createIndex = true)
@Setting(settingPath = "settings-nori.json")
@Builder
public class BoardDocument {

  @Id
  private String id;

  @Field(type = FieldType.Text, analyzer = "nori_analyzer")
  private String title;

  @Field(type = FieldType.Text, analyzer = "nori_analyzer")
  private String content;

  @Field(type = FieldType.Text)
  private String imageUrl;

  @Builder.Default
  @Field(type = FieldType.Integer)
  private int likeCnt = 0;

  @Field(type = FieldType.Text)
  private String createTime;

  @Field(type = FieldType.Long)
  private Long userSeq;

  @Field(type = FieldType.Text)
  private String nickname;

  @Field(type = FieldType.Text)
  private String modifiedTime;

  @Field(type = FieldType.Long)
  private Long boardSeq;

  @Builder.Default
  @Field(type = FieldType.Long)
  private Integer commentCnt = 0;

}
