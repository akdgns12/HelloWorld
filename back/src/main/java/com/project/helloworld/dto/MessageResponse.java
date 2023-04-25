package com.project.helloworld.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MessageResponse {



    private String message;

    @Builder
    public MessageResponse( String message) {

        this.message = message;
    }
}
