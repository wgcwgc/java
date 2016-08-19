package com.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.util.*;

public class WeihuBean
{
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public void getUpdate(String sql)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			st.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBConn.close(conn , st , rs);
		}
	}
	
}
