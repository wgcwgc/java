package lamp.Demo.decorator;
/**
 * 具体的修饰者对象：鸡蛋
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
		return super.description() + "+鸡蛋";
	}

	@Override
	public float cost()
	{
		return super.cost() + 5.0f;
	}
	

}
