package com.project.helloworld.repository;

import com.project.helloworld.domain.Guestbook;
import com.project.helloworld.domain.User;
import com.project.helloworld.dto.GuestBookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuestBookRepository extends JpaRepository<Guestbook,Long> {

    @Query(value = "select * from guestbook where user_seq = :userSeq order by create_time desc",nativeQuery = true)
    List<Guestbook> findByUserSeq(@Param("userSeq") Long userSeq, Pageable pageable);
}
