package com.project.helloworld.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FamilyResponse {
    String fromNickName;

    String toNickName;

    String fromRelationName;

    String toRelationName;

    String requestMessage;

    @Builder
    public FamilyResponse(String fromNickName, String toNickName, String fromRelationName, String toRelationName, String requestMessage) {
        this.fromNickName = fromNickName;
        this.toNickName = toNickName;
        this.fromRelationName = fromRelationName;
        this.toRelationName = toRelationName;
        this.requestMessage = requestMessage;
    }
}
