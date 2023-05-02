package com.project.helloworld.dto.request;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CommentCreateBody {

    private Long boardSeq;

    private Long userSeq;

    private String content;

    @Builder
    public CommentCreateBody(Long boardSeq, Long userSeq, String content) {
        this.boardSeq = boardSeq;
        this.userSeq = userSeq;
        this.content = content;
    }
}
