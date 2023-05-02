package com.project.helloworld.dto.request;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CommentModifyBody {

    private Long commentSeq;

    private String content;

    @Builder
    public CommentModifyBody(Long commentSeq, String content) {
       this.commentSeq = commentSeq;
        this.content = content;
    }
}
