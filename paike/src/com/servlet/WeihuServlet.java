package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.WeihuBean;

public class WeihuServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public WeihuServlet()
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
		String jiaoshiUpdate = request.getParameter("jiaoshiUpdate");
		String jiaoshiDel = request.getParameter("jiaoshiDel");
		String kechengUpdate = request.getParameter("kechengUpdate");
		String kechengDel = request.getParameter("kechengDel");
		String laoshiUpdate = request.getParameter("laoshiUpdate");
		String laoshiDel = request.getParameter("laoshiDel");
		String id = request.getParameter("id");
		String i = request.getParameter("i");
		String renshu = request.getParameter("renshu" + i);
		String jiaoxuezhou = request.getParameter("jiaoxuezhou" + i);
		String keshi = request.getParameter("keshi" + i);
		String kecheng = request.getParameter("kecheng" + i);
		String sql = "";
		String str = "";
		
		WeihuBean wb = new WeihuBean();
		if(jiaoshiUpdate != null && jiaoshiUpdate.equals("1"))
		{
			sql = "update jiaoshi set renshu='" + renshu
					+ "' where jiaoshiid='" + id + "'";
			str = "jsp/paike/jiaoshiweihu.jsp";
		}
		if(jiaoshiDel != null && jiaoshiDel.equals("1"))
		{
			sql = "delete from jiaoshi where jiaoshiid='" + id + "'";
			str = "jsp/paike/jiaoshiweihu.jsp";
		}
		if(kechengUpdate != null && kechengUpdate.equals("1"))
		{
			sql = "update kecheng set jiaoxuezhou='" + jiaoxuezhou
					+ "',keshi='" + keshi + "' where kechengid='" + id + "'";
			str = "jsp/paike/kechengweihu.jsp";
		}
		if(kechengDel != null && kechengDel.equals("1"))
		{
			sql = "delete from kecheng where kechengid='" + id + "'";
			str = "jsp/paike/kechengweihu.jsp";
		}
		if(laoshiUpdate != null && laoshiUpdate.equals("1"))
		{
			sql = "update laoshi set kechengid='" + kecheng
					+ "' where laoshiid='" + id + "'";
			str = "jsp/paike/laoshiweihu.jsp";
		}
		if(laoshiDel != null && laoshiDel.equals("1"))
		{
			sql = "delete from laoshi where laoshiid='" + id + "'";
			str = "jsp/paike/laoshiweihu.jsp";
		}
		
		wb.getUpdate(sql);
		RequestDispatcher rd = request.getRequestDispatcher(str);
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
