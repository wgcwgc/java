package �ļ�����;
import java.util.*;
public class StringDemo
{
	public static void main(String[] args) throws Exception
	{
		//String s = "woaininiaiwoma";
		String s = "�Ұ����㰮����";
		//System.out.println(s.charAt(4));
		char a [] = s.toCharArray();
		for(int i = 0;i <a.length;i ++)
			System.out.print(a[i]);
		System.out.println();
		byte bytes[] = s.getBytes();
		for(int i = 0;i < bytes.length;i ++)
			System.out.print(bytes[i] + " ");
		System.out.println();
		//���ֽ�����ת����
		String s1 = new String(bytes);
		System.out.println(s1);
		
		String s2 = new String(bytes,0,6);
		System.out.println(s2);
		
		String s3 = new String(bytes,"GBK");
		System.out.println(s3);
		
		Date date = new Date();
		//date.setHours(1);
		System.out.println(date.toString());
		//System.out.println(date.toLocaleString());
		//date.setHours(-2);
		//System.out.println(date.toGMTString());
	}
}
