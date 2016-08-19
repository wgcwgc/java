
import java.util.*;

public class 数组引用方法
{

	public static void main(String[] args)
	{
		//Scanner cin = new Scanner(System.in);
		int a[] = {1,2,5,3,7,9,0,4,6,8};
		int b[] = new int[2*a.length];
		System.arraycopy(a,0,b,1,a.length);
		//int c = cin.nextInt();
		//for(int i=0;i<c;i++)
			System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(reverse(a)));
		//cin.close();
	}
	
	public static int [] reverse (int []list)
	{
		//int newlist [] = new int[2*n];
		int []newlist = Arrays.copyOf(list,2*list.length);
		return newlist;
	}
	
}
