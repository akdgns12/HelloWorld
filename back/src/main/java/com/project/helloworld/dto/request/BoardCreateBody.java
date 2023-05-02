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



    @Builder
    public BoardCreateBody(Long userSeq, String title, String content) {
        this.userSeq = userSeq;
        this.title = title;
        this.content = content;

    }
}
