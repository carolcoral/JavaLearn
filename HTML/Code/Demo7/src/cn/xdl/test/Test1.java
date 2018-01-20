package cn.xdl.test;


import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

import cn.xdl.db.DBUtil;

public class Test1 {

	@Test
	public void test1() throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement state = conn.createStatement();
		int count = state.executeUpdate("insert into book16 values(20,'高飞在一本道辛苦修道的日子','riyuqiannv ,hahahahahhahahahhahahahahahahhahahahahahahah',18888)");
		if(count>0) {
			System.out.println("插入 成功");
		}else {
			System.out.println("插入 失败, 请检查BUG后, 再插入");
			
		}
	}
}
