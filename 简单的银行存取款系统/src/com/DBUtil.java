package com;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Connection;
public class DBUtil {
	/**
	 * ������ݼ���alt + shift + o
	 *��ȡ����---���ݿ���Java����֮�������
	 *Connection:����Java��������ݿ�֮�������
	 *Statement��ִ��SQL���
	 *ResultSet:����洢ִ����select�������
	 */
	public static Connection getConnection()throws SQLException{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//�������ݿ�����
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234567");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) throws SQLException {
		Connection conn = getConnection();//��ȡ�����ݿ�֮�������
		System.out.println(getConnection());
		Statement st = conn.createStatement();//����Statement
		ResultSet rs = st.executeQuery("select * from user_information");//ִ��SQL���
		while(rs.next()){
			System.out.println("����ǣ�\n" + rs.getString(1) + "�˺���:" + rs.getString(2) + "�����ǣ�" + rs.getString(3));
		}
	}
}
