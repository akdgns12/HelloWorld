package com.project.helloworld.service;

import com.project.helloworld.domain.Board;
import com.project.helloworld.domain.Family;
import com.project.helloworld.domain.Guestbook;
import com.project.helloworld.domain.User;
import com.project.helloworld.dto.StoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class StroyServiceImpl implements StoryService{
    private static final String TOPIC = "user-story";
    @Autowired
    private KafkaTemplate<String, StoryDto> kafkaTemplate;

    @Async
    public void sendStory(Board board, List<Long> families) {
        User writer = board.getUser();

        if(families.isEmpty()) return ;
        families.stream().forEach(x-> kafkaTemplate.send (TOPIC, new StoryDto(board,writer, x)));

    }
}
