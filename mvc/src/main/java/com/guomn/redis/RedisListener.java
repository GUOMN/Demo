package com.guomn.redis;


import com.google.gson.Gson;
import java.lang.invoke.MethodHandles;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.util.ObjectUtils;

/**
 * @author 郭梦男
 * @date 2019/6/28 9:13
 */
public class RedisListener implements MessageListener {

  private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  private Gson gson = new Gson();

  private final String REDIS_PSUBSCRIBE_PREFIX;
  private final Consumer<String> consumer;

  public RedisListener(String redis_psubscribe_prefix, Consumer<String> consumer) {
    REDIS_PSUBSCRIBE_PREFIX = redis_psubscribe_prefix.replace("*", "");
    this.consumer = consumer;
  }
  public static RedisListener getListener(String redis_psubscribe_prefix, Consumer<String> consumer){
    return new RedisListener(redis_psubscribe_prefix, consumer);
  }

  @Override
  public void onMessage(Message message, byte[] pattern) {
    if (ObjectUtils.isEmpty(message.getChannel()) || ObjectUtils.isEmpty(message.getBody())) {
      return;
    }
    // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
    String channel = new String(message.getChannel());
    LOG.debug("监听到redis事件, {}", gson.toJson(message));

    if (channel.startsWith(REDIS_PSUBSCRIBE_PREFIX)) {
      LOG.info("监听到redis事件{}:{}", REDIS_PSUBSCRIBE_PREFIX, gson.toJson(message));

      String key = channel.replace(REDIS_PSUBSCRIBE_PREFIX, "");
      handleMessage(key);
    }
  }

  private void handleMessage(String key){
    consumer.accept(key);
  }
}