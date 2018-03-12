package com.xdl.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class CountExecuteMethodTime {
    /** 统计业务方法执行的时间 
     * @throws Throwable */
	@Around("execution(* login())")
	public   Object  around(ProceedingJoinPoint  pjp) throws Throwable{
		long  start = System.currentTimeMillis();
		Object   obj = pjp.proceed();
		long  end  = System.currentTimeMillis();
		System.out.println("方法:" + pjp.getSignature().getName() 
			+ ":执行时间:" + (end-start) + "毫秒"  );
		return  obj;
	}
}
