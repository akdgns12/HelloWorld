package com.project.helloworld.dto.request;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FamilyRequestBody {

    private Long fromUserSeq;

    private Long toUserSeq;

    private String fromRelationName;

    private String toRelationName;

    private String requestMessage;

    @Builder
    public FamilyRequestBody(Long fromUserSeq, Long toUserSeq, String fromRelationName, String toRelationName,String requestMessage) {
        this.fromUserSeq = fromUserSeq;
        this.toUserSeq = toUserSeq;
        this.fromRelationName = fromRelationName;
        this.toRelationName = toRelationName;
        this.requestMessage = requestMessage;
    }
}
