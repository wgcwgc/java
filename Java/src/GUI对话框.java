

import javax.swing.JOptionPane;
public class GUI�Ի���
{
	public static void main(String[] args)
	{
		//JOptionPane.showInputDialog(null,"input message","input",JOptionPane.CANCEL_OPTION);
		//JOptionPane.showInputDialog("input");
		
		JOptionPane.showInputDialog(null,"input message","input",JOptionPane.showConfirmDialog(null,"null"));
		
		//JOptionPane.showMessageDialog(null, "��ʼ");
		JOptionPane.showMessageDialog(null, "��Ϣ","���ⴺ",JOptionPane.INFORMATION_MESSAGE);
		//JOptionPane.showMessageDialog(null, "����","���ⴺ",JOptionPane.WARNING_MESSAGE);
		//JOptionPane.showMessageDialog(null, "����","���ⴺ",JOptionPane.ERROR_MESSAGE);
		//JOptionPane.showMessageDialog(null, "����","���ⴺ",JOptionPane.QUESTION_MESSAGE);
		
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