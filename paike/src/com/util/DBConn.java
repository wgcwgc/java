package com.util;

import java.sql.*;

public class DBConn
{
	static
	{
		try
		{
//        	Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public static Connection getConn()
	{
		try
		{
//        	Connection conn=DriverManager.getConnection("jdbc:oracle:oci8:@paike","scott","tiger");
//        	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:tian","scott","tiger");
//        	Connection conn=DriverManager.getConnection("jdbc:odbc:paike","scott","tiger");
			Connection conn = DriverManager
					.getConnection(
							"jdbc:jtds:sqlserver://localhost:1433/paike;instance=SQLEXPRESS" ,
							"sa" , "sa");
			// conn=DriverManager.getConnection("jdbc:odbc:paike");
			return conn;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	public static void close(Connection conn , Statement st , ResultSet rs)
	{
		if(rs != null)
		{
			try
			{
				rs.close();
			}
			catch(SQLException ex)
			{
			}
		}
		if(st != null)
		{
			try
			{
				st.close();
			}
			catch(Exception ex)
			{
			}
		}
		if(conn != null)
		{
			try
			{
				conn.close();
			}
			catch(Exception ex)
			{
			}
		}
	}
	
}
