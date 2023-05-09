package com.project.helloworld.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class VisitorServiceImpl implements VisitorService {

    private String ownerPrefix = "owner:";
    private String todayVisitor = " todayVisitor";
    private String totalVisitor = " totalVisitor";
    private final RedisTemplate<String, Object> redisTemplate;

    public void addVisitor(String ownerSeq, String visitorId) {
        String totalVisitorKey = ownerPrefix + ownerSeq + totalVisitor;
        String todayVisitorKey = ownerPrefix + ownerSeq + todayVisitor;

        HyperLogLogOperations<String, Object> ops = redisTemplate.opsForHyperLogLog();
        LocalDate todayDate = LocalDate.now();
        ops.add(todayVisitorKey, visitorId);
        ops.add(totalVisitorKey, visitorId + todayDate);

        Duration expireTime = Duration.ofDays(1);

        // 현재시간으로부터 하루 뒤 자동 만료
        redisTemplate.expire(todayVisitorKey, expireTime.getSeconds(), TimeUnit.SECONDS);
    }

    public Long getTotalVisitors(String ownerSeq) {
        HyperLogLogOperations<String, Object> ops = redisTemplate.opsForHyperLogLog();
        String totalVisitorKey = ownerPrefix + ownerSeq + totalVisitor;
        Long totalVisitor = ops.size(totalVisitorKey);

        return totalVisitor;
    }

    public Long getTodayVisitors(String ownerSeq) {
        HyperLogLogOperations<String, Object> ops = redisTemplate.opsForHyperLogLog();
        String todayVisitorKey = ownerPrefix + ownerSeq + todayVisitor;
        Long todayVisitors = ops.size(todayVisitorKey);

        return todayVisitors;
    }

    // today key 만료시키기
    public void expireTodayVisitors(String ownerSeq) {
        String todayVisitorKey = ownerPrefix + ownerSeq + todayVisitor;
        redisTemplate.expire(todayVisitorKey, 0, TimeUnit.SECONDS);
    }
}
