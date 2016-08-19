package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.LoginBean;

public class LoginServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public LoginServlet()
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
		String name = request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		String admin = request.getParameter("admin");
		String xuesheng = request.getParameter("xuesheng");
		String laoshi = request.getParameter("laoshi");
		String str = "";
		LoginBean lb = new LoginBean();
		int flag = lb.login(name , pwd);
		if(flag == 2 || flag == 3)
		{
			if(admin != null && admin.equals("1"))
			{
				str = "jsp/login/adminLogin.jsp";
				request.setAttribute("admin" , "1");
			}
			if(xuesheng != null && xuesheng.equals("1"))
			{
				str = "jsp/login/xueshengLogin.jsp";
				request.setAttribute("xuesheng" , "1");
			}
			if(laoshi != null && laoshi.equals("1"))
			{
				str = "jsp/login/laoshiLogin.jsp";
				request.setAttribute("laoshi" , "1");
			}
		}
		if(flag == 1)
		{
			if(admin != null && admin.equals("1"))
			{
				str = "jsp/paike/kebiaochaxun.jsp";
			}
			if(xuesheng != null && xuesheng.equals("1"))
			{
				str = "jsp/xuanke/chaxunkecheng.jsp";
			}
			if(laoshi != null && laoshi.equals("1"))
			{
				str = "jsp/xuanke/chaxunkecheng.jsp";
			}
			ArrayList al = lb.getArrayLst();
			HttpSession session = request.getSession();
			session.setAttribute("login" , al);
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
