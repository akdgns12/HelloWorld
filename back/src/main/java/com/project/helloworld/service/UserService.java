package com.project.helloworld.service;

import com.project.helloworld.dto.UserRequestDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> signUp(UserRequestDto.SignUp signUp);
    ResponseEntity<?> signIn(UserRequestDto.SignIn signIn) throws Exception;
    ResponseEntity<?> reissue(UserRequestDto.Reissue reissue);
    ResponseEntity<?> getUserInfo(Long userSeq) throws Exception;
    ResponseEntity<?> getUserMainInfo(Long userSeq) throws Exception;
    ResponseEntity<?> modify(UserRequestDto.Modify modify) throws Exception;
    ResponseEntity<?> changePassword(UserRequestDto.ChangePassword changePassword) throws Exception;
    ResponseEntity<?> delete(Long userSeq) throws Exception;
    ResponseEntity<?> certifiedEmail(String email) throws Exception;
    ResponseEntity<?> confirmEmail(UserRequestDto.EmailCertify emailCertify) throws Exception;
    ResponseEntity<?> certifiedPhoneNumber(String phoneNumber) throws Exception;
    ResponseEntity<?> confirmMessage(UserRequestDto.SmsCertify smsCertify) throws Exception;
    ResponseEntity<?> logout(UserRequestDto.Logout logout) throws Exception;


}
