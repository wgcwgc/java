
//import java.util.Arrays;
import java.util.*;

public class �������ݸ��� 
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
		
		//����
		//Arrays.sort(arr);
		Arrays.sort(arr,5,7);
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(arr));

		//�������飬���ֲ���Ԫ�أ������±�
		System.out.println(Arrays.binarySearch(arr, 8));
		
		//�����ж�Ԫ����ͬ
		int []arr1 = {1,2,3,4,5,6,7,8,9};
		int []arr2 = {1,2,3,4,5,6,8,9};
		System.out.println(Arrays.equals(arr1,arr2));
		
		//���ٳ�ʼ������
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