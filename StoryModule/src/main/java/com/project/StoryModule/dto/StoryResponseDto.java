package com.project.StoryModule.dto;


import com.project.StoryModule.domain.Story;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class StoryResponseDto implements Serializable {
    private Long storySeq;
    private Long boardSeq;
    private String title;
    private String imgUrl;
    private Long writerSeq;
    private String nickname;
    private Long userSeq;

    @Override
    public String toString() {
        return "StoryDto{" +
                "storySeq=" + storySeq +
                ", boardSeq=" + boardSeq +
                ", title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", writerSeq=" + writerSeq +
                ", nickname='" + nickname + '\'' +
                ", userSeq=" + userSeq +
                '}';
    }
    public StoryResponseDto(Story story){
        this.storySeq = story.getStorySeq();
        this.boardSeq = story.getBoardSeq();
        this.imgUrl = story.getImgUrl();
        this.userSeq = story.getUser().getUserSeq();
        this.nickname = story.getNickname();
        this.writerSeq = story.getWriterSeq();
        this.title = story.getTitle();
    }

}
