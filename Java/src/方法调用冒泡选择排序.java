
import java.util.*;

public class ��������ð��ѡ������ 
{
	
	public static int [] sort1(int [] a)
	{
		for(int i = 0;i < a.length;i ++)
		{
			for(int j = i;j < a.length;j ++)
				if(a[i] > a[j])
				{
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
		}
		return a;
	}
	
	public static int [] sort2(int [] a)
	{
		for(int i = 0;i < a.length - 1;i ++)
		{
			int j,min = i;
			for(j = i + 1;j < a.length;j ++)
				if(a[min] > a[j])
					min = j;
			if(min != i)
			{
				int t = a[i];
				a[i] = a[min];
				a[min] = t;
			}
		}
		return a;
	}
	
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		System.out.printf("\n\n\tWELCOME TO WGCWGC'S\n\t\t\t\t QUICK_SORT WORLD !!!\n\n������һ��������(���������ĸ���)��\n\t");
		int n = cin.nextInt();
		int a[] = new int [n];
		System.out.printf("������%d�������������(��������)��\n\t",n);
		for(int i = 0;i < n;i ++)
			a[i] = cin.nextInt();
		System.out.printf("��ѡ������ʽ��\n\t1��ð������\n\t2��ѡ������\n��ѡ��(1 or 2)��\n\t\t");
		int choice = cin.nextInt();
		System.out.printf("���Ϊ��\n\t");
		int b[] = new int [n];
		if(choice == 1)
		{
			b = sort1(a);
			for(int i = 0;i < b.length;i ++)
				System.out.print(b[i] + " ");
		}
		else
		{
			b = sort2(a);
			for(int i = 0;i < b.length;i ++)
				System.out.print(b[i] + " ");
		}
		System.out.println();
		cin.close();
	}
	
}
