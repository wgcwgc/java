package �ļ�����;

import java.io.*;
import java.util.*;

public class TestFile
{
	public static void main(String [] args)throws Exception
	{
		//File file = new File("TestFile.out");
		File file = new File("TestFile.out");
		PrintWriter cout = new PrintWriter(file);
		System.out.println(" ���ڣ� " + file.exists());
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
