package com.project.helloworld.repository;

import com.project.helloworld.domain.Guestbook_Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookCommentRepository extends JpaRepository<Guestbook_Comment,Long> {
    void deleteAllByUserSeq(Long userSeq);
}
