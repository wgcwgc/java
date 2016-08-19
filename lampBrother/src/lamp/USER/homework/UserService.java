package lamp.USER.homework;

public class UserService
{
	public boolean login(User user) throws LogicException
	{
		if(user == null)
			throw new LogicException("用户名或者密码错误！！");
		if("admin".endsWith(user.getUsername()) && "123".equals(user.getPassword()))
			return true;
		else
			throw new LogicException("用户名或者密码错误！！！");
	}

}
