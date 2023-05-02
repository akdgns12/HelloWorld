package com.project.helloworld.service;


import com.project.helloworld.domain.Family;
import com.project.helloworld.domain.User;
import com.project.helloworld.dto.FamilyResponseDto;
import com.project.helloworld.dto.GuestBookDto;
import com.project.helloworld.dto.MessageResponse;
import com.project.helloworld.dto.request.FamilyCommentBody;
import com.project.helloworld.dto.request.FamilyNameBody;
import com.project.helloworld.repository.FamilyRepository;
import com.project.helloworld.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class FamilyServiceImpl implements FamilyService {


    private final FamilyRepository familyRepository;

    private final UserRepository userRepository;
    @Override
    public ResponseEntity<?> getFamilies(Long userSeq,String status,Boolean hasComment) throws Exception {
        User user = userRepository.findById(userSeq).orElseThrow(()-> new Exception("not exist user : " + userSeq));
        List<Family> family = user.getFamilies();
        List<FamilyResponseDto> familyResponseDtos;
        switch(status){
            case "accepted":
                if(hasComment){

                familyResponseDtos = family.stream()
                        .filter(data -> data.getIsAccepted() == 2 && data.getRelationComment() != null ).map(x -> new FamilyResponseDto(x)).collect(Collectors.toList());
                }else{

                familyResponseDtos = family.stream().filter(data -> data.getIsAccepted() == 2 ).map(x -> new FamilyResponseDto(x)).collect(Collectors.toList());
                }
                break;
            case "request":
                familyResponseDtos = family.stream().filter(data -> data.getIsAccepted() == 0 ).map(x -> new FamilyResponseDto(x)).collect(Collectors.toList());
                break;
            case "requested":
                familyResponseDtos = family.stream().filter(data -> data.getIsAccepted() == 1 ).map(x -> new FamilyResponseDto(x)).collect(Collectors.toList());
                break;
            case "all":
                familyResponseDtos = family.stream().map(x -> new FamilyResponseDto(x)).collect(Collectors.toList());
                break;
            default:
                familyResponseDtos = null;
                break;

        }


        return new ResponseEntity<>(familyResponseDtos,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getFamily(Long familySeq) throws Exception {
        Family family = familyRepository.findById(familySeq).orElseThrow(() -> new Exception("not exist user : " + familySeq));
        return ResponseEntity.ok().body(family);
    }


    // 일촌 요청을 보내!!!
    // 반대도 저장
    @Override
    public ResponseEntity<?> requestFamily(Long userSeq, Long toUserSeq,String fromRelationName,String toRelationName,String requestMessage) throws Exception {
        User user = userRepository.findById(userSeq).orElseThrow(() -> new Exception("not exist user : " + userSeq));
        Family family = Family.builder().relationName(fromRelationName).isAccepted(1).user(user).familyUserSeq(toUserSeq).requestMessage("호호호").
                build();
        familyRepository.save(family);
        // 반대방향도 저장
        User userReverse = userRepository.findById(toUserSeq).orElseThrow(() -> new Exception("not exist user: " + toUserSeq));
        Family familyReverse = Family.builder().relationName(toRelationName).isAccepted(0).user(userReverse).familyUserSeq(userSeq).requestMessage("호호호").build();
        familyRepository.save(familyReverse);
        MessageResponse messageResponse = MessageResponse.builder().message("요청을 보냈습니다.").build();
        return ResponseEntity.ok().body(messageResponse);
    }

    @Override
    public ResponseEntity<?> acceptFamily(Long familySeq) throws Exception {
        // 정방향 수락
        Family family = familyRepository.findById(familySeq).orElseThrow(() -> new Exception("not exist family relation : "+familySeq));
        Family newFamily = family.builder().familySeq(family.getFamilySeq())
                .relationName(family.getRelationName()).relationComment(family.getRelationComment())
                .familyUserSeq(family.getFamilyUserSeq()).isAccepted(2).familyUserNickname(family.getFamilyUserNickname())
                .requestMessage(family.getRequestMessage()).user(family.getUser())
                .build();
        familyRepository.save(newFamily);
        // 반대 방향도 수락 해야지 familySeq 구한다음
        Long familySeqReverse = familyRepository.findByUsers(family.getFamilyUserSeq(),family.getUser().getUserSeq());
        // 그다음 진행

        Family familyReverse = familyRepository.findById(familySeqReverse).orElseThrow(() -> new Exception("not exist family relation : "+family.getFamilyUserSeq()));
        Family newFamilyReverse = family.builder().familySeq(familyReverse.getFamilySeq())
                        .relationName(familyReverse.getRelationName()).relationComment(familyReverse.getRelationComment())
                .familyUserSeq(familyReverse.getFamilyUserSeq()).isAccepted(2).familyUserNickname(familyReverse.getFamilyUserNickname())
                .requestMessage(family.getRequestMessage()).user(familyReverse.getUser())
                .build();
        familyRepository.save(newFamilyReverse);
        MessageResponse messageResponse = MessageResponse.builder().message("일촌 수락 하셨습니다.").build();

        return ResponseEntity.ok().body(messageResponse);
    }

    @Override
    public ResponseEntity<?> deleteFamily(Long familySeq) throws Exception {
        Family family = familyRepository.findById(familySeq).orElseThrow(() ->new Exception("not exist family relation : "+familySeq));
        Long familySeqReverse = familyRepository.findByUsers(family.getFamilyUserSeq(),family.getUser().getUserSeq());
        System.out.println(familySeq);
        System.out.println(familySeqReverse);
        // 정방향
        familyRepository.deleteById(familySeq);
        // 역방향
        familyRepository.deleteById(familySeqReverse);
        MessageResponse messageResponse = MessageResponse.builder().message("일촌이 끊어졌습니다.").build();
        return ResponseEntity.ok().body(messageResponse);
    }



    @Override
    public ResponseEntity<?> updateFamilyRelationComment(FamilyCommentBody familyCommentBody) throws Exception {
        Family family = familyRepository.findById(familyCommentBody.getFamilySeq()).orElseThrow(() -> new Exception("not exist familySeq : "+familyCommentBody.getFamilySeq()));
        Family newFamily = family.builder().familySeq(family.getFamilySeq())
                .relationName(family.getRelationName()).relationComment(familyCommentBody.getComment())
                .familyUserSeq(family.getFamilyUserSeq()).isAccepted(family.getIsAccepted()).familyUserNickname(family.getFamilyUserNickname())
                .requestMessage(family.getRequestMessage()).user(family.getUser())
                .build();
        familyRepository.save(newFamily);
        MessageResponse messageResponse = MessageResponse.builder().message("일촌평이 수정되었습니다.").build();
        return ResponseEntity.ok().body(messageResponse);
    }

    @Override
    public ResponseEntity<?> updateFamilyRelationName(FamilyNameBody familyNameBody) throws Exception {
        Family family = familyRepository.findById(familyNameBody.getFamilySeq()).orElseThrow(() -> new Exception("not exist familySeq : "+familyNameBody.getFamilySeq()));
        Family newFamily = family.builder().familySeq(family.getFamilySeq())
                        .relationName(familyNameBody.getName()).relationComment(family.getRelationComment())
                        .familyUserSeq(family.getFamilyUserSeq()).isAccepted(family.getIsAccepted()).familyUserNickname(family.getFamilyUserNickname())
                        .requestMessage(family.getRequestMessage()).user(family.getUser())
                .build();
        familyRepository.save(newFamily);
        MessageResponse messageResponse = MessageResponse.builder().message("일촌명이 수정되었습니다.").build();
        return ResponseEntity.ok().body(messageResponse);
    }


    @Override
    public ResponseEntity<?> randomWind(Long userSeq) throws Exception {

        User user = userRepository.findById(userSeq).orElseThrow(() -> new Exception("not exist user : "+userSeq));
        List<Family> families = user.getFamilies();
        List<Long> familiesSeq = families.stream().map(x -> x.getFamilyUserSeq()).collect(Collectors.toList());
       int index = (int)(Math.random()*familiesSeq.size());
        User newUser = userRepository.findById(familiesSeq.get(index)).orElseThrow(() -> new Exception("not exist user : "+userSeq));
        return ResponseEntity.ok().body(newUser);
    }


}
