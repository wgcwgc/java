package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.WeihuBean;

public class XiugaipwdServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public XiugaipwdServlet()
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
		String xiugaipwd = request.getParameter("xiugaipwd");
		String nwepwd = request.getParameter("nwepwd");
		String zhuxiao = request.getParameter("zhuxiao");
		String str = "";
		
		HttpSession session = request.getSession();
		if(xiugaipwd != null && xiugaipwd.equals("1"))
		{
			str = "jsp/xuanke/xiugaipwd.jsp";
			ArrayList login = (ArrayList) session.getAttribute("login");
			String xueshengid = (String) login.get(0);
			String sql = "update login set mima='" + nwepwd
					+ "' where username='" + xueshengid + "'";
			WeihuBean wb = new WeihuBean();
			wb.getUpdate(sql);
			login.set(1 , nwepwd);
			request.setAttribute("chenggong" , "1");
		}
		if(zhuxiao != null && zhuxiao.equals("1"))
		{
			str = "jsp/login/xueshengLogin.jsp";
			session.removeAttribute("login");
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
