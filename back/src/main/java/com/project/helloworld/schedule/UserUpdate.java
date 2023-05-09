package com.project.helloworld.schedule;

import com.project.helloworld.domain.TodayVisit;
import com.project.helloworld.domain.User;
import com.project.helloworld.repository.TodayVisitRepository;
import com.project.helloworld.repository.UserRepository;
import com.project.helloworld.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserUpdate {

    private final UserRepository userRepository;
    private final VisitorService visitorService;
    private final TodayVisitRepository todayVisitRepository;

    /**
     * user Today 매일 자정에 DB로 업데이트
     */
    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul")
    @Transactional
    public void updateToday() throws Exception {
        List<User> userList = userRepository.findAll();
        List<Long> userSeqList = userList.stream().map(User::getUserSeq).collect(Collectors.toList());
        for (Long userSeq : userSeqList){
            Long todayVisitors = visitorService.getTodayVisitors(String.valueOf(userSeq));
            TodayVisit todayVisit = new TodayVisit();
            LocalDate today = LocalDate.now();

            // Today DB로 업데이트
            User user = userRepository.findByUserSeq(userSeq).orElseThrow(()-> new Exception("해당하는 유저가 없습니다." + userSeq));
            todayVisit.setTodayCnt(todayVisitors);
            todayVisit.setDate(today);
            todayVisit.setUser(user);
            todayVisitRepository.save(todayVisit);

            // redis today 만료
            visitorService.expireTodayVisitors(String.valueOf(userSeq));
        }
    }

    /**
     * user Total 새벽4시마다 업데이트
     */
    @Scheduled(cron = "0 0 4 * * *", zone = "Asia/Seoul")
    @Transactional
    public void updateTotal() throws Exception {
        List<User> userList = userRepository.findAll();
        List<Long> userSeqList = userList.stream().map(User::getUserSeq).collect(Collectors.toList());

        // redis에 저장된 total수와 DB에 저장된 total + today가 같지 않다면 DB정보로 갱신하고 redis Total도 DB Total로 갱신
        for(Long userSeq : userSeqList){
            User user = userRepository.findByUserSeq(userSeq).orElseThrow(()-> new Exception("해당하는 유저가 없습니다." + userSeq));

            LocalDate yesterDay = LocalDate.now().minusDays(1);
            Long todayVisitors = todayVisitRepository.findTodayCntByDateAndUserSeq(yesterDay, userSeq);

            if(visitorService.getTotalVisitors(String.valueOf(userSeq)) != user.getTotal() + todayVisitors
                    || visitorService.getTotalVisitors(String.valueOf(user)) == null){
                user.setTotal(user.getTotal() + todayVisitors);
                userRepository.save(user);
            }
        }
    }
}
