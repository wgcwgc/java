package �ļ�����;

import java.io.*;
import java.util.Date;

public class WriteData
{

	public static void main(String[] args) throws Exception
	{
		
		//����һ���ļ�
		File file = new File("WriteDate.out");//�ļ�Ĭ�ϱ�����   		E:\Java\eclipse\workspace\Java\wgc.txt
		if(file.exists())
		{
			System.out.println("File already exists!");//��һ�����л�����ļ�wgc.txt  ����ٴ����оͻ�����˾�
			System.exit(0);
		}
		
		PrintWriter cout = new PrintWriter(file);
		
		//������ļ�
		cout.printf("John T Smith\r\n");	//������ļ�ʱ������cout.println(,,,); ������cout.printf(",,,\r\n");	������\r\tռ6���ֽ�
		cout.print(90 + "\r\t");
		cout.println("Eric K Jones");
		cout.println(85);
		
		//���������̨
		System.out.println(" ���ڣ�" + file.exists());
		System.out.println(" �ֽڳ��ȣ� " + file.length());
		System.out.println(" �ɶ��� " + file.canRead());
		System.out.println(" ��д�� " + file.canWrite());
		System.out.println(" Ŀ¼�� " + file.isDirectory());
		System.out.println(" �ļ��� " + file.isFile());
		System.out.println(" ʹ�þ���·����������һ��File���� " + file.isAbsolute());
		System.out.println(" ���أ� " + file.isHidden());
		System.out.println(" ����·���� " + file.getAbsolutePath());
		System.out.println(" ����޸�ʱ�䣺 " + new Date( file.lastModified() ));
		
		
		cout.close();
		
	}

}
