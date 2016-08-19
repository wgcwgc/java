package lamp.FILE.ByteArray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 字节数组流
 * @author Jeff
 *
 */
public class ByteArrayDemo
{
/**
 * 使用ByteArrayOutputStream写操作
 * 
 * @param args
 */
	
	public static void write()
	{
		//创建一个字节数组输出流对象
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		String info = "woqu ,nimeilieasdf";
		
		try
		{
			//往缓冲区中输出数据
			baos.write(info.getBytes());
			baos.write(10);
//			baos.toByteArray();
			baos.close();//关闭无效，因为不涉及文件操作，而是存在内存了
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		//根据一个字节数组构造一个字节数组输入流
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		byte [] bytes = new byte[512];
		int len = -1;
		StringBuilder sb = new StringBuilder();
		try
		{
			while((len = bais.read(bytes)) != -1)
			{
				sb.append(new String(bytes,0,len));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println(sb);
		
	}
	
	public static void main(String[] args)
	{
		write();

	}

}
