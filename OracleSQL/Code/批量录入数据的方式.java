import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestBatch {

	public static void main(String[] args) {//批量录入数据
		String url = "jdbc:mysql://localhost:3306/phpems";
		String user = "root";
		String passwd = "947752894";
		Connection connection = null;
		try {
			long start = System.currentTimeMillis();
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, passwd);
			String sql = "insert into user values(seq_user.nextval,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			for (int i = 0; i <= 1000000; i++) {
				pStatement.setString(1, "zhangfei"+i);
				pStatement.setString(2, "zhangfei"+i+"@zhangfei.com");
				pStatement.addBatch();
				if (i % 10000 == 1999) {
					pStatement.executeBatch();
				}
			}
			long end = System.currentTimeMillis();
			long time = end - start;
			System.out.println(time);
			connection.close();
			pStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
