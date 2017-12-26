//需要在当前包中导入 OracleSQL 官方提供的 ojdbc.jar 包文件

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class InsertData {

	public static void main(String[] args) {
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver"); 目前不在需要写这句话，从4.0开始自动加载
			String url = "jdbc:oracle:thin:@localhost:1521:XE";//通过 show parameter service 查看当前数据库的 SID
			Connection conn = DriverManager.getConnection(url,"system","123456");
			Statement st = conn.createStatement();
			String sql = "insert into dept values(1,'zhangfei','13')";
			String sql2 = "select empno,ename,sal from emp";
			ResultSet rs = st.executeQuery(sql2);
			while(rs.next()) {
				int id = rs.getInt("empno");
				String name = rs.getString("ename");
				double sal = rs.getDouble("sal");
				System.out.println(id+','+name+','+sal);
			}
			st.executeUpdate(sql);//执行 insert 语句，自动提交
			st.executeQuery(sql2);
			st.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
