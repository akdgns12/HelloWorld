package com.project.helloworld.repository;


import com.project.helloworld.domain.Bgm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BgmRepository extends JpaRepository<Bgm,Long> {

}