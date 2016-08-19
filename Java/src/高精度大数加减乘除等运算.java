
import java.util.Scanner;

public class 高精度大数加减乘除等运算 {
	public static void main(String[] args)
		    {
		       Scanner cin = new Scanner(System.in);
		       int T=cin.nextInt();
		       for(int ii = 1;ii <= T;ii ++)
		       {
		    	   /*java.math.BigInteger a=cin.nextBigInteger();
		    	   java.math.BigInteger b=cin.nextBigInteger();
		    	   java.math.BigInteger c=a.add(b);
		    	   java.math.BigInteger d=a.subtract(b);
		    	   java.math.BigInteger e=a.multiply(b);
		    	   java.math.BigInteger f=a.divide(b);
		    	   java.math.BigInteger g=a.mod(b);
		    	   java.math.BigInteger h=a.min(b);
		    	   java.math.BigInteger i=a.abs();
		    	   java.math.BigInteger j=a.gcd(b);
		    	   System.out.println(c);
		    	   System.out.println(d);
		    	   System.out.println(e);
		    	   System.out.println(f);
		    	   System.out.println(g);
		    	   System.out.println(h);
		    	   System.out.println(i);
		    	   System.out.println(j);*/
		    	   
		    	   java.math.BigDecimal a=cin.nextBigDecimal();
		    	   java.math.BigDecimal b=cin.nextBigDecimal();
		    	   java.math.BigDecimal c=a.add(b);
		    	   java.math.BigDecimal d=a.subtract(b);
		    	   java.math.BigDecimal e=a.multiply(b);
		    	   //ava.math.BigDecimal f=a.divide(b);
		    	   java.math.BigDecimal g=a.movePointLeft(1);
		    	   java.math.BigDecimal h=a.min(b);
		    	   java.math.BigDecimal i=a.abs();
		    	   java.math.BigInteger j=a.toBigInteger();
		    	   int k=a.compareTo(b);
		    	   java.math.BigDecimal l=a.plus();
		    	   System.out.println(c);
		    	   
		    	   System.out.println(d);
		    	   System.out.println(e);
//		    	   System.out.println(f);
		    	   System.out.println(g);
		    	   System.out.println(h);
		    	   System.out.println(i);
		    	   System.out.println(j);
		    	   System.out.println(k);
		    	   System.out.println(l);
		    	   System.out.println("Case " + i + ":");
		    	   System.out.println(a + " + " + b + " = " + c);
//		           if(i != T)
//		        	   System.out.println("");
		       }
		       cin.close();
		    }
	}
