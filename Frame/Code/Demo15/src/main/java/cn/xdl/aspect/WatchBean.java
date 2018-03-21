package cn.xdl.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component//ioc
@Aspect//定义为切面
public class WatchBean {

	@Around("within(cn.xdl.controller.*)")
	public Object execute(ProceedingJoinPoint pjp) throws Throwable{
		//开始计时
		StopWatch watch = new StopWatch();
		watch.start();
		Object obj = pjp.proceed();//执行controller方法
		//结束计时
		watch.stop();
		long time = watch.getTotalTimeMillis();//执行时长
		String targetClass = pjp.getTarget().getClass().getName();//组件名
		String methodName = pjp.getSignature().getName();//方法名
		System.out.println("组件："+targetClass+"方法:"+methodName+"执行时长为:"+time+"ms");
		return obj;
	}
	
}
