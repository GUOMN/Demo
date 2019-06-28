package com.guomn.redis;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * @author 郭梦男
 * @date 2019/6/27 16:22
 */
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {
  private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
    super(listenerContainer);
  }

  @Override
  public void onMessage(Message message, byte[] pattern) {
    // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
    String expiredKey = message.toString();
    if(expiredKey.startsWith("oss:domain:delete:")){
      //TODO
      LOG.info("监听到key过期, {}", expiredKey);
    }
  }
}
