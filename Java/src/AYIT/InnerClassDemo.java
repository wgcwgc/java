package AYIT;

public class InnerClassDemo 
{
	public static void main(String[] args)
	{
		// �̳�ʽ�����ڲ���
		Dog dog = new Dog("huahua")
		{
			public void say()
			{
				System.out.println("woshiyizhimugou,zhurenjiaowo" + name);
			}
		};
		dog.say();
		
		//�ӿ�ʽ�����ڲ���
		Child child = new Child()
		{
			public void talk()
			{
				System.out.println("woshiyizhimugou");
			}
		};
		child.talk();
		
		//����ʽ�����ڲ���
		childTalk(new Child()
		{
			public void talk()
			{
				System.out.println("woshiyizhigou");
			}
		});
	}
	
	public static void childTalk(Child c)
	{
		c.talk();
	}
	
}

class Dog
{
	String name;
	public Dog(String name)
	{
		this.name = name;
	}
	public void say(){}
//	{
//		System.out.println("woshiyizhigou ,zhurenjiaowo "+ name);
//	}
}
/*
class WomenDog extends Dog
{
	public WomenDog(String name)
	{
		super(name);
	}
	public void say()
	{
		System.out.println("woshiyizhimugouzhurenjiaowo" + name);
	}
}
*/
interface Child
{
	public void talk();
}
