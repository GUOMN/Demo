package com.guomn.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author 郭梦男
 * @date 2019/6/27 16:20
 */
@Configuration
public class RedisListenerConfig {
  @Value("${spring.redis.database}")
  private int dbNmuber;

  private final String REDIS_PSUBSCRIBE = "__keyspace@*__:oss:domain:delete:*"; //所有DB
  private String REDIS_PSUBSCRIBE_PREFIX = REDIS_PSUBSCRIBE.replace("__keyspace@*__", "__keyspace@"+ dbNmuber + "__");

  @Bean
  RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {

    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    /**
     * PSUBSCRIBE 可以使用通配符
     * E:event-->监听一个动作的所有key(__keyevent@0__:expired)
     * K:space-->监听一个key的所有动作(__keyspace@0__:a*)
     * x:过期事件
     */
    container.addMessageListener(new RedisListener(REDIS_PSUBSCRIBE_PREFIX), new PatternTopic(REDIS_PSUBSCRIBE_PREFIX));
    return container;
  }

}
