package lamp.FILE.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * E:\Java\eclipse\workspace\lampBrother\src\lamp\FILE\homework\JDK_API_1_6_zh_CN.CHM
 * 实现一个文件分割器，把一个大文件分割成若干个小文件
 * 分割后的文件扩展名为.dat
 * 文件名为：原文件  + 原文件扩展名  + 编号 + .dat
 * @author Jeff
 *
 */
public class Homework1
{

	//分割文件
	/**
	 * 
	 * @param src 要分割的原文件路径
	 * @param mb  每个文件大小（MB）
	 * @param dest 输出路径
	 */
	public static void split(String src , int mb ,String dest)
	{
		File srcFile = new File(src);
		if(!srcFile.exists())
		{
			return ;
		}
		long countSize = srcFile.length();//得到文件的总大小（字节）
		long fileSize = 1024 * 1024 * mb;//要分割的每个文件大小（字节）
		int num = (int)(countSize / fileSize);//分割的份数
		if(countSize % fileSize != 0)
			num ++;
		//构造文件输入流
		try
		{
			InputStream cin = new FileInputStream(srcFile);
			BufferedInputStream bis = new BufferedInputStream(cin);
			BufferedOutputStream bos = null;
			byte [] bytes = new byte[1024 * 1024];
			int len = -1;
			for(int i = 1;i <= num ; i ++)
			{
				String newFile = dest + File.separator + srcFile.getName() + "-" + i +".dat";
				bos = new BufferedOutputStream(new FileOutputStream(newFile));
				int count = 0;//记录每个文件当前写入的大小
				//开始读取文件
				while((len = bis.read(bytes)) != -1)
				{
					bos.write(bytes,0,len);
					bos.flush();
					count += len;
					if(count >= fileSize)
						break;
				}
				bos.close();
			}
			bis.close();
			cin.close();
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
		System.out.println("开始分割");
		split("E:\\Java\\eclipse\\workspace\\lampBrother\\src\\lamp\\FILE\\homework\\JDK_API_1_6_zh_CN.CHM",10,"E:\\Java\\eclipse\\workspace\\lampBrother\\src\\lamp\\FILE\\homework\\");
		System.out.println("分割完成");
	}

}
