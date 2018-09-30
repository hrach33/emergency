package aua.engineering.emergency.controller;

import aua.engineering.emergency.entity.User;
import aua.engineering.emergency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@RestController
@RequestMapping("/emergency")
public class EmergencyController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @GetMapping("/user/{name}")
    private Mono<User> getUserByName(@PathVariable String name) {
        return userRepository.findByFirstName(name);
    }

    @GetMapping(value = "/allUsers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<User> getAllUsers() {
        return userRepository.findAll();

    }
}
