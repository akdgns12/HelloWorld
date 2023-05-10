package com.project.helloworld.service;

import com.project.helloworld.dto.BookMarkDto;
import org.springframework.http.ResponseEntity;

public interface BookMarkService {
    ResponseEntity<?> createBookMark(BookMarkDto.RequestDto requestDto) throws Exception;
    ResponseEntity<?> getBookMarks(Long userSeq) throws Exception;
    ResponseEntity<?> removeBookMark(Long bookMarkSeq) throws Exception;
}
