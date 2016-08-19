package lamp.FILE.PrintStream;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintDemo
{
	
	//ʹ���ַ���ӡ��PrintWriter
	public static void print2()
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("PrintDemo.out"));
			PrintWriter pw = new PrintWriter(bw);
			pw.print("\r\n");//����س����з�
			pw.println(100);
			pw.println("xiaomijieryingxiao");
			
			pw.flush();
			pw.close();
			bw.close();
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	//ʹ���ֽڴ�ӡ��
	public static void print()
	{
		try
		{
			OutputStream cout = new FileOutputStream("PrintDemo.out");
			BufferedOutputStream bos = new BufferedOutputStream(cout);
			//�����ֽڴ�ӡ������
			PrintStream ps = new PrintStream(bos);
			ps.println(3.14f);
			ps.println(188);
			ps.println(true);
			ps.println("keyishizifuchuan");
			
			ps.flush();
			//�ر���
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
//		print();
		print2();
	}

}
