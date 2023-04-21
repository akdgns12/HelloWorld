package com.project.notify.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "notify")
public class Notify  {

  @Id
  private String notifySeq;
  private int type;
  private Long typeSeq;
  private String title;
  private String content;
  private boolean readState = false;
  private Long receiveUserSeq;
  private LocalDateTime createdTime;
}