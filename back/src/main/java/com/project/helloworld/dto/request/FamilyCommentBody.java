package com.project.helloworld.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FamilyCommentBody {

    private Long familySeq;
    private String comment;

    @Builder
    public FamilyCommentBody(Long familySeq, String comment) {
        this.familySeq = familySeq;
        this.comment = comment;
    }
}
