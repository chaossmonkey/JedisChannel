package com.example.redisChannel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Publisher publisher;

    public TestController(Publisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/publish")
    public String publishMessage() {
        publisher.publishMessage("Math", "Don't forget to submit your homework by Friday.");
        return "Message published!";
    }
}
