package com.project.helloworld.dto;


import com.project.helloworld.domain.Guestbook;
import com.project.helloworld.domain.Guestbook_Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * RequestDto
 * ResponseDto
 * updateRequestDto
 * CreateResponseDto
 * CommentRquestDto
 * CommentResponseDto
 * CommentCreateDto
 */
public class GuestBookDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentResponseDto {
        private Long guestbookCommentSeq;
        private Long userSeq;
        private String content;
        private String nickname;

        public CommentResponseDto(Guestbook_Comment guestBookComment){
            this.guestbookCommentSeq = guestBookComment.getGuestbookCommentSeq();
            this.userSeq = guestBookComment.getUserSeq();
            this.content = guestBookComment.getContent();
            this.nickname = guestBookComment.getNickname();
        }
    }
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class CommentRequestDto{
        private Long userSeq;
        private Long guestbookCommentSeq;
        private String content;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class CommentCreateDto{
        private Long commentSeq;
        private Long userSeq;
        public CommentCreateDto(Guestbook_Comment guestbookComment){
            this.commentSeq = guestbookComment.getGuestbookCommentSeq();
            this.userSeq = guestbookComment.getUserSeq();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResponseDto{
        private Long guestBookSeq;
        private LocalDateTime createdTime;
        private Long guestBookUserSeq;
        public CreateResponseDto(Guestbook guestbook){
            this.guestBookSeq = guestbook.getGuestbookSeq();
            this.createdTime = guestbook.getCreateTime();
            this.guestBookUserSeq = guestbook.getGuestbookUserSeq();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseDto {
        private Long guestBookSeq;
        private LocalDateTime createdTime;
        private String guestBookUserNickname;
        private Long guestBookUserSeq;
        private String content;
        private boolean isSecret;
        private CommentResponseDto commentDto;
        private String guestAvatar;

        public ResponseDto(Guestbook guestbook) {
            this.guestBookSeq = guestbook.getGuestbookSeq();
            this.createdTime = guestbook.getCreateTime();
            this.guestBookUserNickname = guestbook.getGuestbookNickname();
            this.guestBookUserSeq = guestbook.getGuestbookUserSeq();
            this.content = guestbook.getContent();
            this.isSecret = guestbook.isSecret();
            if(guestbook.getAvatar() != null) {
                this.guestAvatar = guestbook.getAvatar().getImgUrl();
            }
            if(guestbook.getGuestbook_comment() != null) {
                this.commentDto = new CommentResponseDto(guestbook.getGuestbook_comment());
            }

        }
    }
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestDto{
        private Long writeSeq;
        private Long readSeq;
        private String content;
        private int isSecret;
        public RequestDto(Long writeSeq, String content){
            this.writeSeq = writeSeq;
            this.content = content;
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateDto{
        private Long guestBookSeq;
        private String content;
        private int isSecret;

    }
}