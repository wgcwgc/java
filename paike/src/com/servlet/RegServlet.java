package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RegBean;

public class RegServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public RegServlet()
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
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String shenfen = request.getParameter("shenfen");
		String str = "";
		String sql = "insert into login(username,mima,quanxian) values('"
				+ username + "','" + userpwd + "','" + shenfen + "')";
		RegBean rb = new RegBean();
		int flag = rb.reg(sql , username , shenfen);
		if(flag == 1)
		{
			if(shenfen != null && shenfen.equals("1"))
			{
				str = "jsp/login/xueshengLogin.jsp";
			}
			if(shenfen != null && shenfen.equals("2"))
			{
				str = "jsp/login/laoshiLogin.jsp";
			}
		}
		if(flag == 2)
		{
			str = "jsp/login/reg.jsp";
			request.setAttribute("name" , "1");
		}
		if(flag == - 1)
		{
			str = "jsp/login/reg.jsp";
			if(shenfen != null && shenfen.equals("1"))
			{
				request.setAttribute("xuesheng" , "1");
			}
			if(shenfen != null && shenfen.equals("2"))
			{
				request.setAttribute("laoshi" , "1");
			}
		}
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
