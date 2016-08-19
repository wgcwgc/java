package 文件操作;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class 文件导入导出 
{
	public static void main(String[] args)throws Exception
	{
		FileReader fr = new FileReader("文件导入.in");
		FileWriter fw = new FileWriter("文件导出.out");
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
