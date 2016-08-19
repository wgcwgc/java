
import java.util.Arrays;
import java.util.Random;

public class  ±º‰≤‚ ‘ 
{
	public static void main(String[] args)
	{
		int a[] = new int[100000];
		for(int i = 0; i < a.length;i ++ )
		{
			Random r = new Random();
			a[i] = r.nextInt();
		}
		long start = System.currentTimeMillis();
		Arrays.sort(a);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
