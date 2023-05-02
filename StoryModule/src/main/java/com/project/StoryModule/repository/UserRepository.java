package com.project.StoryModule.repository;

import com.project.StoryModule.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails findByEmail(String email);
    @Query(value = "SELECT user_seq, email FROM user WHERE email = :email",nativeQuery = true)
    Optional<User> selectUserByEmail(String email);

}
