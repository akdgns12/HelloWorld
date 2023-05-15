package com.project.helloworld.service;

import com.project.helloworld.domain.Board;
import com.project.helloworld.domain.BookMark;
import com.project.helloworld.domain.User;
import com.project.helloworld.dto.BookMarkDto;
import com.project.helloworld.repository.BoardRepository;
import com.project.helloworld.repository.BookMarkRepository;
import com.project.helloworld.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookMarkServiceImpl implements BookMarkService{
    private final BoardRepository boardRepository;
    private final BookMarkRepository bookMarkRepository;
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<?> createBookMark(BookMarkDto.RequestDto requestDto) throws Exception {
        User user = userRepository.findById(requestDto.getUserSeq()).orElseThrow(()->new Exception("not exist user"));
        Optional<BookMark> alreadyMarked = alreadyMarked(requestDto.getBoardSeq(),requestDto.getUserSeq());

        if(!alreadyMarked.isEmpty()) {
            return removeBookMark(alreadyMarked.get().getBookmarkSeq());
        }

        Board board = boardRepository.findById(requestDto.getBoardSeq()).orElseThrow(()-> new Exception("not exist board"));

        BookMark bookMark = BookMark.builder()
                .user(user)
                .content(board.getContent().substring(0,Math.min(30,board.getContent().length())))
                .board(board)
                .build();
        BookMark newBookMark = bookMarkRepository.save(bookMark);
        BookMarkDto.ResponseDto response = new BookMarkDto.ResponseDto(newBookMark,board,requestDto.getUserSeq());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getBookMarks(Long userSeq) throws Exception {
        User user =userRepository.findByUserSeq(userSeq).orElseThrow(()-> new Exception("not exist user"));
        List<BookMarkDto.ResponseDto> response = user.getBookMarks()
                .stream()
                .map(x-> new BookMarkDto.ResponseDto(x,x.getBoard(),userSeq))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> removeBookMark(Long bookMarkSeq) throws Exception {
        Optional<BookMark> bookMark = bookMarkRepository.findById(bookMarkSeq);
        if (bookMark.isEmpty()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        bookMarkRepository.delete(bookMark.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 반환값.isEmpty()가 참이면 북마크 안한 게시글입니다.
     * 반환값.isEmpty()가 그짓이면 북마크 한 게시글입니다. -> 다시 클릭하면 삭제해야합니다.
     * -> createBookMark를 불러도 제거합니다.
     * -> removeBookMark를 호출해도 제거합니다.
     * @param boardSeq
     * @param userSeq
     * @return Optional<BookMark>
     */
    public Optional<BookMark> alreadyMarked(Long boardSeq, Long userSeq){
        return bookMarkRepository.findByBoardSeqAndUserSeq(boardSeq,userSeq);
    }
}
