package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.XuankeBean;

public class TijiaoXuankeServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public TijiaoXuankeServlet()
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
		String [] kechengid = null;
		String xueshengid = request.getParameter("xueshengid");
		int flag = 0;
		for(int j = 0 ; j < Integer.parseInt(i) ; j ++ )
		{
			if(request.getParameter("xuanke" + j) != null
					&& ! request.getParameter("xuanke" + j).equals(""))
			{
				flag ++ ;
			}
		}
		kechengid = new String [flag];
		int m = 0;
		for(int j = 0 ; j < Integer.parseInt(i) ; j ++ )
		{
			if(request.getParameter("xuanke" + j) != null
					&& ! request.getParameter("xuanke" + j).equals(""))
			{
				kechengid[m] = request.getParameter("xuanke" + j);
				m ++ ;
			}
		}
		XuankeBean xb = new XuankeBean();
		xb.xuanke(kechengid , xueshengid);
		request.setAttribute("chenggong" , "1");
		RequestDispatcher rd = request
				.getRequestDispatcher("jsp/xuanke/xuanke.jsp");
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
