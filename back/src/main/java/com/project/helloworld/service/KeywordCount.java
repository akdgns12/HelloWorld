package com.project.helloworld.service;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@Builder
@Slf4j
@EnableAsync
public class KeywordCount {

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;

  @Async
  public void incrementSearchTermCount(String searchTerm) {
    redisTemplate.opsForZSet().incrementScore("search_ranking", searchTerm, 1);
  }
}
