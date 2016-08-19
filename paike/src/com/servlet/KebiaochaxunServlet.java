package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.KechengbiaoBean;
import com.util.Validate;

public class KebiaochaxunServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public KebiaochaxunServlet()
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
		Validate v = new Validate();
		String zhuanyeid = request.getParameter("zhuanyeid");
		String zhuanye = request.getParameter("zhuanye");
		String kechengid = request.getParameter("kechengid");
		String kecheng = request.getParameter("kecheng");
		String nianjiid = request.getParameter("nianjiid");
		String nianji = null;
		if(request.getParameter("nianji") != null
				&& ! request.getParameter("nianji").equals(""))
		{
			nianji = v.getUnicode(request.getParameter("nianji"));
		}
		String banjiid = request.getParameter("banjiid");
		String banji = request.getParameter("banji");
		String xingqiid = request.getParameter("xingqiid");
		String xingqi = request.getParameter("xingqi");
		String laoshiid = request.getParameter("laoshiid");
		String laoshi = request.getParameter("laoshi");
		String kejieid = request.getParameter("kejieid");
		String kejie = request.getParameter("kejie");
		String jiaoshiid = request.getParameter("jiaoshiid");
		String jiaoshi = request.getParameter("jiaoshi");
		String sql = "select * from kebiao";
		
		if(zhuanyeid != null && zhuanyeid.equals("1"))
		{
			sql += " where zhuanyeid='" + zhuanye + "'";
		}
		if(kechengid != null && kechengid.equals("1"))
		{
			sql += " where kechengid='" + kecheng + "'";
		}
		if(nianjiid != null && nianjiid.equals("1"))
		{
			sql += " where nianji='" + nianji + "'";
		}
		if(banjiid != null && banjiid.equals("1"))
		{
			sql += " where banjiid='" + banji + "'";
		}
		if(xingqiid != null && xingqiid.equals("1"))
		{
			sql += " where xingqi='" + xingqi + "'";
		}
		if(laoshiid != null && laoshiid.equals("1"))
		{
			sql += " where laoshiid='" + laoshi + "'";
		}
		if(kejieid != null && kejieid.equals("1"))
		{
			sql += " where kejie='" + kejie + "'";
		}
		if(jiaoshiid != null && jiaoshiid.equals("1"))
		{
			sql += " where jiaoshiid='" + jiaoshi + "'";
		}
		KechengbiaoBean kb = new KechengbiaoBean();
		ArrayList list = kb.getKebiao(sql);
		request.setAttribute("list" , list);
		RequestDispatcher rd = request
				.getRequestDispatcher("jsp/paike/kebiaochaxun.jsp");
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
