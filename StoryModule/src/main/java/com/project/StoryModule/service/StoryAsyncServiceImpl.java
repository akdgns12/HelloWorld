package com.project.StoryModule.service;

import com.project.StoryModule.domain.Story;
import com.project.StoryModule.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoryAsyncServiceImpl implements StoryAsyncService{
    private final StoryRepository storyRepository;

    @Override
    @Async
    public void removeStory(List<Story> stories) {
        log.info("remove Story : {} ", stories.size());
        stories.stream().forEach(x-> storyRepository.delete(x));
    }
}
