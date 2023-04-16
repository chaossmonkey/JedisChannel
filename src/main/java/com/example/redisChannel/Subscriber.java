package com.example.redisChannel;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

@Component
public class Subscriber {





//    In Redis, channels are created implicitly when a message is published to a channel that does not already exist.
//    You don't need to create channels explicitly before subscribing to them.
//
//    When you subscribe to a channel that doesn't exist yet, the subscription will wait for messages to be published to that channel.
//    Once a message is published to the channel, the channel will be created automatically, and the subscribed clients will receive the message.
//
//    Similarly, if there are no subscribers left for a channel, Redis will automatically remove the channel.
//    So, in Redis, channels are created and removed dynamically based on the presence of published messages and active subscribers.









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
