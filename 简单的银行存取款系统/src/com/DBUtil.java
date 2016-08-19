package com;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Connection;
public class DBUtil {
	/**
	 * 导包快捷键：alt + shift + o
	 *获取链接---数据库与Java程序之间的链接
	 *Connection:负责Java程序跟数据库之间的连接
	 *Statement：执行SQL语句
	 *ResultSet:负责存储执行了select语句结果集
	 */
	public static Connection getConnection()throws SQLException{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234567");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) throws SQLException {
		Connection conn = getConnection();//获取跟数据库之间的连接
		System.out.println(getConnection());
		Statement st = conn.createStatement();//创建Statement
		ResultSet rs = st.executeQuery("select * from user_information");//执行SQL语句
		while(rs.next()){
			System.out.println("序号是：\n" + rs.getString(1) + "账号是:" + rs.getString(2) + "密码是：" + rs.getString(3));
		}
	}
}
