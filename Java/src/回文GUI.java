

import javax.swing.JOptionPane;
public class ����GUI 
{
	public static void main(String[] args) 
	{
		  String a;
		  a=JOptionPane.showInputDialog("������Ҫ�жϵ�����:");
		  int s = 0;
		  for(int i = 0;i < a.length();i ++)
			System.out.print(a.charAt(i));
		  for (int i = (a.length()-1) / 2; i >=0 ;i--)
		   if(a.charAt(i) != a.charAt(a.length() - 1 - i))
			   s = 1;
		  if(s == 0)
			  System.out.println("�ǻ���");
		  else
			  System.out.println("���ǻ���");
	}
}