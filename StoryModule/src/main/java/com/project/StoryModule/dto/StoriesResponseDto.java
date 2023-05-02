package com.project.StoryModule.dto;

import com.project.helloworld.dto.StoryDto;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class StoriesResponseDto {
    List<StoryDto> readStory = new LinkedList<>();
    List<StoryDto> newStory = new LinkedList<>();

    public StoriesResponseDto(List<StoryDto> stories){
        this.readStory = stories.stream().filter(x ->x.getIsRead()==0x01).collect(Collectors.toList());
        this.newStory = stories.stream().filter(x->x.getIsRead()==0x00).collect(Collectors.toList());
    }

}
