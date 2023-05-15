package com.project.helloworld.repository;

import com.project.helloworld.domain.Guestbook_Comment;
import com.project.helloworld.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookCommentRepository extends JpaRepository<Guestbook_Comment,Long> {
    void deleteAllByUserSeq(Long userSeq);
}
