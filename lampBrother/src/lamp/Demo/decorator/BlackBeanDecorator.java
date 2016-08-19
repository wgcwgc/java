package lamp.Demo.decorator;
/**
 * �����װ���߶��󣺺ڶ�
 * @author Jeff
 *
 */
public class BlackBeanDecorator extends Decorator
{

	public BlackBeanDecorator(Drink drink)
	{
		super(drink);
	}

	@Override
	public String description()
	{
		return super.description() + "+�ڶ�";
	}

	@Override
	public float cost()
	{
		return super.cost() + 3.0f;
	}
	
	
}
