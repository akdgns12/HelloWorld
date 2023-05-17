package com.project.helloworld.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class BoardsAllResponse {

    private Long boardSeq;

    private String title;

    private String writer;

    private String content;

    private Integer categorySeq;

    private String imgUrl;

    private int likeCnt;

    private int commentCnt;

    private Long writerSeq;

    @Builder
    public BoardsAllResponse(Long boardSeq, String title, String writer, String content, String imgUrl, Integer categorySeq, int likeCnt, int commentCnt, Long writerSeq) {
        this.boardSeq = boardSeq;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.categorySeq = categorySeq;
        this.imgUrl = imgUrl;
        this.likeCnt = likeCnt;
        this.commentCnt = commentCnt;
        this.writerSeq = writerSeq;
    }
}
