package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.XinxiluruBean;
import com.util.Validate;

public class XinxiluruServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public XinxiluruServlet()
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
		String banjiluru = request.getParameter("banjiluru");
		String xueshengluru = request.getParameter("xueshengluru");
		String qingkuangluru = request.getParameter("qingkuangluru");
		String zhuanyeluru = request.getParameter("zhuanyeluru");
		
		String banjiming = "";
		if(request.getParameter("banjiming") != null
				&& ! request.getParameter("banjiming").equals(""))
		{
			banjiming = v.getUnicode(request.getParameter("banjiming"));
		}
		String nianji = "";
		if(request.getParameter("nianji") != null
				&& ! request.getParameter("nianji").equals(""))
		{
			nianji = v.getUnicode(request.getParameter("nianji"));
		}
		String renshu = request.getParameter("renshu");
		String zhuanye = request.getParameter("zhuanye");
		
		String xuehao = request.getParameter("xuehao");
		String xingming = "";
		if(request.getParameter("xingming") != null
				&& ! request.getParameter("xingming").equals(""))
		{
			xingming = v.getUnicode(request.getParameter("xingming"));
		}
		String banji = request.getParameter("banji");
		
		String xueshengid = request.getParameter("xueshengid");
		String kecheng = request.getParameter("kecheng");
		String xuefen = request.getParameter("xuefen");
		String feiyong = request.getParameter("feiyong");
		
		String zhuanyeming = "";
		if(request.getParameter("zhuanyeming") != null
				&& ! request.getParameter("zhuanyeming").equals(""))
		{
			zhuanyeming = v.getUnicode(request.getParameter("zhuanyeming"));
		}
		
		XinxiluruBean xb = new XinxiluruBean();
		if(banjiluru != null && banjiluru.equals("1"))
		{
			xb.banjiluru(banjiming , nianji , renshu , zhuanye);
		}
		if(xueshengluru != null && xueshengluru.equals("1"))
		{
			xb.xueshengluru(xuehao , xingming , banji);
		}
		if(qingkuangluru != null && qingkuangluru.equals("1"))
		{
			xb.qingkuangluru(xueshengid , kecheng , xuefen , feiyong);
		}
		if(zhuanyeluru != null && zhuanyeluru.equals("1"))
		{
			xb.zhuanyeluru(zhuanyeming);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("jsp/xinxiluru/xinxiluru.jsp");
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
