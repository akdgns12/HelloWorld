package com.project.StoryModule.service;

import com.project.StoryModule.domain.Story;
import com.project.StoryModule.domain.User;
import com.project.StoryModule.dto.StoriesResponseDto;
import com.project.StoryModule.dto.StoryResponseDto;
import com.project.helloworld.dto.StoryDto;
import com.project.StoryModule.repository.StoryRepository;
import com.project.StoryModule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoryServiceImpl implements StoryService{
    private final StoryRepository storyRepository;
    private final StoryAsyncService storyAsyncService;
    private final UserRepository userRepository;
    @KafkaListener(topics="user-story",groupId="dev-group",containerFactory="storyListner")
    public void consume(StoryDto storyDto){
        Optional<User> optionalUser = userRepository.findById(storyDto.getUserSeq());
        User user = null;
        if(optionalUser.isEmpty()){
            user = userRepository.save(new User(storyDto.getUserSeq()));
        }else {
            user = optionalUser.get();
        }
        Optional<Story> optionalStory = storyRepository.findByBoardSeqAndUserSeq(storyDto.getBoardSeq(),user.getUserSeq());
        if(optionalStory.isEmpty()) {
            storyRepository.save(new Story(storyDto, user));
        }else {
            storyRepository.delete(optionalStory.get());
        }
    }

    @Override
    public ResponseEntity<?> getAllStory(Long userSeq) throws Exception {
        log.info("user_seq: {}", userSeq);
        User user = userRepository.findById(userSeq).orElse(userRepository.save(new User(userSeq)));
        LocalDateTime now = LocalDateTime.now();

        List<Story> stories = user.getStories();

        List<StoryDto> existStories = stories.stream()
                .filter(x->Duration.between(x.getCreateTime(),now).toHours() < 24).map(y->new StoryDto(y,user.getUserSeq()))
                .collect(Collectors.toList());

        List<Story> removeStories = stories.stream()
                .filter(x->Duration.between(x.getCreateTime(),now).toHours()>=24)
                .collect(Collectors.toList());

        storyAsyncService.removeStory(removeStories);
        return new ResponseEntity<>(new StoriesResponseDto(existStories), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getStory(Long storySeq) {
        Optional<Story> optionalStory = storyRepository.findById(storySeq);
        if(optionalStory.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Story story = optionalStory.get();
        story.setIsRead(1);
        return new ResponseEntity<>(new StoryResponseDto(storyRepository.save(story)), HttpStatus.OK);
    }
}
