package cn.xdl.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConfigurationProperties(prefix="spring")
public class MyDataSourceConfig {
	
	private String name;
//	@Value("${password1}")//名称不一致可以使用@Value+EL表达式
	private String password;

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource myDataSource(){
		System.out.println("----------"+name);
		System.out.println("----------"+password);
		BasicDataSource ds = new BasicDataSource();
//		ds.setUsername("SCOTT");
//		ds.setPassword("TIGER");
//		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
//		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		return ds;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
