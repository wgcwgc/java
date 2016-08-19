package lamp.TEST.ex;

public class TestMyException
{
	public static void test()
	{
		throw new MyException("运行时异常！！！");
	}
	public static void main(String[] args)
	{
		test();
	}

}
