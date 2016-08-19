
import java.util.Scanner;

public class 字符串转化 
{
	public static void main(String [] args)
	{
		System.out.println("请输入一个整数：");
		Scanner cin = new Scanner(System.in);
		int a = cin.nextInt();
		System.out.println(a);
		System.out.println("请输入一个字符串：");
		String str1 = cin.next();
		System.out.println(str1);
		
		int b = 123;
		String str2 = "123";
		System.out.println(b+str2);
		int c = Integer.parseInt(str2);
		System.out.println(b+c);
		cin.close();
	}
}
