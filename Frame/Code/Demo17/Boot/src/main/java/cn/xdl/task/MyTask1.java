package cn.xdl.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import cn.xdl.dao.DeptDao;
import cn.xdl.entity.Dept;

@Component
@Order(2)
public class MyTask1 implements ApplicationRunner{
	
	@Autowired
	private DeptDao deptDao;
	
	@Autowired
	private RedisTemplate<Object, Object> redis;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("自动执行任务1处理,将部门列表数据加载到缓存");
		List<Dept> list = deptDao.loadAll();
		redis.opsForValue().set("depts", list);
		//将单个dept缓存
		for(Dept dept:list){
			redis.opsForValue().set("dept:"+dept.getDeptno(), dept);
		}
	}

}
