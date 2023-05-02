package com.project.StoryModule.repository;

import com.project.StoryModule.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story,Long> {
}
