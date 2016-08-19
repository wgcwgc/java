package lamp.Demo.decorator;
/**
 * �����װ���߶�����
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
		// TODO �Զ����ɵķ������
		return super.description() + " +��";
	}

	@Override
	public float cost()
	{
		// TODO �Զ����ɵķ������
		return super.cost() + 0.5f;
	}

}
