package wgc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo
{

	public static void main(String[] args)
	{
		//��һ���������Ի����йصķ�ʽ����ʽ���ͽ������ڵľ�����
		SimpleDateFormat sdf1 = new SimpleDateFormat();
		//����ѡ���κ��û����������-ʱ���ʽ��ģʽ
		SimpleDateFormat sdf2 = new SimpleDateFormat("Gyyyy��MM��dd��  a HH:mm:ss SS����  E  zZ");

		String s1 = sdf1.format(new Date());
		String s2 = sdf2.format(new Date());
		
		System.out.println(s1 + "\n" + s2);
	}

}
