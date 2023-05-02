package com.project.helloworld.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class BoardModifyBody {

    private Long boardSeq;

    private String title;

    private String content;



    @Builder
    public BoardModifyBody(Long boardSeq, String title, String content) {
        this.boardSeq = boardSeq;
        this.title = title;
        this.content = content;

    }
}
