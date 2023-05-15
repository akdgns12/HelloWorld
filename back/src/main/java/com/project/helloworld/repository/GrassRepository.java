package com.project.helloworld.repository;

import com.project.helloworld.domain.Family;
import com.project.helloworld.domain.Grass;
import com.project.helloworld.domain.User;
import com.project.helloworld.dto.response.GrassTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface GrassRepository extends JpaRepository<Grass,Long> {

    @Query(value="select grass_seq grassSeq , grass_date grassDate , user_seq userSeq, board_seq boardSeq from grass where grass_date>= :startDate and grass_date <= :endDate and user_seq = :userSeq order by grass_date asc", nativeQuery = true)
    public List<GrassTable> getGrassByDate(@Param(value="startDate") LocalDate startDate, @Param(value="endDate") LocalDate endDate, @Param(value="userSeq") Long userSeq);

    void deleteAllByUser(User user);
}
