package ·�;

import java.util.*;

class Play21
{
    int[] cards,computer,human;//����һ��54���ƣ�����5�ţ����5��
    Scanner sr=new Scanner(System.in);
    public Play21()
    {
        cards=new int[54];
        Arrays.fill(cards,0);//54����ȫ��ֵ�㣬һ��ĳһ���Ʊ����˾͸�1
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
        System.out.println("��ʼ��Ϸ��");
        int n=3;
        for(int i=0; i<3; i++)
        {
            //���Ժ�����ȸ���3��
            computer[i]=nextOne();
            human[i]=nextOne();
        }
        while(n<5)
        {
            //����С��5ʱѯ���Ƿ���Ҫ��
            show(human,n,1);//��ʾ������ҵ�����
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
            System.out.println("\n��Ӯ�ˣ�");
        else if(judge(human,computer,n)==0)
			System.out.println("\nƽ�֣�");
        else if(judge(human,computer,n)==-1)
        	System.out.println("\n�����ˣ�");
        System.out.println("*************************************");
    }
	void show(int[] a,int num,int c)
	{
	    if(c==1)
	    	System.out.println("\n"+(num-2)+":�����ڵ����ǣ�");
	    else 
	    	System.out.println("\n"+(num-2)+":�������ڵ����ǣ�");
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
	            System.out.print("С�� ");
	            continue;
	        }
	        if(a[i]==15)
	        {
	            System.out.print("��� ");
	            continue;
	        }
	        System.out.print(a[i]+" ");
	    }
	}
	boolean ask(int[] a,int num)
	{
	    System.out.println("\n����һ�ţ�Y/N");
	    String ch=sr.nextLine();
	    if(!ch.equals("n")&&!ch.equals("N"))
	    	return true;
	    else
	    	return false;
	}
	int nextOne()
	{ //�õݹ�ȷ�����ص���û���ظ�
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
	    //�жϵ��Ժ����˭�ĵ������ӽ�21������й��ƾ������ж�
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
	        	sum_a+=13;//���ƿ�������1-13
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
            System.out.println("����һ�֣�Y/N");
            ch=sr.nextLine();
            if(!ch.equals("n")&&!ch.equals("N"))
                p.clear();
            else break;
        }
    }
}
