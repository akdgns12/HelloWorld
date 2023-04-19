package com.project.helloworld.service;

import com.project.helloworld.dto.GuestBookDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GuestBookService {
//    List<GuestBookDto.ResponseDto> getGuestBooks(Long userSeq) throws Exception;
    ResponseEntity<?> getGuestBooks(Long userSeq) throws Exception;
    ResponseEntity<?> addGuestBook(GuestBookDto.RequestDto requestDto, Long userSeq) throws Exception;
    ResponseEntity<?> removeGuestBook(Long guestBookSeq);
    ResponseEntity<?> updateGuestBook(Long guestBookSeq, GuestBookDto.RequestDto requestDto) throws Exception;
}
