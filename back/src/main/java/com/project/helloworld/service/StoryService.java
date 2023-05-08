package com.project.helloworld.service;

import com.project.helloworld.domain.Board;
import com.project.helloworld.domain.Family;
import com.project.helloworld.domain.Guestbook;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StoryService {
    public void sendStory(Board board, List<Long> families);
}
