
import java.util.*;
public class random {

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		System.out.printf("����һ��ʮ������λ������������������Math��random����*100������һ���������Yes�������No\n");
		Scanner cin = new Scanner (System.in);
		int n = cin.nextInt();
		int m = (int)(Math.random()*100);
		System.out.printf("%d\n",m);
		if(m == n)
			System.out.printf("Yes\n");
		else
			System.out.printf("No\n");
		Random r = new Random();
		System.out.println(r.nextInt(100));
		String str = " Welcome To Java";
		boolean a = str.contains("w");
		System.out.println(a);
		
	}
}