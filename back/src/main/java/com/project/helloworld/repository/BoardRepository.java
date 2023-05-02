package com.project.helloworld.repository;

import com.project.helloworld.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {


}
