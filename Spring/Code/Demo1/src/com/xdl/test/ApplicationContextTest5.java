package com.xdl.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdl.bean.Card;
import com.xdl.bean.MsgBean;
import com.xdl.bean.Player;

public class ApplicationContextTest5 {

	public static void main(String[] args) throws SQLException {
		ApplicationContext  app  = 
			new  ClassPathXmlApplicationContext("applicationContext5.xml");
        MsgBean  msgBean = app.getBean("msgBean", MsgBean.class);
        System.out.println(msgBean +":" + msgBean.getPhones() + 
        		":" + msgBean.getPhones2());
        MsgBean  msgBean2 = app.getBean("msgBean2", MsgBean.class);
        System.out.println(msgBean2+"\n" + msgBean2.getPhones()+"\n" 
           + msgBean2.getPhones2() );
	}

}
