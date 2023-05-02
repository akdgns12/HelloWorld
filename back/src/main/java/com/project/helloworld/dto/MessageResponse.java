package com.project.helloworld.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MessageResponse {


    private Integer type;

    private Long typeSeq;

    private String title;

    private String content;

    private Long receiveUserSeq;

    @Builder
    public MessageResponse(Integer type, Long typeSeq, String title, String content, Long receiveUserSeq) {
        this.type = type;
        this.typeSeq = typeSeq;
        this.title = title;
        this.content = content;
        this.receiveUserSeq = receiveUserSeq;
    }
}
