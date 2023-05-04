package com.project.helloworld.service;

import com.project.helloworld.dto.request.*;

import java.util.List;
import java.util.Set;
import org.springframework.http.ResponseEntity;

public interface BoardService {


    ResponseEntity<?> createBoard(BoardCreateBody boardCreateBody) throws Exception;

    ResponseEntity<?> getBoard(Long userSeq,Long boardSeq) throws Exception;

    ResponseEntity<?> getBoards(int start , int size) throws Exception;

    ResponseEntity<?> modifyBoard(BoardModifyBody boardModifyBody) throws Exception;

    ResponseEntity<?> removeBoard(Long boardSeq) throws Exception;

    ResponseEntity<?> createComment(CommentCreateBody commentCreateBody) throws Exception;

    ResponseEntity<?> modifyComment(CommentModifyBody commentModifyBody) throws Exception;

    ResponseEntity<?> removeComment(Long commentSeq) throws Exception;

    ResponseEntity<?> createSticker(StickerCreateBody stickerCreateBody) throws Exception;

    ResponseEntity<?> removeSticker(Long stickerSeq) throws Exception;

    ResponseEntity<?> getTop10KeywordsByRedis() throws Exception;

    ResponseEntity<?> searchByKeyword(String searchTerm, int page)throws Exception;
}
