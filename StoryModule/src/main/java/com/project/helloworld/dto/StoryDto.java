package com.project.helloworld.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.project.StoryModule.domain.Story;
import lombok.*;

import java.io.Serializable;


@JsonDeserialize
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoryDto implements Serializable {
    private Long storySeq;
    private Long boardSeq;
    private int isRead;
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
    public StoryDto(Story story, Long userSeq){
        this.storySeq = story.getStorySeq();
        this.title = story.getTitle();
        this.boardSeq = story.getBoardSeq();
        this.isRead = story.getIsRead();
        this.imgUrl = story.getImgUrl();
        this.writerSeq = story.getWriterSeq();
        this.nickname = story.getNickname();
        this.userSeq = userSeq;
    }
}
