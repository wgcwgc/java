package lamp.FILE.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 把分割后的文件再合并（文件还原）成完整文件，与原文件一致
 * @author Jeff
 *
 */
public class HomeWork
{
	/**
	 * 文件合并
	 * @param dest	目标路径
	 * @param files	要合并的文件列表
	 */
	public static void merge(String dest , File ...files)
	{
		String filename = files[0].getName();
		filename = filename.substring(0,filename.lastIndexOf("-"));
		
		try
		{
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest + filename));
			BufferedInputStream bis = null;
			byte [] bytes = new byte[1024 * 1024];
			int len = -1;
			//循环读取每个文件
			for (int i = 0; i < files.length ; i ++)
			{
				bis = new BufferedInputStream(new FileInputStream(files[i]));
				while((len = bis.read(bytes)) != -1)
				{
					bos.write(bytes,0,len);
					bos.flush();
				}
				bis.close();
			}
			bos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("开始合并");
		merge("E:\\Java\\eclipse\\workspace\\lampBrother\\",
				new File("E:\\Java\\eclipse\\workspace\\lampBrother\\src\\lamp\\FILE\\homework\\JDK_API_1_6_zh_CN.CHM-1.dat"),
				new File("E:\\Java\\eclipse\\workspace\\lampBrother\\src\\lamp\\FILE\\homework\\JDK_API_1_6_zh_CN.CHM-2.dat"),
				new File("E:\\Java\\eclipse\\workspace\\lampBrother\\src\\lamp\\FILE\\homework\\JDK_API_1_6_zh_CN.CHM-3.dat"),
				new File("E:\\Java\\eclipse\\workspace\\lampBrother\\src\\lamp\\FILE\\homework\\JDK_API_1_6_zh_CN.CHM-4.dat"));
		System.out.println("合并成功");
	}

}
