package com.project.helloworld.controller;

import com.project.helloworld.dto.BookMarkDto;
import com.project.helloworld.service.BookMarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmark")
@Slf4j
public class BookMarkController {
    private final BookMarkService bookMarkService;

    @PostMapping("")
    ResponseEntity<?> createBookMark(@RequestBody BookMarkDto.RequestDto requestDto) throws Exception{
        log.info("boardSeq: {} ", requestDto.getBoardSeq());
        return bookMarkService.createBookMark(requestDto);
    }

    @GetMapping("")
    ResponseEntity<?> getBookmarks(@RequestParam Long userSeq) throws Exception {
        return bookMarkService.getBookMarks(userSeq);
    }
    @DeleteMapping("")
    ResponseEntity<?> removeBookMark(@RequestParam Long bookMarkSeq) throws Exception{
        return bookMarkService.removeBookMark(bookMarkSeq);
    }
}
