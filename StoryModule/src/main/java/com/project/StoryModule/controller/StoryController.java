package com.project.StoryModule.controller;

import com.project.StoryModule.security.jwt.JwtAuthenticationFilter;
import com.project.StoryModule.security.jwt.JwtTokenProvider;
import com.project.StoryModule.service.StoryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/story")
@Slf4j
public class StoryController {
    private final StoryService storyService ;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtTokenProvider jwtTokenProvider;

    @ApiOperation(value = "스토리 가져오기")
    @GetMapping("/{storySeq}")
    ResponseEntity<?> getStory(@PathVariable Long storySeq){
        log.info("storySeq: {}", storySeq);
        return storyService.getStory(storySeq);
    }
    
    @ApiOperation(value = "모든 스토리 가져오기")
    @GetMapping("/all/{userSeq}")
    ResponseEntity<?> getAllStory(@PathVariable Long userSeq) throws Exception{
        log.info("userSeq: {} ", userSeq);
//        String token = jwtAuthenticationFilter.parseBearerToken(request);
//        String email = jwtTokenProvider.getEmail(token);

        return storyService.getAllStory(userSeq);
    }
}
