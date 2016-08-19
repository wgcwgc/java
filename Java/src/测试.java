import java.util.Date;


public class 测试 
{
	public static void main(String[] args) throws Exception
	{
		//显示当前时间
		Date date = new Date();
		//System.out.println(date.toLocaleString());
		System.out.println(date.toString());	
	}
//	//计算n^m
//	public static int calc(int n,int m)
//	{
//		int re = 1;
//		while(m != 0)
//		{
//			if((m & 1) != 0)
//				re *= n;
//			n *= n;
//			m >>= 1;
//		}
//		return re;
//	}
}
