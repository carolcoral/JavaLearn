package cn.xdl.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.xdl.bean.Book;

/**
 * 对于Oracle数据库中的 book16 表格进行操作的类
 */
public class Oracle_BookDao_Imp implements BookDao {

	private static final String SQL_FIND_BOOK_ALL = "select * from book16";
	private static final String SQL_FIND_BOOK_BY_ID = "select * from book16 where id=?";
	/**
	 * 一个预编译的SQL语句, 用来根据id修改图书内容,<br>
	 * 预编译的参数为:<br>
	 * 1.	新的图书名称<br>
	 * 2.	新的图书描述<br>
	 * 3.	新的图书价格<br>
	 * 4.	要修改的图书id
	 */
	private static final String SQL_UPDATE_BOOK_BY_ID = "update book16 set name=?,info=?,rmb=? where id=?";
	private static final String SQL_DELETE_BOOK_BY_ID = "delete from book16 where id=?";
	private static final String SQL_INSERT_BOOK = "insert into book16 values(序列.nextval,?,?,?,'images/book05.jpg')";

	@Override
	public List<Book> findAll() {
		try {
			Connection conn = DBUtil.getConnection();
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(SQL_FIND_BOOK_ALL);
			ArrayList<Book> books = new ArrayList<>();
			// 循环从结果集中取出数据, 并放入list集合
			while (result.next()) {

				int id = result.getInt("id");
				String name = result.getString("name");
				String info = result.getString("info");
				int rmb = result.getInt("rmb");
				String imgpath = result.getString("imgpath");
				Book book = new Book(id, name, info, rmb, imgpath);
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Book findBookById(int bookId) {
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement state = conn.prepareStatement(SQL_FIND_BOOK_BY_ID);
			state.setInt(1, bookId);
			ResultSet result = state.executeQuery();
			// 循环从结果集中取出数据, 并放入list集合
			if(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String info = result.getString("info");
				int rmb = result.getInt("rmb");
				String imgpath = result.getString("imgpath");
				Book book = new Book(id, name, info, rmb, imgpath);
				return book;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateBookById(int id, Book book) {
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement state = conn.prepareStatement(SQL_UPDATE_BOOK_BY_ID);
			state.setString(1, book.getName());
			state.setString(2, book.getInfo());
			state.setInt(3, book.getRmb());
			state.setInt(4, id);
			return state.executeUpdate()>0?true:false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBookById(int id) {
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement state = conn.prepareStatement(SQL_DELETE_BOOK_BY_ID);
			state.setInt(1, id);
			return state.executeUpdate()>0?true:false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertBook(Book book) {
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement state = conn.prepareStatement(SQL_INSERT_BOOK);
			state.setString(1, book.getName());
			state.setString(2, book.getInfo());
			state.setInt(3, book.getRmb());
			return state.executeUpdate()>0?true:false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
