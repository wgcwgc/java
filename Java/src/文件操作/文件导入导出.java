package �ļ�����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class �ļ����뵼�� 
{
	public static void main(String[] args)throws Exception
	{
		FileReader fr = new FileReader("�ļ�����.in");
		FileWriter fw = new FileWriter("�ļ�����.out");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		String str1;
		while( (str1 = br.readLine() ) != null )
		{
			bw.write(str1);
			bw.write("\n");
			
			String str = br.readLine();
			bw.write(str);
			bw.write("\n");
			
			System.out.println(str1 + "\n" + str);
		}
		br.close();
		bw.close();
		fr.close();
		fw.close();
	}
}
