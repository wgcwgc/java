package lamp.FILE.ObjectStream;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dog implements Serializable
{
	/**
	 * ���л��� ָ��һ������ת���ɶ����Ƶ�byte��
	 * ���������
	 * ��������л������������󱣴浽�ļ��ϵĲ���
	 * �����л���������������ļ��лָ�
	 * ��ObjectOutputStream��ʵ�ֶ�������л�
	 * ʹ��ObjectInputStream��ʵ�ֶ���ķ����л�����
	 * 
	 */
	//ʹ��transient�ؼ������������Խ����ᱻ���л�
	private transient int age;
	private String name;
	
	public Dog()
	{
		super();
	}
	
	public Dog(String name , int age)
	{
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String toString()
	{
		return "Dog [age=" + age + ", name=" + name + "]";
	}

}
