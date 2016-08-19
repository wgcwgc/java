package com.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.util.*;

public class AllBean
{
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	ArrayList kecheng = new ArrayList();
	ArrayList laoshi = new ArrayList();
	ArrayList jiaoshi = new ArrayList();
	ArrayList kechengtime = new ArrayList();
	ArrayList zhuanye = new ArrayList();
	ArrayList banji = new ArrayList();
	ArrayList xueshengchaxun = new ArrayList();
	
	public ArrayList getKecheng()
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select a.*,b.* from kecheng a,zhuanye b where a.zhuanyeid=b.zhuanyeid");
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
				alRow.add(rs.getString(9));
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
	
	public ArrayList getjiaoshi()
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
	
	public ArrayList getKechengtime()
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select a.kechengid,a.kechengming,b.begintime,b.endtime from kecheng a,kechengtime b where a.kechengid *=b.kechengid");
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
				alRow.add(rs.getString(3));
				alRow.add(rs.getString(4));
				kechengtime.add(alRow);
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
		return kechengtime;
	}
	
	public ArrayList getZhuanye()
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select * from zhuanye");
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
				zhuanye.add(alRow);
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
		return zhuanye;
	}
	
	public ArrayList getBanji()
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select * from banji");
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
				alRow.add(rs.getString(3));
				alRow.add(rs.getString(4));
				alRow.add(rs.getString(5));
				alRow.add(rs.getString(6));
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
	
	public ArrayList getXueshengChaxun()
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select a.kechengid,a.kechengming,b.begintime,b.endtime,c.laoshiid,c.xingming from kecheng a,kechengtime b,laoshi c where a.kechengid=b.kechengid and b.kechengid=c.kechengid and a.kechengid=c.kechengid order by a.kechengid");
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
				alRow.add(rs.getString(3));
				alRow.add(rs.getString(4));
				alRow.add(rs.getString(5));
				alRow.add(rs.getString(6));
				xueshengchaxun.add(alRow);
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
		return xueshengchaxun;
	}
	
	public ArrayList getXuanke()
	{
		ArrayList al = new ArrayList();
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select a.xuankeid,a.xueshengid,b.xingming,c.kechengming from xuanke a,xuesheng b,kecheng c where a.xueshengid=b.xueshengid and a.kechengid=c.kechengid and a.zhuangtai=0");
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
				alRow.add(rs.getString(3));
				alRow.add(rs.getString(4));
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
