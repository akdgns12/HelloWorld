package com.project.helloworld.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class BoardCreateBody {

    Long userSeq;

    String title;

    String content;

    Integer categorySeq;



    @Builder
    public BoardCreateBody(Long userSeq, String title, String content, Integer categorySeq) {
        this.userSeq = userSeq;
        this.title = title;
        this.content = content;
        this.categorySeq = categorySeq;

    }
}
