package lamp.FILE.BufferedStream;

import java.io.File;
public class FileHomework
{
	//递归实现查找功能
	public static void findFile(File file,String extName)
	{
		if(file == null)
			return ;
		//获取目录下所有文件的File对象
		if(file.isDirectory())
		{
			File [] fs = file.listFiles();
			if(fs != null)
				for(File f : fs)
					findFile(f,extName);
		}
		else
		{
			//当时文件时，直接判断扩展名是否为指定的扩展名
			String path = file.getPath().toLowerCase();
			if(path.endsWith(extName))
				System.out.println(file.getPath());
		}
	}
	public static void main(String[] args)
	{
		File file = new File ("F:");
		String extName = ".krc";
		findFile(file,extName);

	}
}