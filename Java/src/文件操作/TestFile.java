package 文件操作;

import java.io.*;
import java.util.*;

public class TestFile
{
	public static void main(String [] args)throws Exception
	{
		//File file = new File("TestFile.out");
		File file = new File("TestFile.out");
		PrintWriter cout = new PrintWriter(file);
		System.out.println(" 存在？ " + file.exists());
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
