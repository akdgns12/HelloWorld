package com.project.helloworld.controller;


import com.project.helloworld.dto.GuestBookDto;
import com.project.helloworld.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guestbook")
@Slf4j
public class GuestBookController {
    private final GuestBookService guestBookService;

    @GetMapping("/{userSeq}")
    ResponseEntity<?> getGuestBook(@PathVariable Long userSeq) throws Exception{
        log.info("userSeq: {}", userSeq);
        return guestBookService.getGuestBooks(userSeq);
    }

    @PostMapping("/{userSeq}")
    ResponseEntity<?> addGuestBooK( @PathVariable("userSeq") Long userSeq, @RequestBody GuestBookDto.RequestDto requestDto) throws Exception{
        log.info("write userSeq: {}", requestDto.getUserSeq());
        log.info("read userSeq: {}", userSeq);
        return guestBookService.addGuestBook(requestDto,userSeq);
    }

    @DeleteMapping("/{guestbook_seq}")
    ResponseEntity<?> removeGuestBook(@PathVariable("guestbook_seq") Long guestBookSeq) throws Exception{
        log.info("delete guestbook: {} ", guestBookSeq);
        return guestBookService.removeGuestBook(guestBookSeq);
    }

    @PatchMapping("/{guestbook_seq}")
    ResponseEntity<?> updateGuestBook(@PathVariable("guestbook_seq") Long guestBookSeq, @RequestBody GuestBookDto.RequestDto requestDto) throws Exception{
        log.info("update guestbook: {}", guestBookSeq);
        return guestBookService.updateGuestBook(guestBookSeq, requestDto);
    }
}
