package cn.xdl.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyTask2 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("自动执行任务2处理");
	}

}
