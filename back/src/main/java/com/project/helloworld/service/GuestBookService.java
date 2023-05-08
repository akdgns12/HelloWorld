package com.project.helloworld.service;

import com.project.helloworld.dto.GuestBookDto;
import org.springframework.http.ResponseEntity;

public interface GuestBookService {
//    List<GuestBookDto.ResponseDto> getGuestBooks(Long userSeq) throws Exception;
    ResponseEntity<?> getGuestBooks(Long userSeq, int start, int size) throws Exception;
    ResponseEntity<?> addGuestBook(GuestBookDto.RequestDto requestDto) throws Exception;
    ResponseEntity<?> removeGuestBook(Long guestBookSeq);
    ResponseEntity<?> updateGuestBook(Long guestBookSeq, GuestBookDto.updateDto requestDto) throws Exception;
    ResponseEntity<?> addComment(Long guestBookSeq, GuestBookDto.CommentRequestDto requestDto) throws Exception;
    ResponseEntity<?> removeComment(Long commentSeq);
}
