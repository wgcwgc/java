package com.util;

import java.io.UnsupportedEncodingException;

public class Validate
{
	
	/**
	 * �Ƿ�Ϊ���ֺ�Ӣ����֤
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
		}// �ж��ַ��Ƿ���ĳ������
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
	 * �Ƿ�Ϊ������֤
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
		}// �ж��ַ��Ƿ���ĳ������
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
	 * �Ƿ�Ϊ�Ƿ��ַ���֤
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
	 * ����ת��
	 * ��gb2312����ת����unicode����
	 */
	public String getUnicode(String str)
	{
		try
		{
			return new String(str.getBytes("iso8859_1") , "gb2312");
		}
		catch(UnsupportedEncodingException e)
		{
			// TODO �Զ����� catch ��
			e.printStackTrace();
			return str;
		}
	}
	
	/**
	 * ����ת��
	 * ��unicode����ת����gb2312����
	 */
	public String getGb2312(String str)
	{
		try
		{
			return new String(str.getBytes("gb2312") , "iso8859_1");
		}
		catch(UnsupportedEncodingException e)
		{
			// TODO �Զ����� catch ��
			e.printStackTrace();
			return str;
		}
	}
	
	/**
	 * ��������
	 * ����ĳ��ĳ��ĳ�������ڼ�
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
