package lamp.USER.homework;

public class UserService
{
	public boolean login(User user) throws LogicException
	{
		if(user == null)
			throw new LogicException("�û�������������󣡣�");
		if("admin".endsWith(user.getUsername()) && "123".equals(user.getPassword()))
			return true;
		else
			throw new LogicException("�û�������������󣡣���");
	}

}
