package com.project.helloworld.repository;

import com.project.helloworld.domain.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookRepository extends JpaRepository<Guestbook,Long> {
}
