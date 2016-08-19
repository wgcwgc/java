package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.XuankeBean;

public class XuankeQuerenServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public XuankeQuerenServlet()
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
		String i = request.getParameter("i");
		String [] xuankeid = new String [Integer.parseInt(i)];
		
		for(int j = 0 ; j < Integer.parseInt(i) ; j ++ )
		{
			xuankeid[j] = request.getParameter("xuankeid" + j);
		}
		
		XuankeBean xb = new XuankeBean();
		xb.xuankequeren(xuankeid);
		
		request.setAttribute("queren" , "1");
		RequestDispatcher rd = request
				.getRequestDispatcher("jsp/paike/xuankequeren.jsp");
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
