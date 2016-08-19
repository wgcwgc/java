package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.XueshengBean;

public class XueshengChaxunServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public XueshengChaxunServlet()
	{
		super();
	}
	
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	public void doGet(HttpServletRequest request , HttpServletResponse response)
			throws ServletException , IOException
	{
		String laoshi = request.getParameter("laoshi");
		String kecheng = request.getParameter("kecheng");
		String laoshiid = request.getParameter("laoshiid");
		String kechengid = request.getParameter("kechengid");
		String sql1 = "";
		String sql2 = "";
		if(laoshiid != null && laoshiid.equals("1"))
		{
			if(laoshi != null && ! laoshi.equals(""))
			{
				sql1 = "select a.kechengid,a.kechengming,b.begintime,b.endtime,a.jiaoxuezhou,a.keshi,d.zhuanye,a.nianji,c.xingming from kecheng a,kechengtime b,laoshi c,zhuanye d where a.kechengid=b.kechengid and b.kechengid=c.kechengid and a.kechengid=c.kechengid and a.zhuanyeid=d.zhuanyeid and c.laoshiid='"
						+ laoshi + "' order by a.kechengid";
				sql2 = "select a.xingqi,a.kejie,b.banji,c.xingming,d.jiaoshi from kebiao a,banji b,laoshi c,jiaoshi d where a.banjiid=b.banjiid and a.laoshiid=c.laoshiid and a.jiaoshiid=d.jiaoshiid and a.laoshiid='"
						+ laoshi + "'";
			}
		}
		if(kechengid != null && kechengid.equals("1"))
		{
			if(kecheng != null && ! kecheng.equals(""))
			{
				sql1 = "select a.kechengid,a.kechengming,b.begintime,b.endtime,a.jiaoxuezhou,a.keshi,d.zhuanye,a.nianji,c.xingming from kecheng a,kechengtime b,laoshi c,zhuanye d where a.kechengid=b.kechengid and b.kechengid=c.kechengid and a.kechengid=c.kechengid and a.zhuanyeid=d.zhuanyeid and a.kechengid='"
						+ kecheng + "' order by a.kechengid";
				sql2 = "select a.xingqi,a.kejie,b.banji,c.xingming,d.jiaoshi from kebiao a,banji b,laoshi c,jiaoshi d where a.banjiid=b.banjiid and a.laoshiid=c.laoshiid and a.jiaoshiid=d.jiaoshiid and a.kechengid='"
						+ kecheng + "'";
			}
		}
		XueshengBean xb = new XueshengBean();
		ArrayList kechenglist = xb.getKecheng(sql1);
		ArrayList kebiaolist = xb.getKebiao(sql2);
		request.setAttribute("kechenglist" , kechenglist);
		request.setAttribute("kebiaolist" , kebiaolist);
		RequestDispatcher rd = request
				.getRequestDispatcher("jsp/xuanke/chaxunkechengxinxi.jsp");
		rd.forward(request , response);
	}
	
	public void doPost(HttpServletRequest request , HttpServletResponse response)
			throws ServletException , IOException
	{
		doGet(request , response);
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException
	{
		// Put your code here
	}
	
}
