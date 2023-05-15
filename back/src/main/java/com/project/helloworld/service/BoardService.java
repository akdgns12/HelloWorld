package com.project.helloworld.service;

import com.project.helloworld.dto.MessageResponse;
import com.project.helloworld.dto.request.*;

import com.project.helloworld.dto.response.BoardDetailResponse;
import com.project.helloworld.elkStack.domain.BoardDocument;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.project.helloworld.dto.response.BoardCategoryCountResponse;
import org.springframework.http.ResponseEntity;

public interface BoardService {


    MessageResponse createBoard(BoardCreateBody boardCreateBody) throws Exception;

    BoardDetailResponse getBoard(Long userSeq,Long boardSeq) throws Exception;

    Map<String,Object> getBoardsAll(int start , int size) throws Exception;

    HashMap<String,Object> getBoardsByUser(Long userSeq,Integer categorySeq, int start, int size) throws Exception;
    MessageResponse modifyBoard(BoardModifyBody boardModifyBody) throws Exception;

    MessageResponse removeBoard(Long boardSeq) throws Exception;

    MessageResponse createComment(CommentCreateBody commentCreateBody) throws Exception;

    MessageResponse modifyComment(CommentModifyBody commentModifyBody) throws Exception;

    MessageResponse removeComment(Long commentSeq) throws Exception;

    MessageResponse createSticker(StickerCreateBody stickerCreateBody) throws Exception;

    MessageResponse removeSticker(StickerRequest stickerRequest) throws Exception;

    Set<Object> getTop10KeywordsByRedis() throws Exception;

    List<BoardDocument> searchByKeyword(String searchTerm, int page)throws Exception;

    List<BoardCategoryCountResponse> getCategoryByUser(Long userSeq) throws Exception;
}
