package lamp.USER.homework;

import java.util.Scanner;

public class HomeWork1
{

	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner cin = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = cin.next();
		System.out.println("请输入密码：");
		String password = cin.next();
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserService us = new UserService();
		try
		{
			boolean flag = us.login(user);
			if(flag)
				System.out.println("恭喜你！！！登录成功！！！");
		} catch (LogicException e) 
		{
			e.printStackTrace();
		}
		
	}

}
