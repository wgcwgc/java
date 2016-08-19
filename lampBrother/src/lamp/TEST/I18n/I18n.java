package lamp.TEST.I18n;
//程序国际化
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
		//模拟用户登录功能
		//通过ResourceBundle工具类绑定资源文件（包名.文件名的基本名称）
		ResourceBundle res = ResourceBundle.getBundle("lamp.Test.I18n.info" , locale1);
		//从绑定的资源文件（属性文件）中根据Key获取对应的value
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
			//处理动态文本(模式，真正要替换的值)
			String success = MessageFormat.format(infoSuccessKey,username);
			System.out.println(success);
		}
		else
			System.out.println(infoErrorKey);
	}

}
