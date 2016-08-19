package lamp.Demo.decorator;

/**
 * 具体的被装饰者对象：豆浆
 * @author Jeff
 *
 */
public class SoyaBeanMilk implements Drink
{

	public String description()
	{
		return "纯豆浆";
	}
	
	public float cost()
	{
		return 5f;
	}

}
