package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AptitudePaikeBean;
import com.util.Validate;

public class AptitudePaikeServlet extends HttpServlet
{
	
	/**
	 * Constructor of the object.
	 */
	public AptitudePaikeServlet()
	{
		super();
	}
	
	/**
	 * Destruction of the servlet. <br>
	 */
	/**
	 *	switch (c.get(Calendar.DAY_OF_WEEK)) {
	 *	case 2:
	 *		str = "星期一";
	 *		alRow.add(""+c.get(Calendar.YEAR));
	 *		alRow.add(""+(c.get(Calendar.MONTH)+1));
	 *		alRow.add(""+c.get(Calendar.DATE));
	 *		alRow.add(str);
	 *		alRow.add(""+c.get(Calendar.DAY_OF_WEEK));
	 *		dateweek.add(alRow);
	 *		break;
	 *	case 3:
	 *		str = "星期二";
	 *		alRow.add(""+c.get(Calendar.YEAR));
	 *		alRow.add(""+(c.get(Calendar.MONTH)+1));
	 *		alRow.add(""+c.get(Calendar.DATE));
	 *		alRow.add(str);
	 *		alRow.add(""+c.get(Calendar.DAY_OF_WEEK));
	 *		dateweek.add(alRow);
	 *		break;
	 *	case 4:
	 *		str = "星期三";
	 *		alRow.add(""+c.get(Calendar.YEAR));
	 *		alRow.add(""+(c.get(Calendar.MONTH)+1));
	 *		alRow.add(""+c.get(Calendar.DATE));
	 *		alRow.add(str);
	 *		alRow.add(""+c.get(Calendar.DAY_OF_WEEK));
	 *		dateweek.add(alRow);
	 *		break;
	 *	case 5:
	 *		str = "星期四";
	 *		alRow.add(""+c.get(Calendar.YEAR));
	 *		alRow.add(""+(c.get(Calendar.MONTH)+1));
	 *		alRow.add(""+c.get(Calendar.DATE));
	 *		alRow.add(str);
	 *		alRow.add(""+c.get(Calendar.DAY_OF_WEEK));
	 *		dateweek.add(alRow);
	 *		break;
	 *	case 6:
	 *		str = "星期五";
	 *		alRow.add(""+c.get(Calendar.YEAR));
	 *		alRow.add(""+(c.get(Calendar.MONTH)+1));
	 *		alRow.add(""+c.get(Calendar.DATE));
	 *		alRow.add(str);
	 *		alRow.add(""+c.get(Calendar.DAY_OF_WEEK));
	 *		dateweek.add(alRow);
	 *		break;
	 *	}
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
		String zhuanye = request.getParameter("zhuanye");
		String nianji = null;
		if(request.getParameter("nianji") != null
				&& ! request.getParameter("nianji").equals(""))
		{
			nianji = v.getUnicode(request.getParameter("nianji"));
		}
		AptitudePaikeBean ab = new AptitudePaikeBean();
		ArrayList kecheng = ab.getKecheng(zhuanye , nianji);
		ArrayList banji = ab.getBanji(zhuanye , nianji);
		ArrayList jiaoshi = ab.getJiaoshi();
		ArrayList laoshi = ab.getLaoshi();
		String [] begin = null;
		String [] end = null;
		int [] beginInt = new int [3];
		int [] endInt = new int [3];
		int [][] xy = new int [5] [6];
		
		for(int i = 0 ; i < kecheng.size() ; i ++ )
		{
			boolean bool = true;
			int flag = 0;
			int a = 0;// 总共的教学周
			int b = 0;// 每周的课时数
			ArrayList al = (ArrayList) kecheng.get(i);
			begin = al.get(6).toString().split("-");
			end = al.get(7).toString().split("-");
			for(int j = 0 ; j < begin.length ; j ++ )
			{
				beginInt[j] = Integer.parseInt(begin[j]);
				endInt[j] = Integer.parseInt(end[j]);
			}
			
			Calendar c = Calendar.getInstance();
			c.set(beginInt[0] , beginInt[1] - 1 , beginInt[2]);
			c.add(Calendar.DATE , - 1);
			while(bool)
			{
				c.add(Calendar.DATE , 1);
				flag ++ ;
				if(c.get(Calendar.MONTH) + 1 == endInt[1]
						&& c.get(Calendar.DATE) == endInt[2])
				{
					bool = false;
				}
			}
			
			if(flag % 5 == 0)
			{
				a = flag / 5;
			}
			else
			{
				a = flag / 5 + 1;
			}
			if(Integer.parseInt(al.get(3).toString()) % a == 0)
			{
				b = Integer.parseInt(al.get(3).toString()) / a;
			}
			else
			{
				b = Integer.parseInt(al.get(3).toString()) / a + 1;
			}
			for(int n = 0 ; n < 6 ; n ++ )
			{
				for(int w = 0 ; w < 5 ; w ++ )
				{
					if(xy[w][n] == 0)
					{
						xy[w][n] = Integer.parseInt(al.get(0).toString());
					}
					else
					{
						continue;
					}
					b -- ;
					if(b == 0)
					{
						break;
					}
				}
				if(b == 0)
				{
					break;
				}
			}
		}
		
		ArrayList paike = new ArrayList();
		for(int i = 0 ; i < banji.size() ; i ++ )
		{
			ArrayList all = new ArrayList();
			ArrayList allRow = new ArrayList();
			ArrayList banjiRow = (ArrayList) banji.get(i);
			int flag = 0;
			for(int x = 0 ; x < 5 ; x ++ )
			{
				for(int y = 0 ; y < 6 ; y ++ )
				{
					if(xy[x][y + 1] != 0)
					{
						flag = xy[x][y];
						xy[x][y] = xy[x][y + 1];
						xy[x][y + 1] = flag;
					}
					else
					{
						break;
					}
				}
			}
			for(int x = 0 ; x < 5 ; x ++ )
			{
				ArrayList allCol = new ArrayList();
				for(int y = 0 ; y < 6 ; y ++ )
				{
					allCol.add("" + xy[x][y]);
				}
				allRow.add(allCol);
			}
			all.add(allRow);
			all.add(banjiRow);
			paike.add(all);
		}
		
		request.setAttribute("zhuanyeid" , zhuanye);
		request.setAttribute("nianji" , nianji);
		request.setAttribute("paike" , paike);
		request.setAttribute("kecheng" , kecheng);
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
