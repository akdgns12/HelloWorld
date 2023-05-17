package com.project.helloworld.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StickerRequest {



    Long userSeq;

    Long boardSeq;

    Integer type;

    @Builder
    public StickerRequest(Long userSeq, Long boardSeq, Integer type) {
        this.userSeq = userSeq;
        this.boardSeq = boardSeq;
        this.type = type;
    }
}
