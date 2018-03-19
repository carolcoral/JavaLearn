package cn.xdl.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.xdl.bean.MyDataSource;

@Configuration//<beans>
public class DataSourceConfig {
	
	//<bean id="xxx" class="xxxx">
	@Bean//将返回的ds对象放入Spring容器,id名为方法名createMyDataSource
	public MyDataSource createMyDataSource(){
		MyDataSource ds = new MyDataSource();
		return ds;
	}
	
	//<bean id="xxx" class="xxxx">
	@Bean("mydatasource")//将返回的ds对象放入Spring容器,id名为mydatasource
	public MyDataSource createMyDataSource1(){
		MyDataSource ds = new MyDataSource();
		return ds;
	}
	
	@Bean("dbcp")
	public DataSource createDbcp(){
		BasicDataSource dbcp = new BasicDataSource();
		dbcp.setUsername("");
		dbcp.setPassword("");
		dbcp.setUrl("");
		dbcp.setDriverClassName("");
		return dbcp;
	}
	
}
