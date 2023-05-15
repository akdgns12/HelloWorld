package com.project.helloworld.repository;

import com.project.helloworld.domain.Accessories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessoriesRepository extends JpaRepository<Accessories, Long> {
    void deleteAllByUserSeq(Long userSeq);
}
