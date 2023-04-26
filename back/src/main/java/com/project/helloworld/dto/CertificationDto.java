package com.project.helloworld.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@RequiredArgsConstructor
@Repository
public class CertificationDto {
    private final String PREFIX = "certification:";  // Redis에 저장되는 Key값이 중복되지 않도록 상수 선언
    private final int LIMIT_TIME = 3 * 60;  // redis에서의 유효시간 설정

    private final StringRedisTemplate stringRedisTemplate;

    public void createCertification(String userInfo, String certificationNumber) { // 사용자가 입력한 정보와 인증 내용을 저장하고 TTL을 180초로 설정
        stringRedisTemplate.opsForValue()
                .set(PREFIX + userInfo, certificationNumber, Duration.ofSeconds(LIMIT_TIME));
    }

    public String getCertification(String userInfo) { // Redis에서 인증KEY에 해당하는 인증 메세지를 리턴
        return stringRedisTemplate.opsForValue().get(PREFIX + userInfo);
    }

    public void removeCertification(String userInfo) { // 인증이 완료되었을 경우 메모리 관리를 위해 Redis에 저장된 인증번호 삭제
        stringRedisTemplate.delete(PREFIX + userInfo);
    }

    public boolean hasKey(String userInfo) {  // Redis에 해당 KEY로 저장된 인증 메세지(VALUE)가 존재하는지 확인
        return stringRedisTemplate.hasKey(PREFIX + userInfo);
    }
}
