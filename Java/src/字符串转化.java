
import java.util.Scanner;

public class �ַ���ת�� 
{
	public static void main(String [] args)
	{
		System.out.println("������һ��������");
		Scanner cin = new Scanner(System.in);
		int a = cin.nextInt();
		System.out.println(a);
		System.out.println("������һ���ַ�����");
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
