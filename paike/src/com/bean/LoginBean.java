package com.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.util.*;

public class LoginBean
{
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	ArrayList al = new ArrayList();
	
	public int login(String name , String pwd)
	{
		int temp = 0;
		conn = DBConn.getConn();
		try
		{
//			System.out.println("lngin");
			st = conn.createStatement();
			rs = st.executeQuery("select * from login where username='" + name
					+ "'");
//			System.out.println("login");
			if(rs.next())
			{
				String username = rs.getString("username");
				String userpwd = rs.getString("mima");
				String quanxian = rs.getString("quanxian");
				if(pwd.equals(userpwd))
				{
					temp = 1;
					al.add(username);
					al.add(userpwd);
					al.add(quanxian);
				}
				else
				{
					temp = 2;
				}
			}
			else
			{
				temp = 3;
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
	
	public ArrayList getArrayLst()
	{
		return al;
	}
	
}
