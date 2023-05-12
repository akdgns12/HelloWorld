package com.project.helloworld.controller;


import com.project.helloworld.dto.Response;
import com.project.helloworld.dto.request.*;
import com.project.helloworld.service.BoardService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardController {

    private final BoardService boardService;
    @PostMapping("")
    ResponseEntity<?> createBoard(@Validated  @RequestBody BoardCreateBody boardCreateBody) throws Exception {

        return ResponseEntity.ok().body(boardService.createBoard(boardCreateBody));
    }

    @GetMapping("")
    ResponseEntity<?> getBoard(@RequestParam Long userSeq, @RequestParam Long boardSeq) throws Exception {

        return ResponseEntity.ok().body(boardService.getBoard(userSeq,boardSeq));
    }

    @GetMapping("/board-list-all")
    ResponseEntity<?> getBoardsAll(@RequestParam int start,@RequestParam int size) throws Exception {
        return ResponseEntity.ok().body(boardService.getBoardsAll(start,size));
    }

    @GetMapping("/board-list-by-user")
    ResponseEntity<?> getBoardsByUser(@RequestParam Long userSeq, @RequestParam int start, @RequestParam int size ) throws Exception{

        return ResponseEntity.ok().body(boardService.getBoardsByUser(userSeq,start,size));
    }
    @PatchMapping("")
    ResponseEntity<?> modifyBoard(@RequestBody BoardModifyBody boardModifyBody) throws Exception {

        return ResponseEntity.ok().body(boardService.modifyBoard(boardModifyBody));
    }

    @DeleteMapping("")
    ResponseEntity<?> removeBoard(@RequestParam Long boardSeq) throws Exception {

        return ResponseEntity.ok().body(boardService.removeBoard(boardSeq));
    }

    @PostMapping("/comment")
    ResponseEntity<?> createComment(@RequestBody CommentCreateBody commentCreateBody) throws Exception {

        return ResponseEntity.ok().body(boardService.createComment(commentCreateBody));
    }

    @PutMapping("/comment")
    ResponseEntity<?> modifyComment(@RequestBody CommentModifyBody commentModifyBody) throws Exception {
        return ResponseEntity.ok().body(boardService.modifyComment(commentModifyBody));
    }

    @DeleteMapping("/comment")
    ResponseEntity<?> removeComment(@RequestParam("commentSeq") Long commentSeq) throws Exception {
        return ResponseEntity.ok().body(boardService.removeComment(commentSeq));
    }

    @PostMapping("/sticker")
    ResponseEntity<?> createSticker(@RequestBody StickerCreateBody stickerCreateBody) throws Exception {
        return ResponseEntity.ok().body(boardService.createSticker(stickerCreateBody));
    }

    @DeleteMapping("/sticker")
    ResponseEntity<?> deleteSticker(@RequestParam("stickerSeq") Long stickerSeq) throws Exception {
        return ResponseEntity.ok().body(boardService.removeSticker(stickerSeq));
    }

    @GetMapping("/getTopTen")
    ResponseEntity<?> getTopSearchTerms() throws Exception {
        return ResponseEntity.ok().body(boardService.getTop10KeywordsByRedis());
    }

    // 키워드 검색
    @GetMapping("/searchByKeyword")
    ResponseEntity<?> searchBoards(@RequestParam String keyword, @RequestParam int page) throws Exception {
        return ResponseEntity.ok().body(boardService.searchByKeyword(keyword, page));
    }

    // Category 실험
    @GetMapping("/aaa")
    ResponseEntity<?> aaa(@RequestParam Long userSeq ) throws Exception {
        return ResponseEntity.ok().body(boardService.getCategoryByUser(userSeq));
    }

}
