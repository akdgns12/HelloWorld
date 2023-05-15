package com.project.helloworld.dto;

import com.project.helloworld.domain.Board;
import com.project.helloworld.domain.BookMark;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BookMarkDto {


    @Getter
    @NoArgsConstructor
    public static class RequestDto{
        Long userSeq;
        Long boardSeq;

    }

    @Getter
    @NoArgsConstructor
    public static class ResponseDto{
        Long bookMarkSeq;
        Long userSeq;
        Long writerSeq;
        Long boardSeq;
        String writerNickname;
        String imgUrl;
        String title;
        String content;
        LocalDateTime updateTime;
        public ResponseDto(BookMark bookMark, Board board,Long userSeq){
            this.bookMarkSeq = bookMark.getBookmarkSeq();
            this.userSeq = userSeq;
            this.writerSeq = board.getUser().getUserSeq();
            this.writerNickname = board.getUser().getNickname();
            this.boardSeq = board.getBoardSeq();
            this.content = bookMark.getContent();
            this.imgUrl = board.getImgUrl();
            this.title = board.getTitle();
            this.updateTime = board.getModifiedTime();

        }
    }
}
