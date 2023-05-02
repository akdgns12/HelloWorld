package com.project.StoryModule.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name="user")
public class User {
    @Id
    @Column(name="user_seq")
    private Long userSeq;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    List<Story> stories = new ArrayList<>();
    @Column(name="email")
    private String email;
    public User(Long userSeq){
        this.userSeq = userSeq;
    }


}
