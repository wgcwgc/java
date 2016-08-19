package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AllBean;

public class AllServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public AllServlet()
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
		AllBean ab = new AllBean();
		ArrayList kecheng = ab.getKecheng();
		ArrayList laoshi = ab.getLaoshi();
		ArrayList jiaoshi = ab.getjiaoshi();
		ArrayList kechengtime = ab.getKechengtime();
		ArrayList zhuanye = ab.getZhuanye();
		ArrayList banji = ab.getBanji();
		ArrayList xueshengchaxun = ab.getXueshengChaxun();
		ArrayList xuanke = ab.getXuanke();
		request.setAttribute("kecheng" , kecheng);
		request.setAttribute("laoshi" , laoshi);
		request.setAttribute("jiaoshi" , jiaoshi);
		request.setAttribute("kechengtime" , kechengtime);
		request.setAttribute("zhuanye" , zhuanye);
		request.setAttribute("banji" , banji);
		request.setAttribute("xueshengchaxun" , xueshengchaxun);
		request.setAttribute("xuanke" , xuanke);
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
