package cn.xdl.db;

import java.util.List;

import cn.xdl.bean.Book;

public interface BookDao {
	
	/**
	 * 用来查询所有图书的方法
	 * @return 查询到的一个图书列表
	 */
	List<Book> findAll();
	/**
	 * 用来查询单个图书的方法
	 * @param id 要查询的图书id
	 * @return 查询到的图书对象或者null , null表示id不存在!
	 */
	Book findBookById(int id);
	/**
	 * 根据图书id , 修改单个图书信息
	 * @param id 要修改的图书旧id
	 * @param book 新的图书信息
	 * @return 修改的结果, true表示修改成功, false表示修改失败
	 */
	boolean updateBookById(int id,Book book);
	/**
	 * 根据图书id ,删除一个图书
	 * @param id 要删除的图书id
	 * @return 删除的结果 true表示删除成功, false表示删除失败
	 */
	boolean deleteBookById(int id);
	/**
	 * 向数据库中加入一个新的图书对象
	 * @param book 要加入的新的图书对象
	 * @return 加入的结果, true表示添加成功, false表示添加失败
	 */
	boolean insertBook(Book book);
	
}
