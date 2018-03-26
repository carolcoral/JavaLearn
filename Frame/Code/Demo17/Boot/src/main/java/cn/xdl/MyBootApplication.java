package cn.xdl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@MapperScan(basePackages={"cn.xdl.dao"})
@ServletComponentScan//扫描@WebServlet、@WebListener、@WebFilter
@EnableScheduling//启动@Scheduled
public class MyBootApplication {
	
	
	
	public static void main(String[] args) {
		//注意配置server.port端口,否则8080冲突
		SpringApplication.run(MyBootApplication.class);
	}
	
}
