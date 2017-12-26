import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TestResultSetMetaData {

	public static void printRs(String sql) {
		String url = "jdbc:oracle:thin:@loacalhost:1521:XE";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, "system", "123456");
			Statement statement = connection.createStatement();
			ResultSet rSet = statement.executeQuery(sql);
			// 获取元数据
			ResultSetMetaData rem = rSet.getMetaData();
			for (int i = 1; i <= rem.getColumnCount(); i++) {// 获取从1到字段的数量
				System.out.print(rem.getColumnName(i) + '\t');
			}
			System.out.println();
			while (rSet.next()) {
				for (int i = 1; i <= rem.getColumnCount(); i++) {
					System.out.print(rSet.getString(i) + "\t");// 取字段的值，按次序
				}
				System.out.println();
			}
			statement.close();
			rSet.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		String sql = "select * from emp";
		printRs(sql);

	}

}
