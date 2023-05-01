package com.project.helloworld.dto;

import com.project.helloworld.domain.Avatar;
import com.project.helloworld.security.oauth2.AuthProvider;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class UserResponseDto {

    @Getter
    @Setter
    @Builder
    public static class TokenInfo {
        private Long userSeq;
        private String grantType;
        private String accessToken;
        private Long accessTokenExpiresIn;
        private String refreshToken;
        private Long refreshTokenExpirationTime;
    }

    @Getter
    @Setter
    @Builder
    public static class UserInfo{
        private Long userSeq;
        private String email;
        private String name;
        private String nickname;
        private String phoneNumber;
        private String providerId;
        private AuthProvider authProvider;
        private int today;
        private int total;
        private Avatar avatar;
        private String backgroundUrl;
        private String bgmUrl;
    }
}
