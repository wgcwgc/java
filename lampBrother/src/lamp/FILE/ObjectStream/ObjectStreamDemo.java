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
	
	//���ļ��ж�ȡ��������
	public static void readerObject2()
	{
		try
		{
			InputStream cin = new FileInputStream("ObjectStreamDemo2.out");
			//�����ֽ�����������һ��������
			ObjectInputStream ois = new ObjectInputStream(cin);
			//��ȡһ�������
			Dog [] dogs = (Dog [])ois.readObject();
			//�ر�
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
	
	//��һ�����д������ļ���
	public static void writerObject2()
	{
		try
		{
			
			OutputStream cout = new FileOutputStream("ObjectStreamDemo2.out");
			//�����ֽ����������һ��������
			ObjectOutputStream oos = new ObjectOutputStream(cout);
			
			//�������
			Dog [] dogs = {new Dog("x",1),new Dog("xiaobai" , 8),new Dog("xi" , 7)};
//			oos.writeInt(106);
//			Dog dog = new Dog("xiaobai" , 8);
			oos.writeObject(dogs);//���ļ�д�����
			
			//�ر���
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
	
	//ʹ��ObjectInputStream��ȡ�ļ��еĶ���
	public static void readerObject()
	{
		try
		{
			InputStream cin = new FileInputStream("ObjectStreamDemo.out");
			//�����ֽ�����������һ��������
			ObjectInputStream ois = new ObjectInputStream(cin);
			//��ȡһ������
			int num = ois.readInt();
			//��ȡһ������
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

	//ʹ��ObjectOutputStream�Ѷ���д������ļ���
	public static void writerObject()
	{
		try
		{
			
			OutputStream cout = new FileOutputStream("ObjectStreamDemo.out");
			//�����ֽ����������һ��������
			ObjectOutputStream oos = new ObjectOutputStream(cout);
			
			//�������
			oos.writeInt(106);
			Dog dog = new Dog("xiaobai" , 8);
			oos.writeObject(dog.toString());//���ļ�д�����
			
			//�ر���
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
