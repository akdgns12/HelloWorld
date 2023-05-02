package com.project.StoryModule.service;

import com.project.StoryModule.domain.Story;

import java.util.List;

public interface StoryAsyncService {
    public void removeStory(List<Story> stories);
}
