package com.project.helloworld.service;

import com.project.helloworld.domain.*;
import com.project.helloworld.dto.MessageResponse;
import com.project.helloworld.dto.request.*;
import com.project.helloworld.dto.response.BoardCategoryCountResponse;
import com.project.helloworld.dto.response.BoardDetailResponse;
import com.project.helloworld.dto.response.BoardsAllResponse;
import com.project.helloworld.dto.response.BoardsByUserResponse;
import com.project.helloworld.elkStack.domain.BoardDocument;

import com.project.helloworld.repository.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Builder
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
    public MessageResponse createBoard(BoardCreateBody boardCreateBody) throws Exception {
        User user = userRepository.findById(boardCreateBody.getUserSeq()).orElseThrow(()-> new Exception("not exist user : "+boardCreateBody.getUserSeq()));
        Board board = Board.builder().title(boardCreateBody.getTitle()).content(boardCreateBody.getContent())
                .categorySeq(boardCreateBody.getCategorySeq()).imgUrl("").likeCnt(0).helpfulCnt(0).commentCnt(0).understandCnt(0)
                .user(user).build();
        Board newBoardSaved = boardRepository.save(board);
        String content = newBoardSaved.getContent();
        int endIndex = Math.min(content.length(), 30);

        BoardDocument boardDocument = BoardDocument.builder()
            .id(newBoardSaved.getBoardSeq().toString())
            .title(newBoardSaved.getTitle())
            //.content(content.substring(0, endIndex))
            .content(newBoardSaved.getContent())
            .imageUrl(newBoardSaved.getImgUrl())
            .likeCnt(newBoardSaved.getLikeCnt())
            .boardSeq(newBoardSaved.getBoardSeq())
            .build();

        boardDocumentRepository.save(boardDocument);

        // 잔디도 심어주기
        LocalDate grassDate = newBoardSaved.getCreateTime().toLocalDate();
        Grass grass = Grass.builder().grassDate(grassDate).board(newBoardSaved).user(newBoardSaved.getUser()).build();
        grassRepository.save(grass);
        MessageResponse messageResponse = MessageResponse.builder().type(-1).typeSeq(newBoardSaved.getBoardSeq())
                .title(newBoardSaved.getUser().getName()+"님이 게시글을 작성하였습니다.")
                .content("게시글게시글").receiveUserSeq(newBoardSaved.getUser().getUserSeq()).build();
        storyService.sendStory(newBoardSaved, user.getFamilies().stream().map(x->x.getFamilyUser().getUserSeq()).collect(Collectors.toList()));
        return messageResponse;
    }

    @Override
    public BoardDetailResponse getBoard(Long userSeq,Long boardSeq) throws Exception {
        Board board = boardRepository.findById(boardSeq).orElseThrow(() -> new Exception("not exist board : "+boardSeq));
        Boolean[] sticker = {false,false,false};
        for(int i=0; i<board.getStickers().size(); i++){
            if(board.getStickers().get(i).getUser().getUserSeq() == userSeq){
                sticker[board.getStickers().get(i).getType()-1] = true;

            }

        }
        List<BoardDetailResponse.Comment> comments = board.getComments().stream().map(x -> new BoardDetailResponse.Comment(x.getCommentSeq(),x.getUser().getName(),x.getUser().getUserSeq(),x.getContent(),x.getCreateTime()) ).collect(Collectors.toList());
        BoardDetailResponse boardDetailResponse = BoardDetailResponse.builder().boardSeq(board.getBoardSeq())
        .title(board.getTitle()).content(board.getContent()).writer(board.getUser().getName()).userSeq(board.getUser().getUserSeq()).categorySeq(board.getCategorySeq())
                .sticker(sticker).imgUrl(board.getImgUrl())
                .createTime(board.getCreateTime()).comments(comments)
                .build();
        return boardDetailResponse;
    }

    @Override
    public Map<String,Object> getBoardsAll(int start,int size) throws Exception {
        // Page 객체로    https://wonit.tistory.com/483 참고
        // 제목 ,작성자, 내용, 썸네일, 스티커 개수, 댓글 개수
        PageRequest pageRequest = PageRequest.of(start,size);
        List<BoardsAllResponse> boardList = boardRepository.findAll(pageRequest)
                .stream().map(x -> new BoardsAllResponse(x.getBoardSeq(),x.getTitle(),x.getUser().getName()
                        ,x.getContent(),x.getImgUrl(),x.getCategorySeq(),x.getLikeCnt(),x.getCommentCnt())).collect(Collectors.toList());

        int boardListCount = boardRepository.findAll().size();
        HashMap<String,Object> boardInformation = new HashMap<>();
        boardInformation.put("boardList",boardList);
        boardInformation.put("boardCount",boardListCount);
        return boardInformation;
    }

    @Override
    public HashMap<String,Object> getBoardsByUser(Long userSeq, int start, int size) throws Exception {
        // 제목, 작성자, 작성일, 조회수 , 카테고리
        User user = userRepository.findById(userSeq).orElseThrow(() -> new Exception("not exist user : "+userSeq));
        PageRequest pageRequest = PageRequest.of(start,size);
        Board board = Board.builder().user(user).build();
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("user",ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("boardSeq","title","content","imgUrl","viewCnt","likeCnt","helpfulCnt","understandCnt","categorySeq","comments"
                        ,"grasses","stickers","bookMarks");
        Example<Board> example = Example.of(board, matcher);
        List<BoardsByUserResponse> boardList = boardRepository.findAll(example,pageRequest)
                .stream().map(x -> new BoardsByUserResponse(x.getBoardSeq(),x.getTitle(),x.getUser().getName(),x.getCategorySeq(),x.getCreateTime(),x.getViewCnt())).collect(Collectors.toList());
        int boardListCount = boardRepository.findAll(example).size();
        HashMap<String,Object> boardInformation = new HashMap<>();
        boardInformation.put("boardList",boardList);
        boardInformation.put("boardCount",boardListCount);
        return boardInformation;
    }

    @Override
    public MessageResponse modifyBoard(BoardModifyBody boardModifyBody) throws Exception {
        Board board = boardRepository.findById(boardModifyBody.getBoardSeq()).orElseThrow(()-> new Exception("not exist board : "+boardModifyBody.getBoardSeq()));
        Board newBoard = Board.builder().boardSeq(board.getBoardSeq()).title(boardModifyBody.getTitle()).content(boardModifyBody.getContent())
                .imgUrl(board.getImgUrl()).likeCnt(board.getLikeCnt()).helpfulCnt(board.getHelpfulCnt())
                .understandCnt(board.getUnderstandCnt()).user(board.getUser()).build();
        Board newBoardSaved = boardRepository.save(newBoard);
        MessageResponse messageResponse = MessageResponse.builder().type(-1).typeSeq(newBoardSaved.getBoardSeq())
                .title(newBoardSaved.getUser().getName()+"님이 게시글을 수정했습니다.")
                .content("게시글 수정").build();
        return messageResponse;
    }

    @Override
    public MessageResponse removeBoard(Long boardSeq) throws Exception {
        Board board = boardRepository.findById(boardSeq).orElseThrow(() -> new Exception("not exist board : "+boardSeq));
        log.info(board.toString());
        boardRepository.delete(board);
        MessageResponse messageResponse = MessageResponse.builder().type(-1).title("게시글이 삭제되었습니다.").build();
        return messageResponse;
    }

    @Override
    public MessageResponse createComment(CommentCreateBody commentCreateBody) throws Exception {
        Board board = boardRepository.findById(commentCreateBody.getBoardSeq()).orElseThrow(()-> new Exception("not exist board : "+commentCreateBody.getBoardSeq()));
        User user = userRepository.findById(commentCreateBody.getUserSeq()).orElseThrow(() -> new Exception("not exist user : "+commentCreateBody.getUserSeq()));
        Comment comment = Comment.builder().user(user).content(commentCreateBody.getContent()).board(board).build();
        Comment newCommentSaved = commentRepository.save(comment);

        // Board의 CommentCnt 한개 올려주기
        Board newBoard = Board.builder().boardSeq(board.getBoardSeq()).title(board.getTitle())
                .content(board.getContent()).imgUrl(board.getImgUrl())
                .viewCnt(board.getViewCnt()).likeCnt(board.getLikeCnt())
                .helpfulCnt(board.getHelpfulCnt()).understandCnt(board.getUnderstandCnt())
                .commentCnt(board.getCommentCnt()+1).categorySeq(board.getCategorySeq())
                .user(board.getUser()).comments(board.getComments())
                .grasses(board.getGrasses()).stickers(board.getStickers())
                .bookMarks(board.getBookMarks()).build();
        boardRepository.save(newBoard);

        MessageResponse messageResponse = MessageResponse.builder().type(2).typeSeq(newCommentSaved.getCommentSeq())
                .title(newCommentSaved.getUser().getName()+"님이 댓글을 등록하였습니다.").content("댓글댓글댓글")
                .receiveUserSeq(newCommentSaved.getUser().getUserSeq()).build();
        return messageResponse;
    }

    @Override
    public MessageResponse modifyComment(CommentModifyBody commentModifyBody) throws Exception {
        Comment comment = commentRepository.findById(commentModifyBody.getCommentSeq()).orElseThrow(() -> new Exception("not exist comment : "+commentModifyBody.getCommentSeq()));

        Comment newComment = Comment.builder().commentSeq(comment.getCommentSeq()).user(comment.getUser())
                .content(commentModifyBody.getContent()).date(comment.getDate()).board(comment.getBoard()).build();
        Comment newCommentSaved = commentRepository.save(newComment);
        MessageResponse messageResponse = MessageResponse.builder().type(-1).typeSeq(newCommentSaved.getCommentSeq())
                .title(newCommentSaved.getUser().getName()+"님이 댓글을 수정하셨습니다.").content("댓글댓글댓글수정")
                .build();
        return messageResponse;
    }

    @Override
    public MessageResponse removeComment(Long commentSeq) throws Exception {
        Comment comment = commentRepository.findById(commentSeq).orElseThrow(() -> new Exception("not exist comment : "+commentSeq));
        Board board = boardRepository.findById(comment.getBoard().getBoardSeq()).orElseThrow(() -> new Exception("not exist board  : "+comment.getBoard().getBoardSeq()));

        commentRepository.delete(comment);
        // Board의 CommentCnt 한개 내려주기
        Board newBoard = Board.builder().boardSeq(board.getBoardSeq()).title(board.getTitle())
                .content(board.getContent()).imgUrl(board.getImgUrl())
                .viewCnt(board.getViewCnt()).likeCnt(board.getLikeCnt())
                .helpfulCnt(board.getHelpfulCnt()).understandCnt(board.getUnderstandCnt())
                .commentCnt(board.getCommentCnt()-1).categorySeq(board.getCategorySeq())
                .user(board.getUser()).comments(board.getComments())
                .grasses(board.getGrasses()).stickers(board.getStickers())
                .bookMarks(board.getBookMarks()).build();
        boardRepository.save(newBoard);
        MessageResponse messageResponse = MessageResponse.builder().type(-1).title("댓글 삭제 되었습니다.").build();
        return messageResponse;
    }

    @Override
    public MessageResponse createSticker(StickerCreateBody stickerCreateBody) throws Exception {
        User user = userRepository.findById(stickerCreateBody.getUserSeq()).orElseThrow(()-> new Exception("not exist user : "+stickerCreateBody.getUserSeq()));
        Board board = boardRepository.findById(stickerCreateBody.getBoardSeq()).orElseThrow(()-> new Exception("not exist board : "+stickerCreateBody.getBoardSeq()));
        Sticker sticker = Sticker.builder().user(user).board(board).type(stickerCreateBody.getType()).build();
        Sticker newStickerSaved = stickerRepository.save(sticker);
        // type 에 따라서 , 증가시켜야함
        switch(stickerCreateBody.getType()){
            case 1:
                Board newBoard1 = Board.builder()
                        .boardSeq(board.getBoardSeq()).title(board.getTitle())
                        .content(board.getContent()).imgUrl(board.getImgUrl())
                        .viewCnt(board.getViewCnt()).likeCnt(board.getLikeCnt()+1)
                        .helpfulCnt(board.getHelpfulCnt()).understandCnt(board.getUnderstandCnt())
                        .commentCnt(board.getCommentCnt()).categorySeq(board.getCategorySeq())
                        .user(board.getUser()).comments(board.getComments())
                        .grasses(board.getGrasses()).stickers(board.getStickers())
                        .bookMarks(board.getBookMarks()).build();
                boardRepository.save(newBoard1);
                break;
            case 2:
                Board newBoard2 = Board.builder()
                        .boardSeq(board.getBoardSeq()).title(board.getTitle())
                        .content(board.getContent()).imgUrl(board.getImgUrl())
                        .viewCnt(board.getViewCnt()).likeCnt(board.getLikeCnt())
                        .helpfulCnt(board.getHelpfulCnt()+1).understandCnt(board.getUnderstandCnt())
                        .commentCnt(board.getCommentCnt()).categorySeq(board.getCategorySeq())
                        .user(board.getUser()).comments(board.getComments())
                        .grasses(board.getGrasses()).stickers(board.getStickers())
                        .bookMarks(board.getBookMarks()).build();
                boardRepository.save(newBoard2);
                break;
            case 3:
                Board newBoard3 = Board.builder()
                        .boardSeq(board.getBoardSeq()).title(board.getTitle())
                        .content(board.getContent()).imgUrl(board.getImgUrl())
                        .viewCnt(board.getViewCnt()).likeCnt(board.getLikeCnt())
                        .helpfulCnt(board.getHelpfulCnt()).understandCnt(board.getUnderstandCnt()+1)
                        .commentCnt(board.getCommentCnt()).categorySeq(board.getCategorySeq())
                        .user(board.getUser()).comments(board.getComments())
                        .grasses(board.getGrasses()).stickers(board.getStickers())
                        .bookMarks(board.getBookMarks()).build();
                boardRepository.save(newBoard3);
                break;
            default:
                break;

        }
        MessageResponse messageResponse = MessageResponse.builder().type(5).typeSeq(newStickerSaved.getStickerSeq())
                .title(newStickerSaved.getUser().getName()+"님이 반응을 했습니다.").content("좋아요")
                .receiveUserSeq(newStickerSaved.getUser().getUserSeq())
                .build();
        return messageResponse;
    }

    @Override
    public MessageResponse removeSticker(Long stickerSeq) throws Exception {
        Sticker sticker = stickerRepository.findById(stickerSeq).orElseThrow(() -> new Exception("not exist sticker : "+stickerSeq));
        Board board = boardRepository.findById(sticker.getBoard().getBoardSeq()).orElseThrow(() -> new Exception("not exist board : "+sticker.getBoard().getBoardSeq()));

        stickerRepository.delete(sticker);
        switch(sticker.getType()){
            case 1:
                Board newBoard1 = Board.builder()
                        .boardSeq(board.getBoardSeq()).title(board.getTitle())
                        .content(board.getContent()).imgUrl(board.getImgUrl())
                        .viewCnt(board.getViewCnt()).likeCnt(board.getLikeCnt()-1)
                        .helpfulCnt(board.getHelpfulCnt()).understandCnt(board.getUnderstandCnt())
                        .commentCnt(board.getCommentCnt()).categorySeq(board.getCategorySeq())
                        .user(board.getUser()).comments(board.getComments())
                        .grasses(board.getGrasses()).stickers(board.getStickers())
                        .bookMarks(board.getBookMarks()).build();
                boardRepository.save(newBoard1);
                break;
            case 2:
                Board newBoard2 = Board.builder()
                        .boardSeq(board.getBoardSeq()).title(board.getTitle())
                        .content(board.getContent()).imgUrl(board.getImgUrl())
                        .viewCnt(board.getViewCnt()).likeCnt(board.getLikeCnt())
                        .helpfulCnt(board.getHelpfulCnt()-1).understandCnt(board.getUnderstandCnt())
                        .commentCnt(board.getCommentCnt()).categorySeq(board.getCategorySeq())
                        .user(board.getUser()).comments(board.getComments())
                        .grasses(board.getGrasses()).stickers(board.getStickers())
                        .bookMarks(board.getBookMarks()).build();
                boardRepository.save(newBoard2);
                break;
            case 3:
                Board newBoard3 = Board.builder()
                        .boardSeq(board.getBoardSeq()).title(board.getTitle())
                        .content(board.getContent()).imgUrl(board.getImgUrl())
                        .viewCnt(board.getViewCnt()).likeCnt(board.getLikeCnt())
                        .helpfulCnt(board.getHelpfulCnt()).understandCnt(board.getUnderstandCnt()-1)
                        .commentCnt(board.getCommentCnt()).categorySeq(board.getCategorySeq())
                        .user(board.getUser()).comments(board.getComments())
                        .grasses(board.getGrasses()).stickers(board.getStickers())
                        .bookMarks(board.getBookMarks()).build();
                boardRepository.save(newBoard3);
                break;
            default:
                break;
        }
        MessageResponse messageResponse = MessageResponse.builder().type(-1).content("반응이 삭제되었습니다.").build();
        return messageResponse;
    }


    @Cacheable(value = "searchResults", key = "#searchTerm")
    public List<BoardDocument> searchByKeyword(String searchTerm, int page) {
        // 로그 메시지 추가
        //log.info("Searching by searchTerm: {}", searchTerm);

        // 레디스에 검색어 빈도를 저장
        keywordCount.incrementSearchTermCount(searchTerm);

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
            .should(QueryBuilders.matchQuery("title", searchTerm))
            .should(QueryBuilders.matchQuery("content", searchTerm));

        Query searchQuery = new NativeSearchQueryBuilder()
            .withQuery(boolQuery)
            .withSort(SortBuilders.fieldSort("likeCnt").order(SortOrder.DESC)) // likes 필드를 기준으로 내림차순 정렬
            .withPageable(PageRequest.of(page, 18)) // 요청한 페이지의 결과 반환
            .build();

        SearchHits<BoardDocument> searchHits = elasticsearchOperations.search(
            searchQuery, BoardDocument.class);

        List<BoardDocument> results = searchHits.getSearchHits().stream()
            .map(hit -> {
                BoardDocument doc = hit.getContent();
                String content = doc.getContent();

                // 30자 이상이면 30자로 자름
                if (content.length() > 30) {
                    content = content.substring(0, 30);
                }

                // 내용을 업데이트하고 다시 반환
                doc.setContent(content);
                return doc;
            })
            .collect(Collectors.toList());

        return results;
    }

    @Override
    public List<BoardCategoryCountResponse> getCategoryByUser(Long userSeq) throws Exception {
        List<BoardCategoryCountResponse> categoryList = boardRepository.boardCategoryCount(userSeq);
        return categoryList;
    }

    public Set<Object> getTop10KeywordsByRedis() {

        Set<Object> topKeywords = redisTemplate.opsForZSet().reverseRange("search_ranking", 0, 9);
        return topKeywords;
    }
}
