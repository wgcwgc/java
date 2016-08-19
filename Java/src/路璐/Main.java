package 路璐;

import java.util.*;

class Play21
{
    int[] cards,computer,human;//定义一副54张牌，电脑5张，玩家5张
    Scanner sr=new Scanner(System.in);
    public Play21()
    {
        cards=new int[54];
        Arrays.fill(cards,0);//54张牌全赋值零，一旦某一张牌被用了就赋1
        computer=new int[5];
        Arrays.fill(computer,0);
        human=new int[5];
        Arrays.fill(human,0);
    }
    public void clear()
    {
        Arrays.fill(cards,0);
        Arrays.fill(computer,0);
        Arrays.fill(human,0);
    }
    public void start()
    {
        System.out.println("*************************************");
        System.out.println("开始游戏！");
        int n=3;
        for(int i=0; i<3; i++)
        {
            //电脑和玩家先各抽3张
            computer[i]=nextOne();
            human[i]=nextOne();
        }
        while(n<5)
        {
            //牌数小于5时询问是否再要牌
            show(human,n,1);//显示现在玩家的牌面
            if(ask(human,n))
            {
                computer[n]=nextOne();
                human[n]=nextOne();
                n++;
            }
            else
                break;
        }
        show(human,n,1);
        show(computer,n,0);
        if(judge(human,computer,n)==1)
            System.out.println("\n你赢了！");
        else if(judge(human,computer,n)==0)
			System.out.println("\n平局！");
        else if(judge(human,computer,n)==-1)
        	System.out.println("\n你输了！");
        System.out.println("*************************************");
    }
	void show(int[] a,int num,int c)
	{
	    if(c==1)
	    	System.out.println("\n"+(num-2)+":你现在的牌是：");
	    else 
	    	System.out.println("\n"+(num-2)+":电脑现在的牌是：");
	    for(int i=0; i<num; i++)
	    {
	        if(a[i]==1)
	        {
	            System.out.print("A ");
	            continue;
	        }
	        if(a[i]==11)
	        {
	            System.out.print("J ");
	            continue;
	        }
	        if(a[i]==12)
	        {
	            System.out.print("Q ");
	            continue;
	        }
	        if(a[i]==13)
	        {
	            System.out.print("K ");
	            continue;
	        }
	        if(a[i]==14)
	        {
	            System.out.print("小鬼 ");
	            continue;
	        }
	        if(a[i]==15)
	        {
	            System.out.print("大鬼 ");
	            continue;
	        }
	        System.out.print(a[i]+" ");
	    }
	}
	boolean ask(int[] a,int num)
	{
	    System.out.println("\n还抽一张？Y/N");
	    String ch=sr.nextLine();
	    if(!ch.equals("n")&&!ch.equals("N"))
	    	return true;
	    else
	    	return false;
	}
	int nextOne()
	{ //用递归确保返回的牌没有重复
		int n=(int)(Math.random()*54);
		if(cards[n]==0)
		{
		    cards[n]=1;
		    if(n==52)
		        return 14;
		    else if(n==53)
		        return 15;
		    else
		        return n%13+1;
		}
		else return
		        nextOne();
	}
	int judge(int[] a,int[] b,int num)
	{
	    //判断电脑和玩家谁的点数更接近21，如果有鬼牌就另行判断
	    int sum_a=0,sum_b=0;
	    boolean joker_a=false,joker_b=false;
	    for(int i=0; i<num; i++)
	    {
	        if(a[i]==14||a[i]==15)
	        	joker_a=true;
	        else
	        	sum_a+=a[i];
	        if(b[i]==14||b[i]==15)
	        	joker_b=true;
	        else
	        	sum_b+=b[i];
	    }
	    if(joker_a)
	        if(sum_a<8)
	        	sum_a+=13;//鬼牌可以任意1-13
	        else if(sum_a<21)
	        	sum_a=21;
	    if(joker_b)
	        if(sum_b<8)sum_b+=13;
	        else if(sum_b<21)
	        	sum_b=21;
	    if(sum_a>21&&sum_b<=21)
	        return -1;
	    if(sum_a<=21&&sum_b>21)
	        return 1;
	    if(Math.abs(sum_a-21)<Math.abs(sum_b-21))
	        return 1;
	    else if(Math.abs(sum_a-21)==Math.abs(sum_b-21))
	        return 0;
	    else //if(Math.abs(sum_a-21)>Math.abs(sum_b-21))
	        return -1;
	}
}
public class Main
{
    @SuppressWarnings("resource")
	public static void main (String[] args)
    {
        Play21 p=new Play21();
        Scanner sr = new Scanner(System.in);
        String ch="y";
        while(true)
        {
            p.start();
            System.out.println("再来一局？Y/N");
            ch=sr.nextLine();
            if(!ch.equals("n")&&!ch.equals("N"))
                p.clear();
            else break;
        }
    }
}
