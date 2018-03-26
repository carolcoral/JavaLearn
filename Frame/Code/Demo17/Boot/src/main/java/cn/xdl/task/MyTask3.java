package cn.xdl.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask3 {
	
//	@Scheduled(fixedRate=5000,initialDelay=2000)
	@Scheduled(cron="0 0/5 * ? * *")
	public void execute(){
		System.out.println("自动执行任务3,时间:"+new Date());
	}
	
}
