package lamp.FILE.ByteArray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * �ֽ�������
 * @author Jeff
 *
 */
public class ByteArrayDemo
{
/**
 * ʹ��ByteArrayOutputStreamд����
 * 
 * @param args
 */
	
	public static void write()
	{
		//����һ���ֽ��������������
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		String info = "woqu ,nimeilieasdf";
		
		try
		{
			//�����������������
			baos.write(info.getBytes());
			baos.write(10);
//			baos.toByteArray();
			baos.close();//�ر���Ч����Ϊ���漰�ļ����������Ǵ����ڴ���
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		//����һ���ֽ����鹹��һ���ֽ�����������
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
