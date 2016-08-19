package lamp.TEST.ex;

@SuppressWarnings("serial")
public class MyException extends RuntimeException
{
	public MyException()
	{
		super();
	}
	public MyException(String name)
	{
		super(name);
	}
	
}
