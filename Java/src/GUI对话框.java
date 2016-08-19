

import javax.swing.JOptionPane;
public class GUI对话框
{
	public static void main(String[] args)
	{
		//JOptionPane.showInputDialog(null,"input message","input",JOptionPane.CANCEL_OPTION);
		//JOptionPane.showInputDialog("input");
		
		JOptionPane.showInputDialog(null,"input message","input",JOptionPane.showConfirmDialog(null,"null"));
		
		//JOptionPane.showMessageDialog(null, "开始");
		JOptionPane.showMessageDialog(null, "信息","王光春",JOptionPane.INFORMATION_MESSAGE);
		//JOptionPane.showMessageDialog(null, "警告","王光春",JOptionPane.WARNING_MESSAGE);
		//JOptionPane.showMessageDialog(null, "错误","王光春",JOptionPane.ERROR_MESSAGE);
		//JOptionPane.showMessageDialog(null, "疑问","王光春",JOptionPane.QUESTION_MESSAGE);
		
		/**
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext())
		{
			int a,b;//=cin.nextInt();
			JOptionPane.showInputDialog(null);
			JOptionPane.showInputDialog(null,a=cin.nextInt());
			//int b=cin.nextInt();
			JOptionPane.showInputDialog(null,b=cin.nextInt());
			//System.out.println(a+b);
			JOptionPane.showInputDialog(a+b);
		}
		 cin.close();
		 */
	}
}