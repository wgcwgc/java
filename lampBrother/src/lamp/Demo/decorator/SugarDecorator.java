package lamp.Demo.decorator;
/**
 * 具体的装饰者对象：糖
 * @author Jeff
 *
 */
public class SugarDecorator extends Decorator
{

	public SugarDecorator(Drink drink)
	{
		super(drink);
	}

	@Override
	public String description()
	{
		// TODO 自动生成的方法存根
		return super.description() + " +糖";
	}

	@Override
	public float cost()
	{
		// TODO 自动生成的方法存根
		return super.cost() + 0.5f;
	}

}
