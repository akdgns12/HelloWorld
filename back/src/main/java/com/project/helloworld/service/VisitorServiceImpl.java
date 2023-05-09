package com.project.helloworld.service;

import com.project.helloworld.domain.User;
import com.project.helloworld.dto.VisitorResponseDto;
import com.project.helloworld.repository.TodayVisitRepository;
import com.project.helloworld.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class VisitorServiceImpl implements VisitorService {

    private String ownerPrefix = "owner:";
    private String todayVisitor = " todayVisitor";
    private String totalVisitor = " totalVisitor";
    private final UserRepository userRepository;
    private final TodayVisitRepository todayVisitRepository;
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

    // 최근 7일간 Today 정보 조회
    @Override
    public List<VisitorResponseDto.WeeklyTodayInfo> getWeeklyToday(Long userSeq) throws Exception {
        User user = userRepository.findByUserSeq(userSeq).orElseThrow(()-> new Exception("해당하는 유저가 없습니다." + userSeq));
        // DB에서 어제부터 6일
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate weekAgo = yesterday.minusDays(6);

        // 현재부터 7일전 Today 정보 조회
        List<Object[]> todayVisitList = todayVisitRepository.findByTodayCntListByUserSeq(userSeq, weekAgo, yesterday);
        List<VisitorResponseDto.WeeklyTodayInfo> weeklyTodayInfoList = VisitorResponseDto.mapToWeeklyTodayInfoList(todayVisitList);

        // today는 redis에서 조회
        LocalDate todayDate = LocalDate.now();
        Long todayCnt = getTodayVisitors(String.valueOf(userSeq));

        VisitorResponseDto.WeeklyTodayInfo todayInfo = VisitorResponseDto.WeeklyTodayInfo.builder()
                .date(todayDate)
                .today(todayCnt)
                .build();

        weeklyTodayInfoList.add(todayInfo);
        // date 오름차순 정렬
        Collections.sort(weeklyTodayInfoList, new Comparator<VisitorResponseDto.WeeklyTodayInfo>() {
            public int compare(VisitorResponseDto.WeeklyTodayInfo date1, VisitorResponseDto.WeeklyTodayInfo date2) {
                return date1.getDate().compareTo(date2.getDate());
            }
        });

        return weeklyTodayInfoList;
    }
}
