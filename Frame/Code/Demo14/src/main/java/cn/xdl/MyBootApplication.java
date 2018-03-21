package cn.xdl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"cn.xdl.dao"})
public class MyBootApplication {
	
	public static void main(String[] args) {
		//注意配置server.port端口,否则8080冲突
		SpringApplication.run(MyBootApplication.class);
	}
	
}
