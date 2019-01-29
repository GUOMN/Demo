package com.guomn.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.Message;

/**
 * Created by GuoMengnan on 2018/11/9.
 */

public class MQConsumer {
	public static void main(String[] args) {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("PushConsumer");
		consumer.setNamesrvAddr("192.168.0.203:9876");
//		consumer.setInstanceName("guomn");
		try {
			//订阅PushTopic下Tag为push的消息
			consumer.subscribe("PushTopic", "push");
			//程序第一次启动从消息队列头取数据
//			consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
			consumer.registerMessageListener((MessageListenerConcurrently) (list, Context) -> {
				Message msg = list.get(0);
				System.out.println(msg.toString());
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			});
			consumer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
