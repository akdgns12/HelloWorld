package com.project.notify.repository;

import com.project.notify.domain.Notify;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface NotifyRepository extends ReactiveMongoRepository<Notify, String> {

    @Tailable
    @Query("{receiveUserSeq: ?0, deleted: false}")
    Flux<Notify> findByUser(Long receiveUserSeq);

    @Query("{notifySeq: ?0, deleted: false}")
    Mono<Notify> findByNotifySeq(String notifySeq);

}