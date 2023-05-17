package com.project.StoryModule.repository;

import com.project.StoryModule.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface StoryRepository extends JpaRepository<Story,Long> {
    Optional<Story> findByBoardSeq(Long boardSeq);

    @Query(value = "SELECT * FROM story WHERE board_seq = :boardSeq AND user_seq= :userSeq", nativeQuery = true)
    Optional<Story> findByBoardSeqAndUserSeq(@Param("boardSeq") Long boardSeq, @Param("userSeq")Long userSeq);
}
