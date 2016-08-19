
//import java.util.Arrays;
import java.util.*;

public class 数组扩容复制 
{
	public static void main(String[] args)
	{
		int a[] = {1,2,3,4,5};
		//int b[] = new int[2*a.length];
		//System.arraycopy(a,0,b,3,a.length-1);
		//System.out.println(Arrays.toString(a));
		//System.out.println(Arrays.toString(b));
		int b [] = new int[a.length];
		b = Arrays.copyOf(a,2*a.length);
		System.out.println(Arrays.toString(b));
		
		int []arr = {49,81,1,64,77,50,0,54,77,18};
		String []names = {"oscar","edgar","frank","laure","ken","gino","angus","aaron","hugo","jacob"};
		
		//排序
		//Arrays.sort(arr);
		Arrays.sort(arr,5,7);
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(arr));

		//有序数组，二分查找元素，返回下标
		System.out.println(Arrays.binarySearch(arr, 8));
		
		//数组判定元素相同
		int []arr1 = {1,2,3,4,5,6,7,8,9};
		int []arr2 = {1,2,3,4,5,6,8,9};
		System.out.println(Arrays.equals(arr1,arr2));
		
		//快速初始化数组
		Arrays.fill(arr1,0);
		Arrays.fill(arr2,1,5,7);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		
		//String str = "\u0000";
		String str = "";
		System.out.println(str + "* ***");
		//cin.close();
	}
}