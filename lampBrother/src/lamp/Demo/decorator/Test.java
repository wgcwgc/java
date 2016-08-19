package lamp.Demo.decorator;

public class Test
{

	public static void main(String[] args)
	{
		//生产一杯豆浆
		Drink soya = new SoyaBeanMilk();
		//在豆浆中加鸡蛋
		EggDecorator eggSoya = new EggDecorator(soya);
		//在加了鸡蛋的豆浆中加糖
		SugarDecorator sugarEggSoya = new SugarDecorator(eggSoya);
		//在加了烫的豆浆中加黑豆
		BlackBeanDecorator blackBeanSugarEggSoya = new BlackBeanDecorator(sugarEggSoya);
		
		//结账
		System.out.println("tongzhi : nidiandeshi:" + blackBeanSugarEggSoya.description());
		System.out.println("niyigongxiaofeile :" + blackBeanSugarEggSoya.cost() + "yuan");
		
	}

}
