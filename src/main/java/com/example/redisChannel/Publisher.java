package com.example.redisChannel;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class Publisher {

    private final Jedis jedis;

    public Publisher() {
//
        this.jedis = new Jedis("redis://localhost:6379");
    }

    public void publishMessage(String channel, String message) {
        jedis.publish(channel, message);
    }
}
