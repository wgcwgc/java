package lamp.FILE.BufferedStream;

import java.io.*;

public class BufferedInputStreamDemo
{

	public static void output()
	{
		try
		{
			OutputStream cout = new FileOutputStream("BufferedInputStreamDemo.out");
			//根据字节输出流构造一个字节缓冲流
			BufferedOutputStream bos = new BufferedOutputStream(cout);
			
			String info = "woshiyizhixiaoxiaoniao,yiyayiyayou";
			bos.write(info.getBytes());
			bos.flush();//刷新缓冲区
			bos.close();
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void input()
	{
		
		
		//使用字节缓冲流进行读取操作
		try
		{
			InputStream cin = new FileInputStream("BufferedInputStreamDemo.out");
			//根据字节输入流构造一个字节缓冲流
			BufferedInputStream bis = new BufferedInputStream(cin);
			Reader r = new InputStreamReader(bis);
			char [] cs = new char[512];
			int len = -1;
			StringBuilder sb = new StringBuilder();
			while((len = r.read(cs)) != -1)
			{
				sb.append(new String(cs,0 ,len));
			}
			r.close();
			bis.close();
			cin.close();
			
			System.out.println(sb);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	public static void main(String[] args) 
	{
		input();
		output();
		
	}

}
