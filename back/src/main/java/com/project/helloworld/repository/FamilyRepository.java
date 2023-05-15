package com.project.helloworld.repository;

import com.project.helloworld.domain.Family;
import com.project.helloworld.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FamilyRepository extends JpaRepository<Family,Long> {

    @Query(value="select * from family where user_seq= :fromSeq and family_user_seq= :toSeq", nativeQuery = true)
    public Family findFamilyByUsers(@Param(value="fromSeq") Long fromSeq, @Param(value="toSeq") Long toSeq);

    @Query(value="select family_seq familySeq from family where user_seq= :fromSeq and family_user_seq= :toSeq", nativeQuery = true)
    public Long findByUsers(@Param(value="fromSeq") Long fromSeq, @Param(value="toSeq") Long toSeq);

    @Query(value="select accept from family where user_seq= :fromSeq and family_user_seq= :toSeq", nativeQuery = true)
    public Integer findByUsersAccept(@Param(value="fromSeq") Long fromSeq, @Param(value="toSeq") Long toSeq);

    void deleteAllByUser(User user);
}
