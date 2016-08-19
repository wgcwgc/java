package com.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.KechenganpaiBean;

public class KechenganpaiServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public KechenganpaiServlet()
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
		String kechenganpaiUpdate = request.getParameter("kechenganpaiUpdate");
		String id = request.getParameter("id");
		String i = request.getParameter("i");
		String beginyue = request.getParameter("beginyue" + i);
		String beginri = request.getParameter("beginri" + i);
		String endyue = request.getParameter("endyue" + i);
		String endri = request.getParameter("endri" + i);
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		String begintime = year + "-" + beginyue + "-" + beginri;
		String endtime = year + "-" + endyue + "-" + endri;
		boolean b = false;
		
		if( ( year % 4 == 0 && year % 100 != 0 )
				|| ( year % 400 == 0 && year != 0 ))
		{
			b = true;
		}
		if(b == true && beginyue.equals("2") && Integer.parseInt(beginri) > 29)
		{
			request.setAttribute("beginError" , "1");
		}
		else if(beginyue.equals("2") && Integer.parseInt(beginri) > 28)
		{
			request.setAttribute("beginError" , "1");
		}
		else if( ( beginyue.equals("4") || beginyue.equals("6")
				|| beginyue.equals("9") || beginyue.equals("11") )
				&& Integer.parseInt(beginri) > 30)
		{
			request.setAttribute("beginError" , "1");
		}
		else if(b == true && endyue.equals("2") && Integer.parseInt(endri) > 29)
		{
			request.setAttribute("endError" , "1");
		}
		else if(endyue.equals("2") && Integer.parseInt(endri) > 28)
		{
			request.setAttribute("endError" , "1");
		}
		else if( ( endyue.equals("4") || endyue.equals("6")
				|| endyue.equals("9") || endyue.equals("11") )
				&& Integer.parseInt(endri) > 30)
		{
			request.setAttribute("endError" , "1");
		}
		else
		{
			KechenganpaiBean kb = new KechenganpaiBean();
			if(kechenganpaiUpdate != null && kechenganpaiUpdate.equals("1"))
			{
				kb.update(id , begintime , endtime);
			}
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("jsp/paike/kechenganpai.jsp");
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
