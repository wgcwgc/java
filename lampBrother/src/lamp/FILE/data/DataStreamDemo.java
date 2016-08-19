package lamp.FILE.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataStreamDemo
{

	public static void reader()
	{
		try
		{
			InputStream cin = new FileInputStream("DataStreamDemo.out");
			//根据字节输入流构造一个数据输入流
			DataInputStream dis = new DataInputStream(cin);
			int flag = dis.readInt();//读取一个整数
			String info = dis.readUTF();//读取一个UTF编码的字符串
			
			//关闭流
			cin.close();
			dis.close();
			
			System.out.println("flag = " + flag);
			System.out.println("info = "+ info);
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
	
	
	public static void write()
	{
		try
		{
			OutputStream cout = new FileOutputStream("DataStreamDemo.out");
			//根据字节输出流构造一个数据输出流
			DataOutputStream dos = new DataOutputStream(cout);
			dos.writeInt(1);//输出一个整数
			dos.writeUTF("chuangqianmingyueguang,dishangxieliangshuang,cichushenglueshigezi");
			dos.close();
			cout.close();
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
		write();
		reader();
	}

}
