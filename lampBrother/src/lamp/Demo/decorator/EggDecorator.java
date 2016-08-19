package lamp.Demo.decorator;
/**
 * ����������߶��󣺼���
 * @author Jeff
 *
 */
public class EggDecorator extends Decorator
{

	public EggDecorator(Drink drink)
	{
		super(drink);
	}

	@Override
	public String description()
	{
		return super.description() + "+����";
	}

	@Override
	public float cost()
	{
		return super.cost() + 5.0f;
	}
	

}
