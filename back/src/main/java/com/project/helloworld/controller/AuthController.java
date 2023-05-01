package com.project.helloworld.controller;

import com.project.helloworld.dto.AuthResponse;
import com.project.helloworld.dto.UserRequestDto;
import com.project.helloworld.dto.UserResponseDto;
import com.project.helloworld.security.jwt.JwtTokenProvider;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @ApiOperation(value = "소셜 로그인")
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody UserRequestDto.OauthSignIn oauthSignIn) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        oauthSignIn.getEmail(),
                        oauthSignIn.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserResponseDto.TokenInfo token = jwtTokenProvider.generateToken(authentication);

        String accessToken = token.getAccessToken();
        System.out.println("auth controller" + accessToken);
        return ResponseEntity.ok(new AuthResponse(accessToken));
    }
}
