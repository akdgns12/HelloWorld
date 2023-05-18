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

    private int categorySeq;

    private String imgUrl ;

    @Builder
    public BoardModifyBody(Long boardSeq, String title, String content, int categorySeq, String imgUrl) {
        this.boardSeq = boardSeq;
        this.title = title;
        this.content = content;
        this.categorySeq = categorySeq;
        this.imgUrl = imgUrl;
    }
}
