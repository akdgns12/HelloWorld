package com.project.helloworld.repository;

import com.project.helloworld.domain.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookMarkRepository extends JpaRepository<BookMark, Long> {
    @Query(value = "select * from bookmark b where board_seq = :board_seq and user_seq = :user_seq limit 1", nativeQuery = true)
    Optional<BookMark> findByBoardSeqAndUserSeq(@Param("board_seq") Long board_seq, @Param("user_seq") Long user_seq);
}
