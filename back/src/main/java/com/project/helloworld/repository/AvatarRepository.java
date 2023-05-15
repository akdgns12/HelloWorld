package com.project.helloworld.repository;

import com.project.helloworld.domain.Avatar;
import com.project.helloworld.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    void deleteAllByUser(User user);
}
