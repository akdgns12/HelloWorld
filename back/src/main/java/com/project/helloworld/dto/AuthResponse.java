package com.project.helloworld.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private Long userSeq;
    private String accessToken;
    private String refreshToken;

    public AuthResponse(Long userSeq, String accessToken, String refreshToken){
        this.userSeq = userSeq;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
