package lamp.FILE.BufferedStream;

import java.io.*;

public class BufferedInputStreamDemo
{

	public static void output()
	{
		try
		{
			OutputStream cout = new FileOutputStream("BufferedInputStreamDemo.out");
			//�����ֽ����������һ���ֽڻ�����
			BufferedOutputStream bos = new BufferedOutputStream(cout);
			
			String info = "woshiyizhixiaoxiaoniao,yiyayiyayou";
			bos.write(info.getBytes());
			bos.flush();//ˢ�»�����
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
		
		
		//ʹ���ֽڻ��������ж�ȡ����
		try
		{
			InputStream cin = new FileInputStream("BufferedInputStreamDemo.out");
			//�����ֽ�����������һ���ֽڻ�����
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
