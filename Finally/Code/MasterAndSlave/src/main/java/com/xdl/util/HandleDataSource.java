package com.xdl.util;

public class HandleDataSource {
	
	
	public static final ThreadLocal<String> holder = new ThreadLocal<String>();
	
	
	/**
	 * 绑定当前线程的数据源
	 */
	public static void putDataSource(String datasource){
		holder.set(datasource);
	}
	
	/**
	 * 获取当前线程的数据源
	 */
	public static String getDataSource(){
		return holder.get();
	}

}
