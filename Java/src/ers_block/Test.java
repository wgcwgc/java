package ers_block;

import java.awt.Frame;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Test extends Frame
{
   public static void main(String[] args)
   {
	   String str = JOptionPane.showInputDialog("���������������");
       ERS_block ers = new ERS_block("����˹������Ϸ                             ��ӭ����"+ str);
       WindowListener win_listener = new WinListener();
       ers.addWindowListener(win_listener);
   }
}