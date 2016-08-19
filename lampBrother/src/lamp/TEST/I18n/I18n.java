package lamp.TEST.I18n;
//������ʻ�
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class I18n
{
	public static void main(String[] args)
	{
		Locale locale1 = new Locale("zh" , "CN");
//		Locale locale2 = Locale.US;
//		Locale locale3 = Locale.getDefault();
		//ģ���û���¼����
		//ͨ��ResourceBundle���������Դ�ļ�������.�ļ����Ļ������ƣ�
		ResourceBundle res = ResourceBundle.getBundle("lamp.Test.I18n.info" , locale1);
		//�Ӱ󶨵���Դ�ļ��������ļ����и���Key��ȡ��Ӧ��value
		String inputKey = res.getString("input");
		String usernameKey = res.getString("username");
		String passwordKey = res.getString("password");
		String infoSuccessKey = res.getString("info.success");
		String infoErrorKey = res.getString("info.error");
		
		System.out.println(inputKey + usernameKey);
		@SuppressWarnings("resource")
		Scanner cin = new Scanner (System.in);
		String username = cin.next();
		System.out.println(inputKey + passwordKey);
		String password = cin.next();
		
		if("admin".equals(username) && "123".equals(password))
		{
			//����̬�ı�(ģʽ������Ҫ�滻��ֵ)
			String success = MessageFormat.format(infoSuccessKey,username);
			System.out.println(success);
		}
		else
			System.out.println(infoErrorKey);
	}

}
