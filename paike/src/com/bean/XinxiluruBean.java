package com.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.util.*;

public class XinxiluruBean
{
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public void banjiluru(String banjiming , String nianji , String renshu ,
			String zhuanye)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select max(banjiid) from banji");
			rs.next();
			int id = rs.getInt(1);
			st.executeUpdate("insert into banji(banjiid,banji,nianji,renshu,zhuanyeid) values("
					+ ( id + 1 )
					+ ",'"
					+ banjiming
					+ "','"
					+ nianji
					+ "','"
					+ renshu + "','" + zhuanye + "')");
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
	
	public void xueshengluru(String xuehao , String xingming , String banji)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			st.executeUpdate("insert into xuesheng(xueshengid,xingming,banjiid) values('"
					+ xuehao + "','" + xingming + "','" + banji + "')");
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
	
	public void qingkuangluru(String xueshengid , String kecheng ,
			String xuefen , String feiyong)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select max(xueshengkechengid) from xueshengkecheng");
			rs.next();
			int id = rs.getInt(1);
			st.executeUpdate("insert into xueshengkecheng(xueshengkechengid,xueshengid,kechengid,xuefen,feiyong) values("
					+ ( id + 1 )
					+ ",'"
					+ xueshengid
					+ "','"
					+ kecheng
					+ "','"
					+ xuefen + "','" + feiyong + "')");
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
	
	public void zhuanyeluru(String zhuanyeming)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select max(zhuanyeid) from zhuanye");
			rs.next();
			int id = rs.getInt(1);
			st.executeUpdate("insert into zhuanye(zhuanyeid,zhuanye) values("
					+ ( id + 1 ) + ",'" + zhuanyeming + "')");
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
