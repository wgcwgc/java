
import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;

@SuppressWarnings("unused")
public class array {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner cin = new Scanner(System.in);
		double a[]=new double[577];
		int n=cin.nextInt();
		for(int i=1;i<=n;i++)
			a[i]=Math.random()*100;
		for(int i=1;i<=n;i++)
			System.out.println("a["+i+"]="+a[i]);
		System.out.printf("%d",a.length);
	}
	
	public static int max(int a,int b)
	{
		return a>b?a:b;
	}
}
