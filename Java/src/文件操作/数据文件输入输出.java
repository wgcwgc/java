package �ļ�����;

import java.util.*;
import java.io.*;

public class �����ļ��������
{

	public static void main(String[] args) throws Exception
	{
		
		//��ʾ��ǰʱ��
		Date date = new Date();
		//date.setSeconds(0);//�޸�ʱ�����
		//System.out.println(date.toLocaleString());
		System.out.println(date.toString());
		
		//��ȡ�зָ���
		String lineSeparator = System.getProperty("line.separator");
		System.out.println("*****" + lineSeparator + "*******");
		
		//�����ļ������������
		File file1 = new File("�����ļ�����.in");
		File file2 = new File("�����ļ����.out");
		Scanner cin = new Scanner (file1);//Scanner cin = new Scanner (new File ("cin.txt"));  ��ΪҪ�õ�file1�ļ��������Դ˴����ܼ�д������
		PrintWriter cout = new PrintWriter(file2);//,,, ,,,ͬ��
		while(cin.hasNext())
		{
			
			String F = cin.next();
			String M = cin.next();
			String L = cin.next();
			int score = cin.nextInt();
			
			//���������̨
			cout.println(F + " " + M + " " + L + " " + score);
		}
		
		//�ļ�1�������ļ���������
		System.out.println(" ���ڣ�" + file1.exists());
		System.out.println(" �ֽڳ��ȣ� " + file1.length());
		System.out.println(" �ɶ��� " + file1.canRead());
		System.out.println(" ��д�� " + file1.canWrite());
		System.out.println(" Ŀ¼�� " + file1.isDirectory());
		System.out.println(" �ļ��� " + file1.isFile());
		System.out.println(" ʹ�þ���·����������һ��File���� " + file1.isAbsolute());
		System.out.println(" ���أ� " + file1.isHidden());
		System.out.println(" ����·���� " + file1.getAbsolutePath());
		System.out.println(" ����޸�ʱ�䣺 " + new Date( file1.lastModified() ) + "\n");
		
		//�ļ�2������ļ���������
		System.out.println(" ���ڣ�" + file2.exists());
		System.out.println(" �ֽڳ��ȣ� " + file2.length());
		System.out.println(" �ɶ��� " + file2.canRead());
		System.out.println(" ��д�� " + file2.canWrite());
		System.out.println(" Ŀ¼�� " + file2.isDirectory());
		System.out.println(" �ļ��� " + file2.isFile());
		System.out.println(" ʹ�þ���·����������һ��File���� " + file2.isAbsolute());
		System.out.println(" ���أ� " + file2.isHidden());
		System.out.println(" ����·���� " + file2.getAbsolutePath());
		System.out.println(" ����޸�ʱ�䣺 " + new Date( file2.lastModified() ));
		
		//�ر���������ļ����ͷű��ļ�ռ�õ���Դ
		cin.close();
		cout.close();
	}

}
