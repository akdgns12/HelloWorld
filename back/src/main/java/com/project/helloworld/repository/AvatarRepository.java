package com.project.helloworld.repository;

import com.project.helloworld.domain.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    void deleteAllByUserSeq(Long userSeq);
}
