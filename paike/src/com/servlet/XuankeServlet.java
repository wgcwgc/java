package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.XuankeBean;

public class XuankeServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public XuankeServlet()
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
		HttpSession session = request.getSession();
		ArrayList login = (ArrayList) session.getAttribute("login");
		String xueshengid = (String) login.get(0);
		XuankeBean xb = new XuankeBean();
		ArrayList xuesheng = xb.getXuesheng(xueshengid);
		ArrayList allkecheng = xb.getAllKecheng(xueshengid);
		ArrayList xuankecheng = xb.getXuanKecheng(xueshengid);
		ArrayList tuike = xb.tuike(xueshengid);
		int xuefen = xb.getXuefen(xueshengid);
		int feiyong = xb.getFeiyong(xueshengid);
		if(xuefen >= 5)
		{
			request.setAttribute("xuefen" , "1");
		}
		if(feiyong >= 2)
		{
			request.setAttribute("feiyong" , "1");
		}
		request.setAttribute("xuesheng" , xuesheng);
		request.setAttribute("allkecheng" , allkecheng);
		request.setAttribute("xuankecheng" , xuankecheng);
		request.setAttribute("tuike" , tuike);
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
