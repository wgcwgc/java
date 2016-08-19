package ÎÄ¼þ²Ù×÷;

import java.util.Scanner;
import java.io.*;

public class ReadData
{
	public static void main(String [] args) throws Exception
	{
		
		//File file = new File("ReadData.in");
		//Scanner cin = new Scanner (file);
		Scanner cin = new Scanner (new File ("ReadData.in"));
		while(cin.hasNext())
		{
			String F = cin.next();
			String M = cin.next();
			String L = cin.next();
			int score = cin.nextInt();
			System.out.println(F + " " + M + " " + L + " " + score+ "\n");
		}
		
		cin.close();
	}

}
