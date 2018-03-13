package com.xdl.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdl.bean.Card;
import com.xdl.bean.Player;

public class ApplicationContextTest4 {

	public static void main(String[] args) throws SQLException {
		ApplicationContext  app  = 
			new  ClassPathXmlApplicationContext("applicationContext4.xml");
        Card  card  = app.getBean("card",Card.class);
        System.out.println(card);
        DataSource  dataSource = app.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
	}

}
