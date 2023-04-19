package com.project.helloworld.service;

import com.project.helloworld.domain.Guestbook;
import com.project.helloworld.domain.User;
import com.project.helloworld.dto.GuestBookDto;
import com.project.helloworld.repository.GuestBookRepository;
import com.project.helloworld.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<?> getGuestBooks(Long userSeq) throws Exception{
        User user = userRepository.findById(userSeq).orElseThrow(()-> new Exception("not exist user : " + userSeq));
        List<Guestbook> guestbooks = user.getGuestbooks();
        List<GuestBookDto.ResponseDto> guestbooksDto = guestbooks.stream().map(x->new GuestBookDto.ResponseDto(x)).collect(Collectors.toList());
        return new ResponseEntity<>(guestbooksDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addGuestBook(GuestBookDto.RequestDto requestDto, Long userSeq) throws Exception {
        if (requestDto.getContent().isEmpty() || requestDto.getContent().length()==0) throw new Exception("No Content !");
        User writer = userRepository.findById(requestDto.getUserSeq()).orElseThrow(()->new Exception("not exist user-write : " + requestDto.getUserSeq()));
        User reader = userRepository.findById(userSeq).orElseThrow(()->new Exception("not exist user-read : " + userSeq));

        Guestbook guestbook =Guestbook
                .builder()
                .guestbookNickname(writer.getNickname())
                .guestbookUserSeq(writer.getUserSeq())
                .content(requestDto.getContent())
                .user(reader)
                .avatar(writer.getAvatar())
                .build();
        guestBookRepository.save(guestbook);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> removeGuestBook(Long guestBookSeq) {
        Optional<Guestbook> optionalGuestBook = guestBookRepository.findById(guestBookSeq);
        if(!optionalGuestBook.isEmpty()) guestBookRepository.delete(optionalGuestBook.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateGuestBook(Long guestBookSeq, GuestBookDto.RequestDto requestDto) throws Exception {
        Guestbook guestBook = guestBookRepository.findById(guestBookSeq).orElseThrow(()->new Exception("not exist guestbook: " + guestBookSeq));
        guestBook.setContent(requestDto.getContent());
        guestBookRepository.save(guestBook);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
