package lamp.FILE.ObjectStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectStreamDemo
{
	
	//从文件中读取对象数组
	public static void readerObject2()
	{
		try
		{
			InputStream cin = new FileInputStream("ObjectStreamDemo2.out");
			//根据字节输入流构造一个对象流
			ObjectInputStream ois = new ObjectInputStream(cin);
			//读取一个组对象
			Dog [] dogs = (Dog [])ois.readObject();
			//关闭
			ois.close();
			cin.close();

			for (Dog dog : dogs)
				System.out.println(dog);

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}
	
	//把一组对象写入对象文件中
	public static void writerObject2()
	{
		try
		{
			
			OutputStream cout = new FileOutputStream("ObjectStreamDemo2.out");
			//根据字节输出流构造一个对象流
			ObjectOutputStream oos = new ObjectOutputStream(cout);
			
			//输出数据
			Dog [] dogs = {new Dog("x",1),new Dog("xiaobai" , 8),new Dog("xi" , 7)};
//			oos.writeInt(106);
//			Dog dog = new Dog("xiaobai" , 8);
			oos.writeObject(dogs);//向文件写入对象
			
			//关闭流
			oos.flush();
			oos.close();
			cout.close();
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//使用ObjectInputStream读取文件中的对象
	public static void readerObject()
	{
		try
		{
			InputStream cin = new FileInputStream("ObjectStreamDemo.out");
			//根据字节输入流构造一个对象流
			ObjectInputStream ois = new ObjectInputStream(cin);
			//读取一个整数
			int num = ois.readInt();
			//读取一个对象
			Dog dog = (Dog)ois.readObject();
			
			ois.close();
			cin.close();
			
			System.out.println("num = " + num);
			System.out.println(dog);
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

	//使用ObjectOutputStream把对象写入对象文件中
	public static void writerObject()
	{
		try
		{
			
			OutputStream cout = new FileOutputStream("ObjectStreamDemo.out");
			//根据字节输出流构造一个对象流
			ObjectOutputStream oos = new ObjectOutputStream(cout);
			
			//输出数据
			oos.writeInt(106);
			Dog dog = new Dog("xiaobai" , 8);
			oos.writeObject(dog.toString());//向文件写入对象
			
			//关闭流
			oos.flush();
			oos.close();
			cout.close();
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
//		writerObject();
//		readerObject();
//		writerObject2();
		readerObject2();
	}

}
