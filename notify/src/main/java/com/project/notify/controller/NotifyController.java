package com.project.notify.controller;

import com.project.notify.domain.Notify;
import com.project.notify.dto.NotifyDto;
import com.project.notify.repository.NotifyRepository;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequiredArgsConstructor
@RequestMapping
@Slf4j
public class NotifyController {
  private final NotifyRepository notifyRepository;

  //[완료] 알림 리스트 중 특정 알림 클릭을 할 때 읽음 처리하기.
  @PutMapping
  public Mono<Notify> readStateChange(@RequestBody NotifyDto notifyIdx){
    return notifyRepository.findById(notifyIdx.getNotifySeq())
        .switchIfEmpty(Mono.error(new Exception("TASK_NOT_FOUND")))
        .map(b -> {
          b.setReadState(true);
          return b;
        })
        .flatMap(notifyRepository::save);
  }

  @GetMapping(value = "/{userSeq}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Notify> findByUser(@PathVariable Long userSeq) {
    LocalDateTime now = LocalDateTime.now(); // 현재 시간
    LocalDateTime threeDaysAgo = now.minusDays(3); // 3일 전의 시간

    return notifyRepository.findByUser(userSeq)
        .filter(notify -> notify.getCreatedTime().isAfter(threeDaysAgo)) // 알림 생성 시간이 3일 전보다 이후인지 확인
        .subscribeOn(Schedulers.boundedElastic());
  }



  // 특정 이벤트에 따른 알림 메세지 데이터 추가
  @PostMapping
  public Mono<Notify> setMsg(@RequestBody Notify notify){
    notify.setCreatedTime(LocalDateTime.now(ZoneId.of("Asia/Seoul")));
    return notifyRepository.save(notify).log(); //Object를 리턴하면 자동으로 JSON 변환 (MessageConverter)가 해줌
  }


  //삭제
  @DeleteMapping
  public Mono<Notify> deleteChange(@RequestBody NotifyDto notifyIdx){
    return notifyRepository.findById(notifyIdx.getNotifySeq())
        .switchIfEmpty(Mono.error(new Exception("TASK_NOT_FOUND")))
        .map(b -> {
          b.setDeleted(true);
          return b;
        })
        .flatMap(notifyRepository::save);
  }
}
