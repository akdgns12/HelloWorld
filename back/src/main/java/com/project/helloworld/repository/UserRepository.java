package com.project.helloworld.repository;

import com.project.helloworld.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUserSeq(Long userSeq);
    Optional<User> findByPhoneNumber(String phoneNumber);
    boolean deleteByUserSeq(Long userSeq);
    boolean existsByEmail(String email);
}
