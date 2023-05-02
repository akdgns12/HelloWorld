package com.project.StoryModule.service;

import com.project.helloworld.dto.StoryDto;
import org.springframework.http.ResponseEntity;

public interface StoryService {
    public void consume(StoryDto storyDto);
    public ResponseEntity<?> getAllStory(Long userSeq) throws Exception;
    public ResponseEntity<?> getStory(Long storySeq);

}
