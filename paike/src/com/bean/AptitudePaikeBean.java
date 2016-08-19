package com.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.util.*;

public class AptitudePaikeBean
{
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	ArrayList kecheng = new ArrayList();
	ArrayList banji = new ArrayList();
	ArrayList jiaoshi = new ArrayList();
	ArrayList laoshi = new ArrayList();
	
	public ArrayList getKecheng(String zhuanye , String nianji)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select a.*,b.*,c.* from kecheng a,kechengtime b,zhuanye c where a.kechengid=b.kechengid and a.zhuanyeid=c.zhuanyeid and a.zhuanyeid='"
					+ zhuanye + "' and a.nianji='" + nianji + "'");
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
				alRow.add(rs.getString(3));
				alRow.add(rs.getString(4));
				alRow.add(rs.getString(5));
				alRow.add(rs.getString(7));
				alRow.add(rs.getString(9));
				alRow.add(rs.getString(10));
				alRow.add(rs.getString(11));
				alRow.add(rs.getString(12));
				kecheng.add(alRow);
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
		return kecheng;
	}
	
	public ArrayList getBanji(String zhuanye , String nianji)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select * from banji where zhuanyeid='"
					+ zhuanye + "' and nianji='" + nianji + "'");
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
				alRow.add(rs.getString(3));
				alRow.add(rs.getString(4));
				alRow.add(rs.getString(5));
				banji.add(alRow);
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
		return banji;
	}
	
	public ArrayList getJiaoshi()
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select * from jiaoshi");
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
				alRow.add(rs.getString(3));
				jiaoshi.add(alRow);
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
		return jiaoshi;
	}
	
	public ArrayList getLaoshi()
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select * from laoshi");
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
				alRow.add(rs.getString(3));
				laoshi.add(alRow);
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
		return laoshi;
	}
	
}
