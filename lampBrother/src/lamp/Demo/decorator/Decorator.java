package lamp.Demo.decorator;
/**
 * �����߻���
 */
public abstract class Decorator implements Drink
{
	 private Drink drink;//Ҫװ�εĶ���
	 public Decorator(Drink drink)
	 {
		 this.drink = drink;
	 }

	@Override
	public String description()
	{
		return drink.description();
	}

	@Override
	public float cost()
	{
		return drink.cost();
	}

}
