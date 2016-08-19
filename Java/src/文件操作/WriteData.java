package 文件操作;

import java.io.*;
import java.util.Date;

public class WriteData
{

	public static void main(String[] args) throws Exception
	{
		
		//创建一个文件
		File file = new File("WriteDate.out");//文件默认保存在   		E:\Java\eclipse\workspace\Java\wgc.txt
		if(file.exists())
		{
			System.out.println("File already exists!");//第一次运行会产生文件wgc.txt  如果再次运行就会输出此句
			System.exit(0);
		}
		
		PrintWriter cout = new PrintWriter(file);
		
		//输出到文件
		cout.printf("John T Smith\r\n");	//输出到文件时换行用cout.println(,,,); 或者用cout.printf(",,,\r\n");	缩进用\r\t占6个字节
		cout.print(90 + "\r\t");
		cout.println("Eric K Jones");
		cout.println(85);
		
		//输出到控制台
		System.out.println(" 存在？" + file.exists());
		System.out.println(" 字节长度？ " + file.length());
		System.out.println(" 可读？ " + file.canRead());
		System.out.println(" 可写？ " + file.canWrite());
		System.out.println(" 目录？ " + file.isDirectory());
		System.out.println(" 文件？ " + file.isFile());
		System.out.println(" 使用绝对路径名创建了一个File对象？ " + file.isAbsolute());
		System.out.println(" 隐藏？ " + file.isHidden());
		System.out.println(" 绝对路径： " + file.getAbsolutePath());
		System.out.println(" 最后修改时间： " + new Date( file.lastModified() ));
		
		
		cout.close();
		
	}

}
