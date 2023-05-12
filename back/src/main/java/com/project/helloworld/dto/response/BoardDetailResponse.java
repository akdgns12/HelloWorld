package com.project.helloworld.dto.response;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class BoardDetailResponse {

    private Long boardSeq;
    private String writer;

    private Long userSeq;



    private String title;

    private Integer categorySeq;

    private String imgUrl;

    private String content;

    private Boolean[] sticker;

    private LocalDateTime createTime;

    private List<Comment> comments;

    @NoArgsConstructor
    @Data
    // 왜 static 아니면 못할까?
    public static class Comment{

        private Long commentSeq;
        private String writer;

        private Long userSeq;
        private String content;

        private LocalDateTime createTime;

        @Builder
        public Comment(Long commentSeq,String writer,Long userSeq, String content, LocalDateTime createTime) {
            this.commentSeq = commentSeq;
            this.writer = writer;
            this.userSeq = userSeq;
            this.content = content;
            this.createTime = createTime;
        }
    }

    @Builder
    public BoardDetailResponse(Long boardSeq, String writer,Long userSeq, String title, String imgUrl, String content, Integer categorySeq,
                               Boolean[] sticker, LocalDateTime createTime, List<Comment> comments) {
        this.boardSeq = boardSeq;
        this.writer = writer;
        this.userSeq = userSeq;
        this.title = title;
        this.imgUrl = imgUrl;
        this.content = content;
        this.categorySeq = categorySeq;
        this.sticker = sticker;
        this.createTime = createTime;
        this.comments = comments;
    }
}
