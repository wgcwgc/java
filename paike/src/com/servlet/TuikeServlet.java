package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.XuankeBean;

public class TuikeServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public TuikeServlet()
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
		String [] xuankeid = null;
		int flag = 0;
		for(int j = 0 ; j < Integer.parseInt(i) ; j ++ )
		{
			if(request.getParameter("tuike" + j) != null
					&& ! request.getParameter("tuike" + j).equals(""))
			{
				flag ++ ;
			}
		}
		xuankeid = new String [flag];
		int m = 0;
		for(int j = 0 ; j < Integer.parseInt(i) ; j ++ )
		{
			if(request.getParameter("tuike" + j) != null
					&& ! request.getParameter("tuike" + j).equals(""))
			{
				xuankeid[m] = request.getParameter("tuike" + j);
				m ++ ;
			}
		}
		XuankeBean xb = new XuankeBean();
		xb.tuikequeren(xuankeid);
		request.setAttribute("chenggong" , "1");
		RequestDispatcher rd = request
				.getRequestDispatcher("jsp/xuanke/tuike.jsp");
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
