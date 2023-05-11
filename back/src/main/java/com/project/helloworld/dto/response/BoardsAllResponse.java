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

    private String imgUrl;

    private int likeCnt;

    private int commentCnt;



    @Builder
    public BoardsAllResponse(Long boardSeq, String title, String writer, String content, String imgUrl, int likeCnt, int commentCnt) {
        this.boardSeq = boardSeq;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.imgUrl = imgUrl;
        this.likeCnt = likeCnt;
        this.commentCnt = commentCnt;
    }
}
