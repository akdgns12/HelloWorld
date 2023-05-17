package com.project.helloworld.repository;

import com.project.helloworld.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUserSeq(Long userSeq);
    Optional<User> findByPhoneNumber(String phoneNumber);
    @Query(value = "select * from user where name like :keyword%", nativeQuery = true)
    List<User> findAllByName(String keyword);
    @Query(value = "select * from user where nickname like :keyword%", nativeQuery = true)
    List<User> findAllByNickname(String keyword);
    @Query(value = "select * from user where email like :keyword%", nativeQuery = true)
    List<User> findAllByEmail(String keyword);
    void deleteByUserSeq(Long userSeq);
    boolean existsByEmail(String email);

    @Query(value="select * from user where user_seq in (:arr)", nativeQuery = true)
    List<User> findUserRecommend(@Param("arr") long[] arr);
}
