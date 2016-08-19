package wgc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo
{

	public static void main(String[] args)
	{
		//是一个以与语言环境有关的方式来格式化和解析日期的具体类
		SimpleDateFormat sdf1 = new SimpleDateFormat();
		//可以选择任何用户定义的日期-时间格式的模式
		SimpleDateFormat sdf2 = new SimpleDateFormat("Gyyyy年MM月dd日  a HH:mm:ss SS毫秒  E  zZ");

		String s1 = sdf1.format(new Date());
		String s2 = sdf2.format(new Date());
		
		System.out.println(s1 + "\n" + s2);
	}

}
