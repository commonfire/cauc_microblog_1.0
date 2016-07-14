package cn.cauc.db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class JDBCConnect {
	static String drivername="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://10.109.243.244:3306/cauc_microblog?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
	static String username="root";
	static String password="root";

	static {
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection(url, username, password);
			System.out.println("connect DB success!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = getConnection();
		conn.close();
	}
}
