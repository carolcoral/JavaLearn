package com.xdl.util;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 代理映射
 * @author likang
 */
public class DataSourceAspect {

	public void before(JoinPoint point){
		Object target = point.getTarget();//拦截的实体类对象
		String method = point.getSignature().getName();//拦截的方法名称
		Class<?>[] classz = target.getClass().getInterfaces();
		//拦截方法参数类型
		Class<?>[] parameterTypes = ((MethodSignature)point.getSignature()).getMethod().getParameterTypes();
		
		try {
			Method m = classz[0].getMethod(method, parameterTypes);
			if (m != null && m.isAnnotationPresent(DataSource.class)) {
				DataSource data = m.getAnnotation(DataSource.class);
				System.out.println("当前用户选择数据库类型为："+data.value());
				HandleDataSource.putDataSource(data.value());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
