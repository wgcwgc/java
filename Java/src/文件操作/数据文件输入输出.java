package 文件操作;

import java.util.*;
import java.io.*;

public class 数据文件输入输出
{

	public static void main(String[] args) throws Exception
	{
		
		//显示当前时间
		Date date = new Date();
		//date.setSeconds(0);//修改时间的秒
		//System.out.println(date.toLocaleString());
		System.out.println(date.toString());
		
		//获取行分隔符
		String lineSeparator = System.getProperty("line.separator");
		System.out.println("*****" + lineSeparator + "*******");
		
		//创建文件输入输出对象
		File file1 = new File("数据文件输入.in");
		File file2 = new File("数据文件输出.out");
		Scanner cin = new Scanner (file1);//Scanner cin = new Scanner (new File ("cin.txt"));  因为要用到file1文件对象，所以此处不能简写，，，
		PrintWriter cout = new PrintWriter(file2);//,,, ,,,同上
		while(cin.hasNext())
		{
			
			String F = cin.next();
			String M = cin.next();
			String L = cin.next();
			int score = cin.nextInt();
			
			//输出到控制台
			cout.println(F + " " + M + " " + L + " " + score);
		}
		
		//文件1：输入文件数据属性
		System.out.println(" 存在？" + file1.exists());
		System.out.println(" 字节长度？ " + file1.length());
		System.out.println(" 可读？ " + file1.canRead());
		System.out.println(" 可写？ " + file1.canWrite());
		System.out.println(" 目录？ " + file1.isDirectory());
		System.out.println(" 文件？ " + file1.isFile());
		System.out.println(" 使用绝对路径名创建了一个File对象？ " + file1.isAbsolute());
		System.out.println(" 隐藏？ " + file1.isHidden());
		System.out.println(" 绝对路径： " + file1.getAbsolutePath());
		System.out.println(" 最后修改时间： " + new Date( file1.lastModified() ) + "\n");
		
		//文件2：输出文件数据属性
		System.out.println(" 存在？" + file2.exists());
		System.out.println(" 字节长度？ " + file2.length());
		System.out.println(" 可读？ " + file2.canRead());
		System.out.println(" 可写？ " + file2.canWrite());
		System.out.println(" 目录？ " + file2.isDirectory());
		System.out.println(" 文件？ " + file2.isFile());
		System.out.println(" 使用绝对路径名创建了一个File对象？ " + file2.isAbsolute());
		System.out.println(" 隐藏？ " + file2.isHidden());
		System.out.println(" 绝对路径： " + file2.getAbsolutePath());
		System.out.println(" 最后修改时间： " + new Date( file2.lastModified() ));
		
		//关闭输入输出文件，释放被文件占用的资源
		cin.close();
		cout.close();
	}

}
