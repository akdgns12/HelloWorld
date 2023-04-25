package com.project.helloworld.controller;

import com.project.helloworld.dto.request.FamilyCommentBody;
import com.project.helloworld.dto.request.FamilyNameBody;
import com.project.helloworld.dto.request.FamilyRequestBody;
import com.project.helloworld.security.jwt.JwtTokenProvider;
import com.project.helloworld.service.FamilyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/family")
@RequiredArgsConstructor
public class familyController {

    private final FamilyService familyService;

    private final JwtTokenProvider jwtTokenProvider;

    // 일촌 조회
    @GetMapping("")
      ResponseEntity<?> getFamilies(@RequestParam("userSeq") Long userSeq,@RequestParam("status") String status,@RequestParam("hasComment") Boolean hasComment) throws Exception {
//        @RequestHeader("Authorization") String token
//        Long userSeq = jwtTokenProvider.getUserSeq(token);

        return ResponseEntity.ok().body(familyService.getFamilies(userSeq,status,hasComment));
    }




    @PostMapping("")
    ResponseEntity<?> requestFamily(@RequestBody FamilyRequestBody familyRequestBody) throws Exception {
//        @RequestHeader("Authorization") String token
//         Long fromUserSeq = jwtTokenProvider.getUserSeq(token);

        return ResponseEntity.ok().body(familyService.requestFamily(familyRequestBody.getFromUserSeq(),familyRequestBody.getToUserSeq(),familyRequestBody.getFromRelationName(),familyRequestBody.getToRelationName(),familyRequestBody.getRequestMessage()));
    }

    //일촌 수락
    @PutMapping("")
    ResponseEntity<?> acceptFamily( @RequestParam("familySeq") Long familySeq) throws Exception {

//        @RequestHeader("Authorization") String token,
        return ResponseEntity.ok().body(familyService.acceptFamily(familySeq));
    }
    // 일촌 거절
    @DeleteMapping("")
    ResponseEntity<?> deleteFamily( @RequestParam("familySeq") Long familySeq) throws Exception{
//        @RequestHeader("Authorization") String token,
        return ResponseEntity.ok().body(familyService.deleteFamily(familySeq));
    }

    // 일촌평 작성
    // 일촌평 수정
    // 일촌평 삭제
    @PutMapping("/comment")
    ResponseEntity<?> updateFamilyRelationComment( @RequestBody FamilyCommentBody familyCommentBody) throws Exception {
//        @RequestHeader("Authorization") String token ,
        return ResponseEntity.ok().body(familyService.updateFamilyRelationComment(familyCommentBody));
    }

    @PutMapping("/name")
    ResponseEntity<?> updateFamilyRelationName(@RequestBody FamilyNameBody familyNameBody) throws Exception {
        return ResponseEntity.ok().body(familyService.updateFamilyRelationName(familyNameBody));
    }

    // 일촌평 조회 (얘는 사실 필요 없을 듯?)
//    @GetMapping("/comment")
//    ResponseEntity<?> getFamilyComment(@RequestParam("userSeq") Long userSeq) throws Exception{
//
////        @RequestHeader("Authorization") String token
//        //        Long userSeq = jwtTokenProvider.getUserSeq(token);
//
//        return ResponseEntity.ok().body(familyService.getFamilyComment(userSeq));
//    }








}
