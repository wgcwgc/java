package AYIT;

public class ѧ���� 
{

	public static void main(String[] args)
	{
		Student s = new Student("wgcwgc",87.878787f,57.575757f,77.777777f);
		s.show();
		s.sum();
		s.avg();
		s.maxscore();
		s.minscore();
	}
	
}
//ѧ����
class Student
{
	private String name;
	private float computer;
	private float music;
	private float sports;
	//name
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	//computer
	public void setComputer(float computer)
	{
		this.computer = computer;
	}
	public float getComputer()
	{
		return computer;
	}
	//music
	public void setMusic(float music)
	{
		this.music = music;
	}
	public float getMusic()
	{
		return music;
	}
	//sports
	public void setSports(float sports)
	{
		this.sports = sports;
	}
	public float getSports()
	{
		return sports;
	}
	//Ĭ�Ϲ��췽��
	public Student()
	{
		
	}
	//���췽��
	public Student(String name,float computer,float sports,float music)
	{
		this.name = name;
		this.computer = computer;
		this.sports = sports;
		this .music = music;
	}
	//���ܷ�
	public void sum()
	{
		float sum = computer + sports + music ;
		System.out.println(name + " ���ܳɼ�Ϊ�� " + sum);
	}
	//��ƽ����
	public void avg()
	{
		float avg = (computer + sports + music) / 3;
		System.out.println(name + " ��ƽ����Ϊ�� " + avg);
	}
	//����߷�
	public void maxscore()
	{
		System.out.println(name + " ����߷�Ϊ�� " + Math.max(Math.max(computer, music) , sports));
	}
	//����ͷ�
	public void minscore()
	{
		System.out.println(name + " ����ͷ�Ϊ�� " + Math.min(Math.min(computer, music) , sports));
	}
	//��ȫ����Ϣ
	public void show()
	{
		System.out.println("\n\t" + name + " ��ȫ����Ϣ��  \n\n������ɼ�Ϊ�� \n\t" + computer + "\n���ֳɼ�Ϊ�� \n\t" + music + "\n�����ɼ�Ϊ�� \n\t" + sports);
	}
	
}
