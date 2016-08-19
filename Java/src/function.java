
import java.math.*;
import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unused")
public class function
{

	public static void main(String[] args)
	{
		final int num=870;
		final int meihang=87;
		for(int i=0;i<num;i++)
		{
			//char ch=RandomCharacter.getRandomLowerCaseLetter();
			char ch=(char)('a'+Math.random()*('z'-'a'+1));
			if((i+1)%meihang==0)
				System.out.println(ch);
			else
				System.out.print(ch);
		}
	}
}