package com.project.helloworld.controller;

import com.project.helloworld.dto.UserRequestDto;
import com.project.helloworld.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Api(tags = "User API")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "회원가입", notes = "id, email, password, nickname, name")
    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@Validated @RequestBody UserRequestDto.SignUp signUp){
        log.debug("singUp", signUp);

        return userService.signUp(signUp);
    }

    @ApiOperation(value = "일반 로그인", notes = "id, password")
    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@Validated @RequestBody UserRequestDto.SignIn signIn){
        log.debug("SignIn", signIn);

        return userService.signIn(signIn);
    }

    @ApiOperation(value = "토큰 갱신", notes = "accessToken, refreshToken")
    @PostMapping("/reissue")
    public ResponseEntity<?> reissue(@Validated @RequestBody UserRequestDto.Reissue reissue){
        log.debug("reissueInfo", reissue);

        return userService.reissue(reissue);
    }
}
