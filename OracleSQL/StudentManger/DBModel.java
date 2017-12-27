package day07;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBModel {

	Connection connection = null;

	public void InsertAction() throws Exception {
		connection = DBConnection.connection();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入要插入的数据(用户名,邮箱,密码)并以英文逗号隔开：");
		String res = bufferedReader.readLine();
		String sql = "insert into x2_user(username,useremail,userpassword) values(?,?,?)";
		String[] result = res.split(",");
		PreparedStatement pro = connection.prepareStatement(sql);
		pro.setString(1, result[0]);
		pro.setString(2, result[1]);
		pro.setString(3, result[2]);
		ResultSet res2 = pro.executeQuery();
		System.out.println("插入数据成功！");
		System.out.println("插入的数据是：" + res2);
		bufferedReader.close();
	}

	public void DeleteAction() {
		connection = DBConnection.connection();
		String sql = "delete * from x2_user where userid = ?";
		DataInputStream dataInputStream = new DataInputStream(System.in);
		System.out.println("请输入要删除的用户的 ID 值：");
		try {
			int res = dataInputStream.read();
			if (res > 0) {
				PreparedStatement pro = DBConnection.connection.prepareStatement(sql);
				pro.setInt(1, res);
				@SuppressWarnings("unused")
				ResultSet resultSet = pro.executeQuery();
				System.out.println("删除数据成功！");
			} else {
				System.out.println("输入错误，请重新输入！");
				DeleteAction();
			}
			dataInputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UpdateAction() throws Exception {
		SelectAction();
		DeleteAction();
		InsertAction();
	}

	public void SelectAction() throws Exception {
		connection = DBConnection.connection();
		System.out.println("请输入要查找的用户的 ID 值：");
		DataInputStream dataInputStream = new DataInputStream(System.in);
		try {
			int res = dataInputStream.read() - '0';
			String sql = "select * from x2_user where userid = ?";
			System.out.println("2344");
			PreparedStatement pro = connection.prepareStatement(sql);
			pro.setInt(1, res);
			System.out.println(pro);
			ResultSet resultSet = pro.executeQuery();
			if (resultSet.next()) {
				System.out.println("查找成功数据成功！");
				System.out.println("该数据是：\n" + resultSet);
			} else {
				System.out.println("查找失败，请重新输入用户 ID 进行查找！");
				SelectAction();
			}
			// dataInputStream.close();
		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
