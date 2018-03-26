package cn.xdl.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidDataSourceConfiguration {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource druid(){
		DruidDataSource ds = new DruidDataSource();
		try {
			ds.setFilters("stat");//设置监控sql语句
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		ds.setUsername("");
//		ds.setPassword("");
//		ds.setUrl("");
//		ds.setDriverClassName("");
//		DataSource ds = 
//			DataSourceBuilder.create().type(DruidDataSource.class).build();
		return ds;
	}
	
}
