package com.project.helloworld.dto;

import com.project.helloworld.domain.Avatar;
import com.project.helloworld.dto.response.GrassResponse;
import com.project.helloworld.security.oauth2.AuthProvider;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
        private String comment;
        private String phoneNumber;
        private String providerId;
        private AuthProvider authProvider;
        private Long today;
        private Long total;
        private Avatar avatar;
        private String backgroundUrl;
        private String bgmUrl;
    }

    @Getter
    @Setter
    @Builder
    public static class UserMainInfo{
        private Long userSeq;
        private String email;
        private String name;
        private String nickname;
        private String comment;
        private String phoneNumber;
        private String providerId;
        private AuthProvider authProvider;
        private Long today;
        private Long total;
        private Avatar avatar;
        private String backgroundUrl;
        private String bgmUrl;
        private List<GrassResponse> grassList;
        private List<FamilyResponseDto> familyResponseDtos;

        public void getFamilyResponseDtos(Object body) {
            this.familyResponseDtos = (List<FamilyResponseDto>) body;
        }

        public void getGrassList(Object body) {
            this.grassList = (List<GrassResponse>) body;
        }
    }
}
