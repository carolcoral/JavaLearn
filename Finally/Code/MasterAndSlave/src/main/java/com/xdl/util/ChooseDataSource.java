package com.xdl.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态获取数据源
 * @author likang
 */
public class ChooseDataSource extends AbstractRoutingDataSource{

	/**
	 * 获取与数据源相关的key值，此值是Map<String,DataSource> 中与数据源绑定的key值
	 * 通过determineTargetDataSource 获取目标数据源使用
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return HandleDataSource.getDataSource();
	}

}
