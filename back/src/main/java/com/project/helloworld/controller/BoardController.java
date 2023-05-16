package com.project.helloworld.controller;


import com.project.helloworld.dto.MessageResponse;
import com.project.helloworld.dto.Response;
import com.project.helloworld.dto.request.*;
import com.project.helloworld.dto.response.BoardCategoryCountResponse;
import com.project.helloworld.dto.response.BoardDetailResponse;
import com.project.helloworld.elkStack.domain.BoardDocument;
import com.project.helloworld.service.BoardService;

import java.io.IOException;
import java.util.*;

import com.project.helloworld.util.S3Uploader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    private final S3Uploader s3Uploader;
    @PostMapping("")
    public ResponseEntity<MessageResponse> createBoard(@Validated  @RequestBody BoardCreateBody boardCreateBody) throws Exception {

        return ResponseEntity.ok().body(boardService.createBoard(boardCreateBody));
    }

    @GetMapping("")
    public ResponseEntity<BoardDetailResponse> getBoard(@RequestParam Long userSeq, @RequestParam Long boardSeq) throws Exception {

        return ResponseEntity.ok().body(boardService.getBoard(userSeq,boardSeq));
    }

    @GetMapping("/board-list-all")
    public ResponseEntity<Map<String,Object>> getBoardsAll(@RequestParam int start,@RequestParam int size) throws Exception {
        return ResponseEntity.ok().body(boardService.getBoardsAll(start,size));
    }

    @GetMapping("/board-list-by-user")
    public ResponseEntity<Map<String,Object>> getBoardsByUser(@RequestParam Long userSeq,@RequestParam(required = false) Integer categorySeq, @RequestParam int start, @RequestParam int size ) throws Exception{

        return ResponseEntity.ok().body(boardService.getBoardsByUser(userSeq,categorySeq,start,size));
    }
    @PatchMapping("")
    public ResponseEntity<MessageResponse> modifyBoard(@RequestBody BoardModifyBody boardModifyBody) throws Exception {

        return ResponseEntity.ok().body(boardService.modifyBoard(boardModifyBody));
    }

    @DeleteMapping("")
    public ResponseEntity<MessageResponse> removeBoard(@RequestParam Long boardSeq) throws Exception {

        return ResponseEntity.ok().body(boardService.removeBoard(boardSeq));
    }

    @PostMapping("/comment")
    public ResponseEntity<MessageResponse> createComment(@RequestBody CommentCreateBody commentCreateBody) throws Exception {

        return ResponseEntity.ok().body(boardService.createComment(commentCreateBody));
    }

    @PutMapping("/comment")
    public ResponseEntity<MessageResponse> modifyComment(@RequestBody CommentModifyBody commentModifyBody) throws Exception {
        return ResponseEntity.ok().body(boardService.modifyComment(commentModifyBody));
    }

    @DeleteMapping("/comment")
    public ResponseEntity<MessageResponse> removeComment(@RequestParam("commentSeq") Long commentSeq) throws Exception {
        return ResponseEntity.ok().body(boardService.removeComment(commentSeq));
    }

    @PostMapping("/sticker")
    public ResponseEntity<MessageResponse> createSticker(@RequestBody StickerCreateBody stickerCreateBody) throws Exception {
        return ResponseEntity.ok().body(boardService.createSticker(stickerCreateBody));
    }

    @DeleteMapping("/sticker")
    public ResponseEntity<MessageResponse> removeSticker(@RequestBody StickerRequest stickerRequest) throws Exception {
        return ResponseEntity.ok().body(boardService.removeSticker(stickerRequest));
    }

    @GetMapping("/getTopTen")
    public ResponseEntity<Set<Object>> getTop10KeywordsByRedis() throws Exception {
        return ResponseEntity.ok().body(boardService.getTop10KeywordsByRedis());
    }

    // 키워드 검색
    @GetMapping("/searchByKeyword")
    public ResponseEntity<List<BoardDocument>> searchByKeyword(@RequestParam String keyword, @RequestParam int page) throws Exception {
        return ResponseEntity.ok().body(boardService.searchByKeyword(keyword, page));
    }


    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file) throws IOException {
        return  ResponseEntity.ok().body(s3Uploader.uploadFiles(file,"article"));
    }


}
