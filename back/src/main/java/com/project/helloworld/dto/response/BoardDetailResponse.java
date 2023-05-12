package com.project.helloworld.dto.response;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class BoardDetailResponse {

    private String writer;

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
        private String writer;
        private String content;

        private LocalDateTime createTime;

        @Builder
        public Comment(String writer, String content, LocalDateTime createTime) {
            this.writer = writer;
            this.content = content;
            this.createTime = createTime;
        }
    }

    @Builder
    public BoardDetailResponse(String writer, String title, String imgUrl, String content, Integer categorySeq,
                               Boolean[] sticker, LocalDateTime createTime, List<Comment> comments) {
        this.writer = writer;
        this.title = title;
        this.imgUrl = imgUrl;
        this.content = content;
        this.categorySeq = categorySeq;
        this.sticker = sticker;
        this.createTime = createTime;
        this.comments = comments;
    }
}
