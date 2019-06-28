package com.guomn.redis;

import java.lang.invoke.MethodHandles;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @author 郭梦男
 * @date 2019/6/27 17:28
 */
//@Component
public class RedisKeySpaceListener implements MessageListener, InitializingBean, DisposableBean {
  private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  private static final String REDIS_PSUBSCRIBE_PRIFIX = "__keyspace@*__:oss:domain:delete:*";

  private static final Topic TOPIC_ALL_KEYEVENTS = new PatternTopic(REDIS_PSUBSCRIBE_PRIFIX);

  private final RedisMessageListenerContainer listenerContainer;

  private String keyspaceNotificationsConfigParameter = "KAx";

  /**
   * Creates new {@link RedisKeySpaceListener}.
   *
   * @param listenerContainer must not be {@literal null}.
   */
  @Autowired
  public RedisKeySpaceListener(RedisMessageListenerContainer listenerContainer) {

    Assert.notNull(listenerContainer, "RedisMessageListenerContainer to run in must not be null!");
    this.listenerContainer = listenerContainer;
  }

  /**
   * Initialize the message listener by writing requried redis config for {@literal notify-keyspace-events} and
   * registering the listener within the container.
   */
  public void init() {

    if (StringUtils.hasText(keyspaceNotificationsConfigParameter)) {

      RedisConnection connection = listenerContainer.getConnectionFactory().getConnection();

      try {

        Properties config = connection.getConfig("notify-keyspace-events");

        if (!StringUtils.hasText(config.getProperty("notify-keyspace-events"))) {
          connection.setConfig("notify-keyspace-events", keyspaceNotificationsConfigParameter);
        }

      } finally {
        connection.close();
      }
    }

    doRegister(listenerContainer);
  }

  /**
   * Register instance within the container.
   *
   * @param container never {@literal null}.
   */
  protected void doRegister(RedisMessageListenerContainer container) {
    listenerContainer.addMessageListener(this, TOPIC_ALL_KEYEVENTS);
  }

  /*
   * (non-Javadoc)
   * @see org.springframework.beans.factory.DisposableBean#destroy()
   */
  @Override
  public void destroy() throws Exception {
    listenerContainer.removeMessageListener(this);
  }

  /**
   * Set the configuration string to use for {@literal notify-keyspace-events}.
   *
   * @param keyspaceNotificationsConfigParameter can be {@literal null}.
   * @since 1.8
   */
  public void setKeyspaceNotificationsConfigParameter(String keyspaceNotificationsConfigParameter) {
    this.keyspaceNotificationsConfigParameter = keyspaceNotificationsConfigParameter;
  }

  /*
   * (non-Javadoc)
   * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
   */
  @Override
  public void afterPropertiesSet() throws Exception {
    init();
  }
  @Override
  public void onMessage(Message message, byte[] pattern) {
    if (ObjectUtils.isEmpty(message.getChannel()) || ObjectUtils.isEmpty(message.getBody())) {
      return;
    }
    // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
    String expiredKey = new String(message.getChannel());
    if(expiredKey.startsWith(REDIS_PSUBSCRIBE_PRIFIX)){
      //TODO
      LOG.info("监听到key过期, {}", expiredKey);
    }
  }
}
