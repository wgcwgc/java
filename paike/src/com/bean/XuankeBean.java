package com.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.util.*;

public class XuankeBean
{
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public ArrayList getXuesheng(String xueshengid)
	{
		ArrayList al = new ArrayList();
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select a.xueshengid,a.xingming,b.banji,b.nianji,c.zhuanye from xuesheng a,banji b,zhuanye c where a.banjiid=b.banjiid and b.zhuanyeid=c.zhuanyeid and a.xueshengid='"
					+ xueshengid + "'");
			rs.next();
			al.add(rs.getString(1));
			al.add(rs.getString(2));
			al.add(rs.getString(3));
			al.add(rs.getString(4));
			al.add(rs.getString(5));
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
	
	public ArrayList getAllKecheng(String xueshengid)
	{
		ArrayList al = new ArrayList();
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select c.kechengming from xuesheng a,banji b,kecheng c where a.banjiid=b.banjiid and b.zhuanyeid=c.zhuanyeid and a.xueshengid='"
					+ xueshengid + "'");
			while(rs.next())
			{
				al.add(rs.getString(1));
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
	
	public ArrayList getXuanKecheng(String xueshengid)
	{
		ArrayList al = new ArrayList();
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select c.kechengid, c.kechengming from xuesheng a,banji b,kecheng c where a.banjiid=b.banjiid and b.zhuanyeid=c.zhuanyeid and b.nianji=c.nianji and a.xueshengid='"
					+ xueshengid
					+ "' and c.kechengid not in(select kechengid from xuanke where xueshengid='"
					+ xueshengid + "')");
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
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
	
	public int getXuefen(String xueshengid)
	{
		int temp = 0;
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select count(xuefen) from xueshengkecheng where xueshengid='"
					+ xueshengid + "' and xuefen=0");
			rs.next();
			temp = rs.getInt(1);
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
	
	public int getFeiyong(String xueshengid)
	{
		int temp = 0;
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select count(feiyong) from xueshengkecheng where xueshengid='"
					+ xueshengid + "' and feiyong=0");
			rs.next();
			temp = rs.getInt(1);
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
	
	public void xuanke(String [] kechengid , String xueshengid)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			for(int i = 0 ; i < kechengid.length ; i ++ )
			{
				rs = st.executeQuery("select * from xuanke where xueshengid='"
						+ xueshengid + "' and kechengid='" + kechengid[i] + "'");
				if(rs.next())
				{
					continue;
				}
				else
				{
					rs = st.executeQuery("select max(xuankeid) from xuanke");
					rs.next();
					int max = rs.getInt(1);
					st.executeUpdate("insert into xuanke(xuankeid,xueshengid,kechengid) values("
							+ ( max + 1 )
							+ ",'"
							+ xueshengid
							+ "','"
							+ kechengid[i] + "')");
				}
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
	}
	
	public ArrayList tuike(String xueshengid)
	{
		ArrayList al = new ArrayList();
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select a.xuankeid,b.kechengming from xuanke a,kecheng b where a.kechengid=b.kechengid and a.xueshengid='"
					+ xueshengid + "' and a.zhuangtai=1");
			while(rs.next())
			{
				ArrayList alRow = new ArrayList();
				alRow.add(rs.getString(1));
				alRow.add(rs.getString(2));
				al.add(alRow);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return al;
	}
	
	public void tuikequeren(String [] xuankeid)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			for(int i = 0 ; i < xuankeid.length ; i ++ )
			{
				st.executeUpdate("delete from xuanke where xuankeid='"
						+ xuankeid[i] + "'");
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
	}
	
	public void xuankequeren(String [] xuankeid)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			for(int i = 0 ; i < xuankeid.length ; i ++ )
			{
				st.executeUpdate("update xuanke set zhuangtai=1 where xuankeid='"
						+ xuankeid[i] + "'");
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
	}
}
