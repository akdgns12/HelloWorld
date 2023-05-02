package com.project.helloworld.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.helloworld.domain.Board;
import com.project.helloworld.domain.Guestbook;
import com.project.helloworld.domain.User;
import lombok.*;

import java.io.Serializable;
import org.springframework.kafka.support.serializer.JsonSerializer;

@JsonSerialize
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoryDto implements Serializable {
    private Long storySeq;
    private Long boardSeq;
    private boolean isRead;
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


    public StoryDto(Guestbook guestBook, Long userSeq ){
        this.boardSeq = guestBook.getGuestbookSeq();
        this.title = guestBook.getContent();
        this.imgUrl = "asdf";
        this.writerSeq = guestBook.getUser().getUserSeq();
        this.nickname = guestBook.getUser().getNickname();
        this.userSeq = userSeq;
    }
    public StoryDto(Board board, User writer, Long userSeq){
        this.boardSeq = board.getBoardSeq();
        this.title = board.getTitle();
        this.imgUrl = board.getImgUrl();
        this.writerSeq = writer.getUserSeq();
        this.nickname = writer.getNickname();
        this.userSeq = userSeq;
        this.isRead = false;

    }

}
