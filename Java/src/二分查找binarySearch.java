
import java.util.*;

public class ¶þ·Ö²éÕÒbinarySearch
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext())
		{
			int key = cin.nextInt();
			int a[] = {1,2,3,4,5,6,7,8,9,10};
			int high = a.length - 1,low = 0;
			boolean first = false;
			while(high>=low)
			{
				int mid = (low + high)/2;
				if(key == a[mid])
				{
					System.out.println(mid+1);
					first = true;
					break;
				}
				else if(key <= mid)
					high = mid - 1;
				else
					low = mid + 1;
			}
			if(first == false)
				System.out.println("-1");
		}
		cin.close();
	}
}