package cn.xdl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.xdl.entity.Student;

public interface StudentDao {
	
	@Select("select * from student")
	public List<Student> loadAll();
	
	@Insert("insert into student (NO,NAME,SEX) values (#{no},#{name},#{sex})")
	public void insert(Student stu);
	
	@Update("update student set name=#{name},sex=#{sex} where no=#{no}")
	public int update(Student stu);
	
	@Update("update student set name=#{name} where no=#{no}")
	public int updateName(@Param("no")int no,@Param("name")String name);
	 
	@Delete("delete from student where no=#{no}")
	public int delete(int no);
	
}
