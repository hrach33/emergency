package aua.engineering.emergency.repository;

import aua.engineering.emergency.entity.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository  extends ReactiveCrudRepository<User, String> {
    Mono<User> findByFirstName(final String firstName);


}