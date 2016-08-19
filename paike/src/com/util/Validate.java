package com.util;

import java.io.UnsupportedEncodingException;

public class Validate
{
	
	/**
	 * 是否为数字和英文验证
	 *
	 */
	public int getIntAndChar(String str)
	{
		char c;
		int i;
		for(i = 0 ; i < str.length() ; i ++ )
		{
			c = str.charAt(i);
			if( ! ( ( c >= '0' && c <= '9' ) || ( c >= 'a' && c <= 'z' ) || ( c >= 'A' && c <= 'Z' ) ))
			{
				break;
			}
		}// 判断字符是否在某个区间
		if(i < str.length())
		{
			return - 1;
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * 是否为整数验证
	 *
	 */
	public int getInt(String str)
	{
		char c;
		int i;
		for(i = 0 ; i < str.length() ; i ++ )
		{
			c = str.charAt(i);
			if( ! ( c >= '0' && c <= '9' ))
			{
				break;
			}
		}// 判断字符是否在某个区间
		if(i < str.length())
		{
			return - 1;
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * 是否为非法字符验证
	 *
	 */
	public boolean getLawlessChar(String str)
	{
		boolean flag = false;
		char c;
		for(int i = 0 ; i < str.length() ; i ++ )
		{
			c = str.charAt(i);
			switch(c)
			{
				case '<' :
					flag = true;
					break;
				case '>' :
					flag = true;
					break;
				case '"' :
					flag = true;
					break;
				case '&' :
					flag = true;
					break;
				case ' ' :
					flag = true;
					break;
			}
		}
		return flag;
	}
	
	/**
	 * 中文转换
	 * 将gb2312编码转换成unicode编码
	 */
	public String getUnicode(String str)
	{
		try
		{
			return new String(str.getBytes("iso8859_1") , "gb2312");
		}
		catch(UnsupportedEncodingException e)
		{
			// TODO 自动生成 catch 块
			e.printStackTrace();
			return str;
		}
	}
	
	/**
	 * 中文转换
	 * 将unicode编码转换成gb2312编码
	 */
	public String getGb2312(String str)
	{
		try
		{
			return new String(str.getBytes("gb2312") , "iso8859_1");
		}
		catch(UnsupportedEncodingException e)
		{
			// TODO 自动生成 catch 块
			e.printStackTrace();
			return str;
		}
	}
	
	/**
	 * 计算星期
	 * 计算某年某月某日是星期几
	 */
	public int getWeek(int year , int month , int day)
	{
		int sum = 0;
		int j = 0;
		boolean b = false;
		for(int i = 0 ; i < year ; i ++ )
		{
			if( ( i % 4 == 0 && i % 100 != 0 ) || ( i % 400 == 0 && i != 0 ))
			{
				j ++ ;
			}
		}
		
		if( ( year % 4 == 0 && year % 100 != 0 )
				|| ( year % 400 == 0 && year != 0 ))
		{
			b = true;
		}
		
		sum = 365 * year + j;
		
		switch(month)
		{
			case 1 :
				sum = sum + day;
				break;
			case 2 :
				sum = sum + 31 + day;
				break;
			case 3 :
				sum = sum + 28 + 31 + day;
				break;
			case 4 :
				sum = sum + 31 + 28 + 31 + day;
				break;
			case 5 :
				sum = sum + 30 + 31 + 28 + 31 + day;
				break;
			case 6 :
				sum = sum + 31 + 30 + 31 + 28 + 31 + day;
				break;
			case 7 :
				sum = sum + 30 + 31 + 30 + 31 + 28 + 31 + day;
				break;
			case 8 :
				sum = sum + 31 + 30 + 31 + 30 + 31 + 28 + 31 + day;
				break;
			case 9 :
				sum = sum + 31 + 31 + 30 + 31 + 30 + 31 + 28 + 31 + day;
				break;
			case 10 :
				sum = sum + 30 + 31 + 31 + 30 + 31 + 30 + 31 + 28 + 31 + day;
				break;
			case 11 :
				sum = sum + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31 + 28 + 31
						+ day;
				break;
			case 12 :
				sum = sum + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31 + 28
						+ 31 + day;
				break;
		}
		
		if(b == true && month > 2)
		{
			sum = sum + 1;
		}
		return ( sum - 1 ) % 7;
	}
	
}
