
import java.util.*;

public class fangfa_shuzu
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		int a[] = new int[10];
		int n=cin.nextInt();
		while(cin.hasNext())
		{
			for(int i=0;i<n;i++)
			{
				a[i]=cin.nextInt();
			}
			for(int i=0;i<n;i++)
			{
				System.out.print(a[i]+" ");
			}
		}
		cin.close();
	}
}