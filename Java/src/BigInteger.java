import java.util.*;

public class  BigInteger
{
    public static void main(String[] args)
    {
       Scanner cin = new Scanner(System.in);
       int T=cin.nextInt();
       for(int i = 1;i <= T;i ++)
       {
    	   java.math.BigInteger a=cin.nextBigInteger();
    	   java.math.BigInteger b=cin.nextBigInteger();
    	   java.math.BigInteger c=a.add(b);
    	   System.out.println("Case " + i + ":");
    	   System.out.println(a + " + " + b + " = " + c);
           if(i != T)
        	   System.out.println("");
       }
       cin.close();
    }
}
