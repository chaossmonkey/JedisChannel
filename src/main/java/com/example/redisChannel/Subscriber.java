package com.example.redisChannel;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

@Component
public class Subscriber {

    public Subscriber() {
//
        Jedis jedis = new Jedis("redis://localhost:6379");
        JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("Received message: " + message + " from channel: " + channel);
            }
        };

        // Subscribe to the "Math" channel in a separate thread
    new Thread(() -> jedis.subscribe(jedisPubSub, "Math")).start();
//     jedis.subscribe(jedisPubSub, "Math");
    }
}
