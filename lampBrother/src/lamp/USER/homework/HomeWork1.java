package lamp.USER.homework;

import java.util.Scanner;

public class HomeWork1
{

	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner cin = new Scanner(System.in);
		System.out.println("�������û�����");
		String username = cin.next();
		System.out.println("���������룺");
		String password = cin.next();
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserService us = new UserService();
		try
		{
			boolean flag = us.login(user);
			if(flag)
				System.out.println("��ϲ�㣡������¼�ɹ�������");
		} catch (LogicException e) 
		{
			e.printStackTrace();
		}
		
	}

}
