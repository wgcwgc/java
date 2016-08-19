
import java.util.*;

public class 数组去重调用方法
{
	
	public static int [] eliminateDuplicates(int []numbers)
	{
		final int INF = 11;
		int a[] = new int[INF];
		int k = 0,j,i;
		a[k ++] = numbers[0];
		for(i = 1;i < numbers.length;i ++)
		{
			for(j = 0;j < i;j ++)
			{
				if(numbers[j] == numbers[i])
					break;
			}
			if(i == j)
				a[k ++] = numbers[i];
		}
		return a;
	}
	
	public static void main(String[] args)
	{
		final int INF = 11;
		Scanner cin = new Scanner(System.in);
		int a[] = new int[INF];
		int b[] = new int[INF];
		for(int i = 0;i < 10;i ++)
			a[i] = cin.nextInt();
		b = eliminateDuplicates(a);
		for(int i = 0;b[i] != 0 && i < b.length;i ++)
			System.out.print(b[i] + " ");
		System.out.println();
		cin.close();
	}
	
}
