
package com.xdl.mq.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * 
 * @author liang
 * @description  队列消息监听器
 * 
 */
@Component
public class QueueReceiver1 implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("QueueReceiver1接收到消息:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
