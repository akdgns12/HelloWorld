package com.project.helloworld.service;

import com.project.helloworld.domain.Guestbook;
import com.project.helloworld.domain.Guestbook_Comment;
import com.project.helloworld.domain.User;
import com.project.helloworld.dto.GuestBookDto;
import com.project.helloworld.repository.GuestBookRepository;
import com.project.helloworld.repository.GuestbookCommentRepository;
import com.project.helloworld.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class GuestBookServiceImpl implements GuestBookService{
    private final GuestBookRepository guestBookRepository;
    private final GuestbookCommentRepository guestbookCommentRepository;
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<?> getGuestBooks(Long userSeq, int start, int size) throws Exception{
        User user = userRepository.findById(userSeq).orElseThrow(()-> new Exception("not exist user : " + userSeq));
        PageRequest pageRequest = PageRequest.of(start,size);
        log.info("start, size : {} , {}", pageRequest.first(),pageRequest.getPageSize());
        List<Guestbook> guestbooksDto = guestBookRepository.findByUserSeq(userSeq,pageRequest);
        List<GuestBookDto.ResponseDto> guestbooksResponseDto = guestbooksDto.stream().map(x->new GuestBookDto.ResponseDto(x)).collect(Collectors.toList());
        return new ResponseEntity<>(guestbooksResponseDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addGuestBook(GuestBookDto.RequestDto requestDto) throws Exception {
        if (requestDto.getContent().isEmpty() || requestDto.getContent().length()==0) throw new Exception("No Content !");

        User writer = userRepository.findById(requestDto.getWriteSeq()).orElseThrow(()->new Exception("not exist user-write : " + requestDto.getWriteSeq()));
        User reader = userRepository.findById(requestDto.getReadSeq()).orElseThrow(()->new Exception("not exist user-read : " + requestDto.getReadSeq()));

        Guestbook guestbook =Guestbook
                .builder()
                .guestbookNickname(writer.getNickname())
                .guestbookUserSeq(writer.getUserSeq())
                .content(requestDto.getContent())
                .user(reader)
                .avatar(writer.getAvatar())
                .isSecret(requestDto.getIsSecret()==1)
                .build();
        GuestBookDto.CreateResponseDto guestbookDto = new GuestBookDto.CreateResponseDto(guestBookRepository.save(guestbook));
        return new ResponseEntity<>(guestbookDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> removeGuestBook(Long guestBookSeq) {
        Optional<Guestbook> optionalGuestBook = guestBookRepository.findById(guestBookSeq);
        if(!optionalGuestBook.isEmpty()) guestBookRepository.delete(optionalGuestBook.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateGuestBook(Long guestBookSeq, GuestBookDto.updateDto requestDto) throws Exception {
        Guestbook guestBook = guestBookRepository.findById(guestBookSeq).orElseThrow(()->new Exception("not exist guestbook: " + guestBookSeq));
        guestBook.setContent(requestDto.getContent());
        guestBookRepository.save(guestBook);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addComment(Long guestBookSeq, GuestBookDto.CommentRequestDto requestDto) throws Exception {
        Guestbook guestbook = guestBookRepository.findById(guestBookSeq).orElseThrow(()->new Exception("not exist guestbook: " + guestBookSeq));
        if(guestbook.getGuestbook_comment()!=null){
            guestbookCommentRepository.delete(guestbook.getGuestbook_comment());
        }
        User user = userRepository.findByUserSeq(requestDto.getUserSeq()).orElseThrow(()-> new Exception("not exist user : " + requestDto.getUserSeq()));
        Guestbook_Comment guestBookComment = Guestbook_Comment.builder()
                .nickname(user.getNickname())
                .userSeq(requestDto.getUserSeq())
                .content(requestDto.getContent())
                .build();
        guestbook.setGuestbook_comment(guestbookCommentRepository.save(guestBookComment));
        GuestBookDto.CommentCreateDto commentDto = new GuestBookDto.CommentCreateDto(guestBookComment);

        return new ResponseEntity<>(commentDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> removeComment(Long guestBookSeq) {
//        guestbookCommentRepository.deleteById(commentSeq);
        Optional<Guestbook> guestbook = guestBookRepository.findById(guestBookSeq);
        if (guestbook.isEmpty()) return new ResponseEntity<>(HttpStatus.OK);
        guestbook.get().setGuestbook_comment(null);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
