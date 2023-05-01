package com.project.helloworld.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private String accessToken;
    private String tokenTyp = "Bearer ";

    public AuthResponse(String accessToken){
        this.accessToken = accessToken;
    }
}
