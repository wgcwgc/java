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
			//�����ֽ�����������һ������������
			DataInputStream dis = new DataInputStream(cin);
			int flag = dis.readInt();//��ȡһ������
			String info = dis.readUTF();//��ȡһ��UTF������ַ���
			
			//�ر���
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
			//�����ֽ����������һ�����������
			DataOutputStream dos = new DataOutputStream(cout);
			dos.writeInt(1);//���һ������
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
