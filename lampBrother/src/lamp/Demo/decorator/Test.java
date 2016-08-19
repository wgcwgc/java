package lamp.Demo.decorator;

public class Test
{

	public static void main(String[] args)
	{
		//����һ������
		Drink soya = new SoyaBeanMilk();
		//�ڶ����мӼ���
		EggDecorator eggSoya = new EggDecorator(soya);
		//�ڼ��˼����Ķ����м���
		SugarDecorator sugarEggSoya = new SugarDecorator(eggSoya);
		//�ڼ����̵Ķ����мӺڶ�
		BlackBeanDecorator blackBeanSugarEggSoya = new BlackBeanDecorator(sugarEggSoya);
		
		//����
		System.out.println("tongzhi : nidiandeshi:" + blackBeanSugarEggSoya.description());
		System.out.println("niyigongxiaofeile :" + blackBeanSugarEggSoya.cost() + "yuan");
		
	}

}
