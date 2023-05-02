package com.project.helloworld.dto.request;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StickerCreateBody {
    private Long userSeq;
    private Long boardSeq;

    private Integer type;

    @Builder
    public StickerCreateBody(Long userSeq, Long boardSeq, Integer type) {
        this.userSeq = userSeq;
        this.boardSeq = boardSeq;
        this.type = type;
    }
}
