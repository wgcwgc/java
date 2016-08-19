package ers_block;

import java.awt.Frame;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Test extends Frame
{
   public static void main(String[] args)
   {
	   String str = JOptionPane.showInputDialog("请输入玩家姓名：");
       ERS_block ers = new ERS_block("俄罗斯方块游戏                             欢迎您："+ str);
       WindowListener win_listener = new WinListener();
       ers.addWindowListener(win_listener);
   }
}