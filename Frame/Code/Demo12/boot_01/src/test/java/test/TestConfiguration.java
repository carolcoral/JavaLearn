package test;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import cn.xdl.bean.MyDataSource;
import cn.xdl.config.DataSourceConfig;

public class TestConfiguration {

	public static void main(String[] args) {
		ApplicationContext ac = 
			SpringApplication.run(DataSourceConfig.class);//@Configuration+@Bean
		MyDataSource ds = ac.getBean("mydatasource",MyDataSource.class);
		System.out.println(ds);
		ds.show();
		DataSource dbcp = ac.getBean("dbcp",DataSource.class);
		System.out.println(dbcp);
	}

}
