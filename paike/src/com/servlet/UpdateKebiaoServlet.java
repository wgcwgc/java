package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.KechengbiaoBean;

public class UpdateKebiaoServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public UpdateKebiaoServlet()
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
		String id = request.getParameter("id");
		String i = request.getParameter("i");
		String nianjiid = request.getParameter("nianjiid");
		String zhuanyeid = request.getParameter("zhuanyeid");
		String laoshi = request.getParameter("laoshi" + i);
		String jiaoshi = request.getParameter("jiaoshi" + i);
		String nianji = "";
		
		if(nianjiid.equals("1"))
		{
			nianji = "一年";
		}
		if(nianjiid.equals("2"))
		{
			nianji = "二年";
		}
		if(nianjiid.equals("3"))
		{
			nianji = "三年";
		}
		if(nianjiid.equals("4"))
		{
			nianji = "四年";
		}
		KechengbiaoBean kb = new KechengbiaoBean();
		String sql = "update kebiao set laoshiid='" + laoshi + "',jiaoshiid='"
				+ jiaoshi + "' where kebiaoid='" + id + "'";
		kb.updateKebiao(sql);
		request.setAttribute("zhuanyeid" , zhuanyeid);
		request.setAttribute("nianji" , nianji);
		request.setAttribute("chenggong" , "1");
		RequestDispatcher rd = request
				.getRequestDispatcher("PaikejieguoServlet");
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
