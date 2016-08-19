package com.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.util.*;

public class RegBean
{
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public int reg(String sql , String name , String shenfen)
	{
		int temp = 0;
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			if(shenfen.equals("1"))
			{
				rs = st.executeQuery("select * from xuesheng where xueshengid='"
						+ name + "'");
			}
			if(shenfen.equals("2"))
			{
				rs = st.executeQuery("select * from laoshi where laoshiid='"
						+ name + "'");
			}
			if(rs.next())
			{
				rs = st.executeQuery("select * from login where username='"
						+ name + "'");
				if(rs.next())
				{
					temp = 2;
				}
				else
				{
					temp = 1;
					st.executeUpdate(sql);
				}
			}
			else
			{
				temp = - 1;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBConn.close(conn , st , rs);
		}
		return temp;
	}
	
}
