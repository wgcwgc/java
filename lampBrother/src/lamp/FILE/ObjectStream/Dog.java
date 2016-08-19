package lamp.FILE.ObjectStream;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dog implements Serializable
{
	/**
	 * 序列化： 指将一个对象转换成二进制的byte流
	 * 两种情况：
	 * 对象的序列化操作：将对象保存到文件上的操作
	 * 反序列化操作：将对象从文件中恢复
	 * 用ObjectOutputStream类实现对象的序列化
	 * 使用ObjectInputStream类实现对象的反序列化操作
	 * 
	 */
	//使用transient关键字声明的属性将不会被序列化
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
