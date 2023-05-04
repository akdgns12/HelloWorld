package com.project.helloworld.service;

import com.project.helloworld.domain.*;
import com.project.helloworld.dto.MessageResponse;
import com.project.helloworld.dto.request.*;
import com.project.helloworld.dto.response.BoardDetailResponse;
import com.project.helloworld.dto.response.BoardListResponse;
import com.project.helloworld.elkStack.domain.BoardDocument;
import com.project.helloworld.repository.*;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private  final BoardRepository boardRepository;
    private final UserRepository userRepository;

    private final CommentRepository commentRepository;

    private final StickerRepository stickerRepository;

    private final GrassRepository grassRepository;
    private final StoryService storyService;

    private final BoardDocumentRepository boardDocumentRepository;

    private final KeywordCount keywordCount;

    private final ElasticsearchOperations elasticsearchOperations;

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public ResponseEntity<?> createBoard(BoardCreateBody boardCreateBody) throws Exception {
        User user = userRepository.findById(boardCreateBody.getUserSeq()).orElseThrow(()-> new Exception("not exist user : "+boardCreateBody.getUserSeq()));
        Board board = Board.builder().title(boardCreateBody.getTitle()).content(boardCreateBody.getContent()).
                imgUrl("").likeCnt(0).helpfulCnt(0).understandCnt(0)
                .user(user).build();
        Board newBoardSaved = boardRepository.save(board);

        BoardDocument boardDocument = BoardDocument.builder()
            .id(newBoardSaved.getBoardSeq().toString())
            .title(newBoardSaved.getTitle())
            .content(newBoardSaved.getContent())
            .imageUrl(newBoardSaved.getImgUrl())
            .likeCnt(newBoardSaved.getLikeCnt())
            .build();

        boardDocumentRepository.save(boardDocument);

        // 잔디도 심어주기
        LocalDate grassDate = newBoardSaved.getCreateTime().toLocalDate();
        Grass grass = Grass.builder().grassDate(grassDate).board(newBoardSaved).user(newBoardSaved.getUser()).build();
        grassRepository.save(grass);
        MessageResponse messageResponse = MessageResponse.builder().type(-1).typeSeq(newBoardSaved.getBoardSeq())
                .title(newBoardSaved.getUser().getName()+"님이 게시글을 작성하였습니다.")
                .content("게시글게시글").receiveUserSeq(newBoardSaved.getUser().getUserSeq()).build();
        storyService.sendStory(newBoardSaved, user.getFamilies().stream().map(x->x.getFamilyUserSeq()).collect(Collectors.toList()));
        return ResponseEntity.ok().body(messageResponse);
    }

    @Override
    public ResponseEntity<?> getBoard(Long userSeq,Long boardSeq) throws Exception {
        Board board = boardRepository.findById(boardSeq).orElseThrow(() -> new Exception("not exist board : "+boardSeq));
        Boolean[] sticker = {false,false,false};
        for(int i=0; i<board.getStickers().size(); i++){
            if(board.getStickers().get(i).getUser().getUserSeq() == userSeq){
                sticker[board.getStickers().get(i).getType()-1] = true;

            }

        }
        List<BoardDetailResponse.Comment> comments = board.getComments().stream().map(x -> new BoardDetailResponse.Comment(x.getUser().getName(),x.getContent(),x.getCreateTime()) ).collect(Collectors.toList());
        BoardDetailResponse boardDetailResponse = BoardDetailResponse.builder()
        .title(board.getTitle()).content(board.getContent()).writer(board.getUser().getName())
                .sticker(sticker).imgUrl(board.getImgUrl())
                .createTime(board.getCreateTime()).comments(comments)
                .build();
        return ResponseEntity.ok().body(boardDetailResponse);
    }

    @Override
    public ResponseEntity<?> getBoards(int start,int size) throws Exception {
        // Page 객체로    https://wonit.tistory.com/483 참고

        PageRequest pageRequest = PageRequest.of(start,size);
        List<BoardListResponse> boardList = boardRepository.findAll(pageRequest)
                .stream().map(x -> new BoardListResponse(x.getBoardSeq(),x.getTitle(),x.getUser().getName(),x.getCreateTime(),x.getViewCnt())).collect(Collectors.toList());
        return ResponseEntity.ok().body(boardList);
    }

    @Override
    public ResponseEntity<?> modifyBoard(BoardModifyBody boardModifyBody) throws Exception {
        Board board = boardRepository.findById(boardModifyBody.getBoardSeq()).orElseThrow(()-> new Exception("not exist board : "+boardModifyBody.getBoardSeq()));
        Board newBoard = Board.builder().boardSeq(board.getBoardSeq()).title(boardModifyBody.getTitle()).content(boardModifyBody.getContent())
                .imgUrl(board.getImgUrl()).likeCnt(board.getLikeCnt()).helpfulCnt(board.getHelpfulCnt())
                .understandCnt(board.getUnderstandCnt()).user(board.getUser()).build();
        Board newBoardSaved = boardRepository.save(newBoard);
        MessageResponse messageResponse = MessageResponse.builder().type(-1).typeSeq(newBoardSaved.getBoardSeq())
                .title(newBoardSaved.getUser().getName()+"님이 게시글을 수정했습니다.")
                .content("게시글 수정").build();
        return ResponseEntity.ok().body(messageResponse);
    }

    @Override
    public ResponseEntity<?> removeBoard(Long boardSeq) throws Exception {
        Board board = boardRepository.findById(boardSeq).orElseThrow(() -> new Exception("not exist board : "+boardSeq));
        log.info(board.toString());
        boardRepository.delete(board);
        MessageResponse messageResponse = MessageResponse.builder().type(-1).title("게시글이 삭제되었습니다.").build();
        return ResponseEntity.ok().body(messageResponse);
    }

    @Override
    public ResponseEntity<?> createComment(CommentCreateBody commentCreateBody) throws Exception {
        Board board = boardRepository.findById(commentCreateBody.getBoardSeq()).orElseThrow(()-> new Exception("not exist board : "+commentCreateBody.getBoardSeq()));
        User user = userRepository.findById(commentCreateBody.getUserSeq()).orElseThrow(() -> new Exception("not exist user : "+commentCreateBody.getUserSeq()));
        Comment comment = Comment.builder().user(user).content(commentCreateBody.getContent()).board(board).build();
        Comment newCommentSaved = commentRepository.save(comment);

        MessageResponse messageResponse = MessageResponse.builder().type(2).typeSeq(newCommentSaved.getCommentSeq())
                .title(newCommentSaved.getUser().getName()+"님이 댓글을 등록하였습니다.").content("댓글댓글댓글")
                .receiveUserSeq(newCommentSaved.getUser().getUserSeq()).build();
        return ResponseEntity.ok().body(messageResponse);
    }

    @Override
    public ResponseEntity<?> modifyComment(CommentModifyBody commentModifyBody) throws Exception {
        Comment comment = commentRepository.findById(commentModifyBody.getCommentSeq()).orElseThrow(() -> new Exception("not exist comment : "+commentModifyBody.getCommentSeq()));

        Comment newComment = Comment.builder().commentSeq(comment.getCommentSeq()).user(comment.getUser())
                .content(commentModifyBody.getContent()).date(comment.getDate()).board(comment.getBoard()).build();
        Comment newCommentSaved = commentRepository.save(newComment);
        MessageResponse messageResponse = MessageResponse.builder().type(-1).typeSeq(newCommentSaved.getCommentSeq())
                .title(newCommentSaved.getUser().getName()+"님이 댓글을 수정하셨습니다.").content("댓글댓글댓글수정")
                .build();
        return ResponseEntity.ok().body(messageResponse);
    }

    @Override
    public ResponseEntity<?> removeComment(Long commentSeq) throws Exception {
        commentRepository.deleteById(commentSeq);
        MessageResponse messageResponse = MessageResponse.builder().type(-1).title("댓글 삭제 되었습니다.").build();
        return ResponseEntity.ok().body(messageResponse);
    }

    @Override
    public ResponseEntity<?> createSticker(StickerCreateBody stickerCreateBody) throws Exception {
        User user = userRepository.findById(stickerCreateBody.getUserSeq()).orElseThrow(()-> new Exception("not exist user : "+stickerCreateBody.getUserSeq()));
        Board board = boardRepository.findById(stickerCreateBody.getBoardSeq()).orElseThrow(()-> new Exception("not exist board : "+stickerCreateBody.getBoardSeq()));
        Sticker sticker = Sticker.builder().user(user).board(board).type(stickerCreateBody.getType()).build();
        Sticker newStickerSaved = stickerRepository.save(sticker);
        MessageResponse messageResponse = MessageResponse.builder().type(5).typeSeq(newStickerSaved.getStickerSeq())
                .title(newStickerSaved.getUser().getName()+"님이 반응을 했습니다.").content("좋아요")
                .receiveUserSeq(newStickerSaved.getUser().getUserSeq())
                .build();
        return ResponseEntity.ok().body(messageResponse);
    }

    @Override
    public ResponseEntity<?> removeSticker(Long stickerSeq) throws Exception {

        stickerRepository.deleteById(stickerSeq);
        MessageResponse messageResponse = MessageResponse.builder().type(-1).content("반응이 삭제되었습니다.").build();
        return ResponseEntity.ok().body(messageResponse);
    }


    @Cacheable(value = "searchResults", key = "#searchTerm")
    public List<BoardDocument> searchByKeyword(String searchTerm) {

        // 로그 메시지 추가
        log.info("Searching by searchTerm: {}", searchTerm);


        // 레디스에 검색어 빈도를 저장
        keywordCount.incrementSearchTermCount(searchTerm);

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
            .should(QueryBuilders.matchQuery("title", searchTerm))
            .should(QueryBuilders.matchQuery("content", searchTerm));

        Query searchQuery = new NativeSearchQueryBuilder()
            .withQuery(boolQuery)
            //.withSort(SortBuilders.fieldSort("createTime").order(SortOrder.DESC))
            .withSort(SortBuilders.fieldSort("likes").order(SortOrder.DESC)) // likes 필드를 기준으로 내림차순 정렬
            .withPageable(PageRequest.of(0, 18)) // Top 10 results
            .build();

        SearchHits<BoardDocument> searchHits = elasticsearchOperations.search(
            searchQuery, BoardDocument.class);

        return searchHits.getSearchHits().stream()
            .map(hit -> hit.getContent())
            .collect(Collectors.toList());
    }

    public Set<Object> getTop10KeywordsByRedis() {

        return redisTemplate.opsForZSet().reverseRange("search_ranking", 0, 9);

    }
}
