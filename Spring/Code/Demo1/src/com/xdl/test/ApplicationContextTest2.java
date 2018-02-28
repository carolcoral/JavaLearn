package com.xdl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdl.bean.Card;
import com.xdl.bean.Player;

public class ApplicationContextTest2 {

	public static void main(String[] args) {
		ApplicationContext  app  = 
			new  ClassPathXmlApplicationContext("applicationContext2.xml");
		Card cardb = app.getBean("cardb", Card.class);
		System.out.println(cardb);
		Card cardc = app.getBean("cardc", Card.class);
		System.out.println(cardc);
        Player  player  =  app.getBean("player", Player.class);
        System.out.println(player);
	}

}
