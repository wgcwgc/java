package ers_block;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
//处理控制类 
public class Command implements ActionListener
{
	 //给按钮分配编号 
     static final int button_play = 1;
     static final int button_levelup = 2;
     static final int button_leveldown = 3;
     static final int button_quit = 4;
     static final int button_pause = 5;
     static boolean pause_resume = true;
     int curButton;                    //当前按钮 
     GameCanvas scr;
     //控制按钮类的构造方法 
     Command(int button,GameCanvas scr)
     {
         curButton = button;
         this.scr=scr;
     }
     //按钮执行方法 
     @SuppressWarnings("deprecation")
     public void actionPerformed(ActionEvent e)
     {
        switch(curButton)
        {
             case button_play:
          	   if(!ERS_block.isPlay)
	               {
	                   scr.initScr();
	                   ERS_block.isPlay = true;
	                   ERS_block.score  = 0;
	                   ERS_block.scoreField.setText("0");
	                   ERS_block.timer.resume();
	               }
          	   scr.requestFocus();
          	   break;
             case button_levelup:
          	   if(ERS_block.level < 10)
	               {
	                   ERS_block.level ++;
	                   ERS_block.levelField.setText("" + ERS_block.level);
	                   ERS_block.score = 0;
	                   ERS_block.scoreField.setText("" + ERS_block.score);
	               }
          	   scr.requestFocus();
          	   break;
             case button_leveldown:
          	   if(ERS_block.level > 1)
	               {
	                   ERS_block.level--;
	                   ERS_block.levelField.setText(""+ERS_block.level);
	                   ERS_block.score = 0;
	                   ERS_block.scoreField.setText(""+ERS_block.score);
	               }
	               scr.requestFocus();
	               break;
             case button_pause:
          	   if(pause_resume)
	               {
	                   ERS_block.timer.suspend();
	                   pause_resume = false;
	                   JOptionPane.showMessageDialog(null, "再次点击暂停游戏开始游戏");
	               }
	               else
	               {
	                   ERS_block.timer.resume();
	                   pause_resume = true;
	               }
          	   scr.requestFocus();
          	   break;
             case button_quit:
            JOptionPane.showMessageDialog(null, "您的成绩为：" + ERS_block.score);
          	   System.exit(0);
         }
     }
}