package com.project.helloworld.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FamilyNameBody {

    private Long fromUserSeq;
    private Long toUserSeq;
    private String name;

    @Builder
    public FamilyNameBody(Long fromUserSeq,Long toUserSeq, String name) {
        this.fromUserSeq = fromUserSeq;
        this.toUserSeq = toUserSeq;
        this.name = name;
    }
}
