package com.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.util.*;

public class LuruBean
{
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public void laoshi(String name , String kecheng)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select max(laoshiid) from laoshi");
			rs.next();
			int id = rs.getInt(1);
			st.executeUpdate("insert into laoshi(laoshiid,xingming,kechengid) values("
					+ ( id + 1 ) + ",'" + name + "','" + kecheng + "')");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void kecheng(String name , String jiaoxuezhou , String keshi ,
			String zhuanye , String gong , String nianji)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select max(kechengid) from kecheng");
			rs.next();
			int id = rs.getInt(1);
			st.executeUpdate("insert into kecheng(kechengid,kechengming,jiaoxuezhou,keshi,zhuangtai,zhuanyeid,nianji) values("
					+ ( id + 1 )
					+ ",'"
					+ name
					+ "','"
					+ jiaoxuezhou
					+ "','"
					+ keshi
					+ "','"
					+ gong
					+ "','"
					+ zhuanye
					+ "','"
					+ nianji
					+ "')");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void jiaoshi(String name , String renshu)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select max(jiaoshiid) from jiaoshi");
			rs.next();
			int id = rs.getInt(1);
			st.executeUpdate("insert into jiaoshi(jiaoshiid,jiaoshi,renshu) values("
					+ ( id + 1 ) + ",'" + name + "','" + renshu + "')");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
