package com.xdl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdl.bean.Card;
import com.xdl.bean.Player;

public class ApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext  app  = 
			new  ClassPathXmlApplicationContext("applicationContext.xml");
		Card card = app.getBean("card", Card.class);
		System.out.println(card);
        Player  player = app.getBean("player", Player.class);
        System.out.println(player);
	}

}
