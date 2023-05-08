package com.project.helloworld.elkStack.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "keyword_count", createIndex = true)
@Builder
public class KeywordCountDocument {

  @Id
  private String keyword;

  private int count;

}
