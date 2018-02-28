package com.xdl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdl.bean.Card;
import com.xdl.bean.Player;

public class ApplicationContextTest3 {

	public static void main(String[] args) {
		ApplicationContext  app  = 
			new  ClassPathXmlApplicationContext("applicationContext3.xml");
        Player  player  =  app.getBean("player", Player.class);
        System.out.println(player);
	}

}
