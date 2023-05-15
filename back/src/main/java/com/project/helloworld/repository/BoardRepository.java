package com.project.helloworld.repository;

import com.project.helloworld.domain.Board;
import com.project.helloworld.domain.User;
import com.project.helloworld.dto.response.BoardCategoryCountResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {

    // 그냥 배열로 보내줄 수도
    @Query(value="SELECT category_seq categorySeq,COUNT(category_seq) count FROM board WHERE user_seq=:userSeq GROUP BY category_seq;", nativeQuery = true)
    List<BoardCategoryCountResponse> boardCategoryCount(@Param("userSeq") Long userSeq);
}
