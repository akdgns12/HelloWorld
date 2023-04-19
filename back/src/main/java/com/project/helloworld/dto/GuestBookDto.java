package com.project.helloworld.dto;


import com.project.helloworld.domain.Guestbook;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


public class GuestBookDto {
    @Getter
    @Setter
    public static class ResponseDto {
        private Long guestBookSeq;
        private LocalDateTime createdTime;
        private String guestBookUserNickname;
        private Long guestBookUserSeq;
        private String content;


        public ResponseDto(Guestbook guestbook) {
            this.guestBookSeq = guestbook.getGuestbookSeq();
            this.createdTime = guestbook.getCreateTime();
            this.guestBookUserNickname = guestbook.getGuestbookNickname();
            this.guestBookUserSeq = guestbook.getGuestbookUserSeq();
            this.content = guestbook.getContent();

        }
    }
    @Getter
    public static class RequestDto{
        private Long userSeq;
        private String content;
        public RequestDto(Long userSeq, String content){
            this.userSeq = userSeq;
            this.content = content;
        }
        public RequestDto(String content){
            this.content = content;
        }
    }
}