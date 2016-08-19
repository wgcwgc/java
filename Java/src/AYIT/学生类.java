package AYIT;

public class 学生类 
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
//学生类
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
	//默认构造方法
	public Student()
	{
		
	}
	//构造方法
	public Student(String name,float computer,float sports,float music)
	{
		this.name = name;
		this.computer = computer;
		this.sports = sports;
		this .music = music;
	}
	//求总分
	public void sum()
	{
		float sum = computer + sports + music ;
		System.out.println(name + " 的总成绩为： " + sum);
	}
	//求平均分
	public void avg()
	{
		float avg = (computer + sports + music) / 3;
		System.out.println(name + " 的平均分为： " + avg);
	}
	//求最高分
	public void maxscore()
	{
		System.out.println(name + " 的最高分为： " + Math.max(Math.max(computer, music) , sports));
	}
	//求最低分
	public void minscore()
	{
		System.out.println(name + " 的最低分为： " + Math.min(Math.min(computer, music) , sports));
	}
	//求全部信息
	public void show()
	{
		System.out.println("\n\t" + name + " 的全部信息：  \n\n计算机成绩为： \n\t" + computer + "\n音乐成绩为： \n\t" + music + "\n体育成绩为： \n\t" + sports);
	}
	
}
