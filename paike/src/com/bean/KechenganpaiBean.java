package com.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.util.*;

public class KechenganpaiBean
{
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public void update(String kechengid , String begintime , String endtime)
	{
		conn = DBConn.getConn();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select * from kechengtime where kechengid='"
					+ kechengid + "'");
			if(rs.next())
			{
				st.executeUpdate("update kechengtime set begintime='"
						+ begintime + "',endtime='" + endtime
						+ "' where kechengid='" + kechengid + "'");
			}
			else
			{
				st.executeUpdate("insert into kechengtime(kechengid,begintime,endtime) values('"
						+ kechengid
						+ "','"
						+ begintime
						+ "','"
						+ endtime
						+ "')");
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
