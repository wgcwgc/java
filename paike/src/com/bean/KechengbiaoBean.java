package com.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.util.*;

public class KechengbiaoBean
{
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	ArrayList al = null;
	
	public int saveKebiao(ArrayList save , String [] laoshiid ,
			String [] jiaoshiid)
	{
		int temp = 0;
		conn = DBConn.getConn();
		try
		{
			int i;
			conn.setAutoCommit(false);
			st = conn.createStatement();
			for(i = 0 ; i < save.size() ; i ++ )
			{
				ArrayList saveRow = (ArrayList) save.get(i);
				rs = st.executeQuery("select * from kebiao where zhuanyeid='"
						+ saveRow.get(0) + "' and nianji='" + saveRow.get(1)
						+ "' and xingqi='" + saveRow.get(2) + "' and kejie='"
						+ saveRow.get(3) + "' and kechengid='" + saveRow.get(4)
						+ "' and banjiid='" + saveRow.get(5)
						+ "' and laoshiid='" + laoshiid[i]
						+ "' and jiaoshiid='" + jiaoshiid[i] + "'");
				if(rs.next())
				{
					temp = 2;
					conn.rollback();
					break;
				}
				else
				{
					rs = st.executeQuery("select max(kebiaoid) from kebiao");
					rs.next();
					int kebiaoid = rs.getInt(1);
					st.executeUpdate("insert into kebiao(kebiaoid,zhuanyeid,nianji,xingqi,kejie,kechengid,banjiid,laoshiid,jiaoshiid) values("
							+ ( kebiaoid + 1 )
							+ ",'"
							+ saveRow.get(0)
							+ "','"
							+ saveRow.get(1)
							+ "','"
							+ saveRow.get(2)
							+ "','"
							+ saveRow.get(3)
							+ "','"
							+ saveRow.get(4)
							+ "','"
							+ saveRow.get(5)
							+ "','"
							+ laoshiid[i]
							+ "','"
							+ jiaoshiid[i] + "')");
				}
			}
			if(i == save.size())
			{
				temp = 1;
				conn.commit();
			}
		}
		catch(SQLException e)
		{
			try
			{
				conn.rollback();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			DBConn.close(conn , st , rs);
		}
		return temp;
	}
	
	public ArrayList getKebiao(String sql)
	{
		al = new ArrayList();
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
	
	public void updateKebiao(String sql)
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
