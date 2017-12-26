import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestLogin {

	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名和邮箱:");
		String url = "jdbc:mysql://localhost:3306/phpems";
		String user = "root";
		String passwd = "947752894";
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String name = bufferedReader.readLine();
			String mail = bufferedReader.readLine();
			bufferedReader.close();
			connection = DriverManager.getConnection(url, user, passwd);
			// 该方法因为 SQL 注入问题不安全，现在基本不用了
			// Statement statement = connection.createStatement();
			// String sql = "select username , useremail from x2_user where
			// username = '" + name + "' and useremail = '" + mail + "'";
			String sql = "select * from x2_user where username = ? and useremail = ?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, name);
			pStatement.setString(2, mail);
			ResultSet resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("登录验证成功！");
			} else {
				System.out.println("登录失败!");
			}
			resultSet.close();
			pStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
