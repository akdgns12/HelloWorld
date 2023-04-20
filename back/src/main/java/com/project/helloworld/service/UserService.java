package com.project.helloworld.service;

import com.project.helloworld.dto.UserRequestDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> signUp(UserRequestDto.SignUp signUp);
    ResponseEntity<?> signIn(UserRequestDto.SignIn signIn);
    ResponseEntity<?> reissue(UserRequestDto.Reissue reissue);
}
