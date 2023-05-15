package com.project.helloworld.repository;

import com.project.helloworld.domain.Comment;
import com.project.helloworld.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    void deleteAllByUser(User user);
}
