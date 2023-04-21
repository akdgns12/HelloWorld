package com.project.helloworld.domain;

import com.project.helloworld.util.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "guestbook_comment")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guestbook_Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guestbook_comment_seq")
    private Long guestbookCommentSeq;

    @Column(name = "user_seq")
    private Long userSeq;

    @Column(name = "content")
    private String content;

    @Column(name = "nickname")
    private String nickname;
}
