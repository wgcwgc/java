package ers_block;

import javax.swing.JOptionPane;

//��ʱ�߳� 
public class MyTimer extends Thread
{
	 GameCanvas scr;
	 public MyTimer(GameCanvas scr)
	 {
	     this.scr = scr;
	 }
	 public void run()
	 {
	     while(true)
	     {
	         try
	         {
	             sleep((10-ERS_block.level + 1)*100);
	         }
	         catch(Exception e){}
	         if(!scr.getBlock().fallDown())
	         {
	             scr.deleteFullLine();
	             if(scr.isGameEnd())
	             {
	                 ERS_block.isPlay = false;
	                 JOptionPane.showMessageDialog(null, "��Ϸ����\n���ĳɼ�Ϊ��" + ERS_block.score);
	                 System.exit(0);
	             }
	             else
	                 scr.getBlock().reset();
	         }
	     }
	 }
}