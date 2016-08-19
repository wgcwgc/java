package lamp.FILE.BufferedStream;

import java.io.File;
public class FileHomework
{
	//�ݹ�ʵ�ֲ��ҹ���
	public static void findFile(File file,String extName)
	{
		if(file == null)
			return ;
		//��ȡĿ¼�������ļ���File����
		if(file.isDirectory())
		{
			File [] fs = file.listFiles();
			if(fs != null)
				for(File f : fs)
					findFile(f,extName);
		}
		else
		{
			//��ʱ�ļ�ʱ��ֱ���ж���չ���Ƿ�Ϊָ������չ��
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