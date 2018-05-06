package com.xdl.mq.consumer.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * 
 * @author liang
 * @description  Topic消息监听器
 * 
 */
@Component
public class TopicReceiver2 implements MessageListener{


	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("TopicReceiver2接收到消息:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}
