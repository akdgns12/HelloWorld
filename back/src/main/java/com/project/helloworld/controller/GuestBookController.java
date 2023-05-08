package com.project.helloworld.controller;


import com.project.helloworld.dto.GuestBookDto;
import com.project.helloworld.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guestbook")
@Slf4j
public class GuestBookController {
    private final GuestBookService guestBookService;

    @GetMapping("")
    ResponseEntity<?> getGuestBook(@RequestParam("userSeq") Long userSeq, @RequestParam("start") int start, @RequestParam("size") int size) throws Exception{
        log.info("userSeq: {}", userSeq);
        return guestBookService.getGuestBooks(userSeq,start,size);
    }

    @PostMapping("")
    ResponseEntity<?> addGuestBooK(@RequestBody GuestBookDto.RequestDto requestDto) throws Exception{
        log.info("write userSeq: {}", requestDto.getWriteSeq());
        log.info("read userSeq: {}", requestDto.getReadSeq());
        return guestBookService.addGuestBook(requestDto);
    }

    @DeleteMapping("/{guestbook_seq}")
    ResponseEntity<?> removeGuestBook(@PathVariable("guestbook_seq") Long guestBookSeq) throws Exception{
        log.info("delete guestbook: {} ", guestBookSeq);
        return guestBookService.removeGuestBook(guestBookSeq);
    }

    @PatchMapping("")
    ResponseEntity<?> updateGuestBook(@RequestBody GuestBookDto.updateDto requestDto) throws Exception{
        log.info("update guestbook: {}", requestDto.getGuestBookSeq());
        return guestBookService.updateGuestBook(requestDto.getGuestBookSeq(), requestDto);
    }

    @PostMapping("/comment/{guestbook_seq}")
    ResponseEntity<?> addGuestBookComment(@PathVariable("guestbook_seq") Long guestBookSeq, @RequestBody GuestBookDto.CommentRequestDto requestDto) throws Exception {
        log.info("guestbook add comment- guestbookSeq: {}" , guestBookSeq);
        return guestBookService.addComment(guestBookSeq, requestDto);
    }

    @DeleteMapping("/comment/{guestbook_seq}")
    ResponseEntity<?> removeGuestBookComment(@PathVariable("guestbook_seq") Long guestbookSeq){
        log.info("guestbook rm comment- guestbookSeq: {}", guestbookSeq);
        return guestBookService.removeComment(guestbookSeq);
    }
}
