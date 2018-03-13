package com.xdl.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdl.bean.Card;
import com.xdl.bean.MsgBean;
import com.xdl.bean.Player;

public class ApplicationContextTest6 {

	public static void main(String[] args) throws SQLException {
		//BasicDataSource
		ApplicationContext  app  = 
			new  ClassPathXmlApplicationContext("applicationContext6.xml");
        MsgBean  msgBean = app.getBean("msgBean", MsgBean.class);
        System.out.println(msgBean.getPhones2() + "\n" + 
        msgBean.getTitle());
        DataSource  dataSource = app.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.getConnection());
       
	}

}
