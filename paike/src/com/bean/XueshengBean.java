package com.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.util.*;

public class XueshengBean
{
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public ArrayList getKecheng(String sql)
	{
		ArrayList al = new ArrayList();
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
				alRow.add(rs.getString(3));
				alRow.add(rs.getString(4));
				alRow.add(rs.getString(5));
				alRow.add(rs.getString(6));
				alRow.add(rs.getString(7));
				alRow.add(rs.getString(8));
				alRow.add(rs.getString(9));
				al.add(alRow);
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
		return al;
	}
	
	public ArrayList getKebiao(String sql)
	{
		ArrayList al = new ArrayList();
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
				alRow.add(rs.getString(3));
				alRow.add(rs.getString(4));
				alRow.add(rs.getString(5));
				al.add(alRow);
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
		return al;
	}
}
