package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.KechengbiaoBean;

public class SaveKechengbiaoServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public SaveKechengbiaoServlet()
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
		ArrayList save = (ArrayList) session.getAttribute("save");
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String c = request.getParameter("c");
		String [] laoshiid = new String [save.size()];
		String [] jiaoshiid = new String [save.size()];
		int flag1 = 0;
		int flag2 = 0;
		for(int i = 0 ; i < Integer.parseInt(a) ; i ++ )
		{
			for(int j = 0 ; j < Integer.parseInt(b) ; j ++ )
			{
				for(int m = 0 ; m < Integer.parseInt(c) ; m ++ )
				{
					if(request.getParameter("laoshi" + i + "" + j + "" + m) != null
							&& ! request.getParameter(
									"laoshi" + i + "" + j + "" + m).equals(""))
					{
						laoshiid[flag1] = request.getParameter("laoshi" + i
								+ "" + j + "" + m);
						flag1 ++ ;
					}
					if(request.getParameter("jiaoshi" + i + "" + j + "" + m) != null
							&& ! request.getParameter(
									"jiaoshi" + i + "" + j + "" + m).equals(""))
					{
						jiaoshiid[flag2] = request.getParameter("jiaoshi" + i
								+ "" + j + "" + m);
						flag2 ++ ;
					}
				}
			}
		}
		KechengbiaoBean kb = new KechengbiaoBean();
		int flag = kb.saveKebiao(save , laoshiid , jiaoshiid);
		if(flag == 1)
		{
			request.setAttribute("chenggong" , "1");
		}
		if(flag == 2)
		{
			request.setAttribute("chongfu" , "1");
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("jsp/paike/aptitudepaike.jsp");
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
