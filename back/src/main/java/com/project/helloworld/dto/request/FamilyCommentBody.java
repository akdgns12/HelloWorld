package com.project.helloworld.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FamilyCommentBody {

    private Long fromUserSeq;
    private Long toUserSeq;
    private String comment;

    @Builder
    public FamilyCommentBody(Long fromUserSeq,Long toUserSeq, String comment) {
        this.fromUserSeq = fromUserSeq;
        this.toUserSeq = toUserSeq;
        this.comment = comment;
    }
}
