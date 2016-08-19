package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LuruBean;
import com.util.Validate;

public class LuruServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public LuruServlet()
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
		String name = null;
		if(request.getParameter("name") != null
				&& ! request.getParameter("name").equals(""))
		{
			name = v.getUnicode(request.getParameter("name"));
		}
		String kecheng = request.getParameter("kecheng");
		String jiaoxuezhou = request.getParameter("jiaoxuezhou");
		String keshi = request.getParameter("keshi");
		String zhuanye = request.getParameter("zhuanye");
		String nianji = null;
		if(request.getParameter("nianji") != null
				&& ! request.getParameter("nianji").equals(""))
		{
			nianji = v.getUnicode(request.getParameter("nianji"));
		}
		String gong = request.getParameter("gong");
		String renshu = request.getParameter("renshu");
		String laoshi = request.getParameter("laoshi");
		String kechengluru = request.getParameter("kechengluru");
		String jiaoshi = request.getParameter("jiaoshi");
		String str = "";
		LuruBean lb = new LuruBean();
		if(laoshi != null && laoshi.equals("1"))
		{
			str = "jsp/paike/laoshiluru.jsp";
			lb.laoshi(name , kecheng);
			request.setAttribute("laoshiluru" , "1");
		}
		if(kechengluru != null && kechengluru.equals("1"))
		{
			str = "jsp/paike/kechengluru.jsp";
			lb.kecheng(name , jiaoxuezhou , keshi , zhuanye , gong , nianji);
			request.setAttribute("kechengluru" , "1");
		}
		
		if(jiaoshi != null && jiaoshi.equals("1"))
		{
			str = "jsp/paike/jiaoshiluru.jsp";
			lb.jiaoshi(name , renshu);
			request.setAttribute("jiaoshiluru" , "1");
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
