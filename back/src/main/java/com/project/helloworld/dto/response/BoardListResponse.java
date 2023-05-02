package com.project.helloworld.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@Data
public class BoardListResponse {

    private Long boardSeq;

    private String title;

    private String writer;

    private LocalDateTime createTime;

    private int viewCnt;

    @Builder
    public BoardListResponse(Long boardSeq, String title, String writer, LocalDateTime createTime, int viewCnt) {
        this.boardSeq = boardSeq;
        this.title = title;
        this.writer = writer;
        this.createTime = createTime;
        this.viewCnt = viewCnt;
    }
}
