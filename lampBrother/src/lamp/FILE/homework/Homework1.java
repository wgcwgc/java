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
 * ʵ��һ���ļ��ָ�������һ�����ļ��ָ�����ɸ�С�ļ�
 * �ָ����ļ���չ��Ϊ.dat
 * �ļ���Ϊ��ԭ�ļ�  + ԭ�ļ���չ��  + ��� + .dat
 * @author Jeff
 *
 */
public class Homework1
{

	//�ָ��ļ�
	/**
	 * 
	 * @param src Ҫ�ָ��ԭ�ļ�·��
	 * @param mb  ÿ���ļ���С��MB��
	 * @param dest ���·��
	 */
	public static void split(String src , int mb ,String dest)
	{
		File srcFile = new File(src);
		if(!srcFile.exists())
		{
			return ;
		}
		long countSize = srcFile.length();//�õ��ļ����ܴ�С���ֽڣ�
		long fileSize = 1024 * 1024 * mb;//Ҫ�ָ��ÿ���ļ���С���ֽڣ�
		int num = (int)(countSize / fileSize);//�ָ�ķ���
		if(countSize % fileSize != 0)
			num ++;
		//�����ļ�������
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
				int count = 0;//��¼ÿ���ļ���ǰд��Ĵ�С
				//��ʼ��ȡ�ļ�
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
		System.out.println("��ʼ�ָ�");
		split("E:\\Java\\eclipse\\workspace\\lampBrother\\src\\lamp\\FILE\\homework\\JDK_API_1_6_zh_CN.CHM",10,"E:\\Java\\eclipse\\workspace\\lampBrother\\src\\lamp\\FILE\\homework\\");
		System.out.println("�ָ����");
	}

}
