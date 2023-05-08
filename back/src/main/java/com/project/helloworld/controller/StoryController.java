package com.project.helloworld.controller;

import com.project.helloworld.domain.Board;
import com.project.helloworld.repository.UserRepository;
import com.project.helloworld.service.StoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Path;

@RestController
@RequiredArgsConstructor
@RequestMapping("/story")
@Slf4j
public class StoryController {
    private final StoryService storyService;
    private final UserRepository userRepository;

    @GetMapping("/test-send-msg")
    public ResponseEntity<?> storyTest( ){
        storyService.sendToFamilies(Board.builder()
                .boardSeq(null)
                .content("test_content")
                .title("test_title")
                .user(userRepository.findByUserSeq(1L).get())
                .imgUrl("test_img_url")
                .build());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
