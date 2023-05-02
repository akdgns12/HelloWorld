package com.project.StoryModule.domain;

import com.project.StoryModule.util.BaseTimeEntity;
import com.project.helloworld.dto.StoryDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="story")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Story extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storySeq;

    @Column(name="board_seq")
    private Long boardSeq;
    @Setter
    @Column(name="is_read")
    private int isRead;

    @Column(name="title")
    private String title;

    @Column(name="img_url")
    private String imgUrl;

    @Column(name="writer_seq")
    private Long writerSeq;

    @Column(name="nickname")
    private String nickname;

    @JoinColumn(name="user_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Story(StoryDto storyDto, User user){
        this.boardSeq = storyDto.getBoardSeq();
        this.title = storyDto.getTitle();
        this.imgUrl = storyDto.getImgUrl();
        this.writerSeq = storyDto.getWriterSeq();
        this.nickname = storyDto.getNickname();
        this.user = user;
    }
}
