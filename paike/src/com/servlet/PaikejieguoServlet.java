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

public class PaikejieguoServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public PaikejieguoServlet()
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
		String zhuanye = request.getParameter("zhuanye");
		String nianji = null;
		if(request.getParameter("nianji") != null
				&& ! request.getParameter("nianji").equals(""))
		{
			nianji = v.getUnicode(request.getParameter("nianji"));
		}
		KechengbiaoBean kb = new KechengbiaoBean();
		String sql = "select * from kebiao where zhuanyeid='" + zhuanye
				+ "' and nianji='" + nianji + "'";
		ArrayList al = kb.getKebiao(sql);
		request.setAttribute("list" , al);
		request.setAttribute("zhuanyeid" , zhuanye);
		request.setAttribute("nianji" , nianji);
		RequestDispatcher rd = request
				.getRequestDispatcher("jsp/paike/paikejieguo.jsp");
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
