package com.project.helloworld.dto.response;

import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BgmList {

  private Long bgmSeq;

  private String videoId;

  private String title;

  private String artist;
}
