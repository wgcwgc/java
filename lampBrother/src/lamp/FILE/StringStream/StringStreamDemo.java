package lamp.FILE.StringStream;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringStreamDemo
{

	public static void writer()
	{
		//д�����
		StringWriter sw = new StringWriter();
		sw.write("chuheridangwu,paoniubupaku,zhiyaozhenxinzai,bumpa");
//		sw.toString();
		
		//��ȡ����,����һ���ַ���ȥ����һ���ַ���������
		StringReader sr = new StringReader(sw.toString());
		char [] cs = new char[10];
		int len = -1;
		try
		{
			while((len = sr.read(cs)) != -1)
			{
				System.out.print(new String(cs , 0 , len));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
			
	}
	
	public static void main(String[] args)
	{
		writer();
	}

}