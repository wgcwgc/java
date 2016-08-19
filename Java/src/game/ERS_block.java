package game;
import java.awt.*;
import java.awt.event.*;

//����˹������ 
@SuppressWarnings("serial")
public class ERS_block extends Frame
{
   public static boolean isPlay=false;
   public static int level=1,score=0;
   public static TextField scoreField,levelField;
   public static MyTimer timer;
   GameCanvas gameScr;
   public static void main(String[] args)
   {
       ERS_block ers = new ERS_block("����˹������Ϸ");
       WindowListener win_listener = new WinListener();
       ers.addWindowListener(win_listener);
//    	   if(isGameEnd())
//    	   {
//    		   @SuppressWarnings("unused")
//    		   String str = JOptionPane.showInputDialog("ERS_block.score");
//    		   JOptionPane.showMessageDialog(null, "ERS_block.score");
//    		   System.exit(0);
//    	   }
   }
//����˹������Ĺ��췽�� 
@SuppressWarnings("deprecation")
ERS_block(String title)
{
       super(title);
       setSize(555,444);
       setLayout(new GridLayout(1,2));
       gameScr = new GameCanvas();
       gameScr.addKeyListener(gameScr);
       timer = new MyTimer(gameScr);
       timer.setDaemon(true);
       timer.start();
       timer.suspend();
       add(gameScr);
       Panel rightScr = new Panel();
       rightScr.setLayout(new GridLayout(2,1,0,30));
       rightScr.setSize(120,500);
       add(rightScr);
       //�ұ���Ϣ����Ĳ���
       MyPanel infoScr = new MyPanel();
       infoScr.setLayout(new GridLayout(4,1,0,5));
       infoScr.setSize(120,300);
       rightScr.add(infoScr);
       //�����ǩ�ͳ�ʼֵ
       Label scorep = new Label("����:",Label.LEFT);
       Label levelp = new Label("�Ѷ�:",Label.LEFT);
       scoreField = new TextField(8);
       levelField = new TextField(8);
       scoreField.setEditable(false);
       levelField.setEditable(false);
       infoScr.add(scorep);
       infoScr.add(scoreField);
       infoScr.add(levelp);
       infoScr.add(levelField);
       scorep.setSize(new Dimension(20,60));
       scoreField.setSize(new Dimension(20,60));
       levelp.setSize(new Dimension(20,60));
       levelField.setSize(new Dimension(20,60));
       scoreField.setText("0");
       levelField.setText("1");
       //�ұ߿��ư�ť����Ĳ��� 
       MyPanel controlScr = new MyPanel();
       controlScr.setLayout(new GridLayout(5,1,0,5));
       rightScr.add(controlScr);
       //���尴ťplay
       Button play_b = new Button("��ʼ��Ϸ");
       play_b.setSize(new Dimension(50,200));
       play_b.addActionListener(new Command(Command.button_play,gameScr));
       //���尴ťLevel UP
       Button level_up_b = new Button("�����Ѷ�");
       level_up_b.setSize(new Dimension(50,200));
       level_up_b.addActionListener(new Command(Command.button_levelup,gameScr));
       //���尴ťLevel Down
       Button level_down_b =new Button("��С�Ѷ�");
       level_down_b.setSize(new Dimension(50,200));
       level_down_b.addActionListener(new Command(Command.button_leveldown,gameScr));
       //���尴ťLevel Pause
       Button pause_b =new Button("��ͣ��Ϸ");
       pause_b.setSize(new Dimension(50,200));
       pause_b.addActionListener(new Command(Command.button_pause,gameScr));
       //���尴ťQuit
       Button quit_b = new Button("�˳���Ϸ");
       quit_b.setSize(new Dimension(50,200));
       quit_b.addActionListener(new Command(Command.button_quit,gameScr));
       controlScr.add(play_b);
       controlScr.add(level_up_b);
       controlScr.add(level_down_b);
       controlScr.add(pause_b);
       controlScr.add(quit_b);
       setVisible(true);
       gameScr.requestFocus();
     }
   }
//��дMyPanel�࣬ʹPanel���������ռ� 
@SuppressWarnings("serial")
class MyPanel extends Panel
{
       public Insets getInsets()
       {
           return new Insets(10,10,10,50);
       }
}
//��Ϸ������ 
@SuppressWarnings("serial")
class GameCanvas extends Canvas implements KeyListener
{
       final int unitSize = 27;                            //С����߳� 
       int rowNum;                                         //����������� 
       int columnNum;                                      //����������� 
       int maxAllowRowNum;                                 //�����ж�����δ��
       int blockInitRow;                                   //�³��ֿ����ʼ������ 
       int blockInitCol;                                   //�³��ֿ����ʼ������ 
       int [][] scrArr;                                    //��Ļ���� 
       Block b;                                            //�Է�������� 
       //������Ĺ��췽�� 
       GameCanvas()
       {
           rowNum = 15;
           columnNum = 10;
           maxAllowRowNum = rowNum;
           b = new Block(this);
           blockInitRow = rowNum - 1;
           blockInitCol = columnNum / 2 - 2;
           scrArr = new int [32][32];
       }
       //��ʼ����Ļ��������Ļ��������ķ��� 
       void initScr()
       {
           for(int i = 0;i < rowNum;i ++)
               for(int j = 0;j < columnNum;j ++)
                   scrArr[i][j] = 0;
               b.reset();
               repaint();
       }
       //����ˢ�»������� 
       public void paint(Graphics g)
       {
           for(int i = 0;i < rowNum;i ++)
               for(int j = 0;j < columnNum;j ++)
                   drawUnit(i,j,scrArr[i][j]);
       }
       //������ķ��� 
       public void drawUnit(int row,int col,int type)
       {
           scrArr[row][col] = type;
           Graphics g = getGraphics();
           switch(type)
           {
               case 0: g.setColor(Color.black);break;      //�Ա���Ϊ��ɫ�� 
               case 1: g.setColor(Color.blue);break;       //����������ķ��� 
               case 2: g.setColor(Color.yellow);break;    //���Ѿ����µķ��� 
           }
           g.fill3DRect(col*unitSize,getSize().height-(row+1)*unitSize,unitSize,unitSize,true);
           g.dispose();
       }
       public Block getBlock()
       {
           return b;                 //����blockʵ�������� 
       }
       //������Ļ������(row,col)λ�õ�����ֵ 
       public int getScrArrXY(int row,int col)
       {
           if (row < 0  || row >= rowNum || col < 0 || col >= columnNum)
               return(-1);
           else
               return(scrArr[row][col]);
       }
       public int getInitRow()
       {
           return(blockInitRow);            //�����¿�ĳ�ʼ������ 
       }
       public int getInitCol()
       {
           return(blockInitCol);          //�����¿�ĳ�ʼ������ 
       }
       //����
       void deleteFullLine()
       {
           int full_line_num = 0;
           int k = 0;
           for (int i = 0;i < rowNum;i ++)
           {
               boolean isfull = true;
               for(int j = 0;j < columnNum;j ++)
                   if(scrArr[i][j] == 0)
                   {
                       k ++;
                       isfull = false;
                       break;
                   }
               if(isfull)
            	   full_line_num ++;
               if(k != 0 && k-1 != i && !isfull)
                   for(int j = 0; j < columnNum; j ++)
                   {
                       if (scrArr[i][j] == 0)
                         drawUnit(k-1,j,0);
                       else
                         drawUnit(k-1,j,2);
                       scrArr[k-1][j] = scrArr[i][j];
                   }
           }
           for(int i = k-1 ;i < rowNum; i++)
               for(int j = 0; j < columnNum; j++)
               {
                   drawUnit(i,j,0);
                   scrArr[i][j]=0;
               }
           ERS_block.score += full_line_num;
           ERS_block.scoreField.setText(""+ERS_block.score);
       }
       public void keyTyped(KeyEvent e){}
       public void keyReleased(KeyEvent e){}
       //�����������ķ��� 
       public void keyPressed(KeyEvent e)
       {
           if(!ERS_block.isPlay)
               return;
          switch(e.getKeyCode())
          {
               case KeyEvent.VK_DOWN:b.fallDown();break;
               case KeyEvent.VK_LEFT:b.leftMove();break;
               case KeyEvent.VK_RIGHT:b.rightMove();break;
               
               case KeyEvent.VK_UP:b.leftTurn();break;
               case KeyEvent.VK_ENTER:b.leftTurn();break;
               case KeyEvent.VK_SPACE:b.leftTurn();break;
           }
       }
       //�ж���Ϸ�Ƿ�������� 
       public boolean isGameEnd()
       {
           for(int col = columnNum / 2;col < columnNum;col ++)
               if(scrArr[maxAllowRowNum][col] != 0)
	               return true;
           return false;
       }
}
//��������� 
class Command implements ActionListener
{
		//����ť������ 
       static final int button_play = 1;
       static final int button_levelup = 2;
       static final int button_leveldown = 3;
       static final int button_quit = 4;
       static final int button_pause = 5;
       static boolean pause_resume = true;
       int curButton;                    //��ǰ��ť 
       GameCanvas scr;
       //���ư�ť��Ĺ��췽�� 
       Command(int button,GameCanvas scr)
       {
           curButton = button;
           this.scr=scr;
       }
       //��ťִ�з��� 
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
	               }
	               else
	               {
	                   ERS_block.timer.resume();
	                   pause_resume = true;
	               }
            	   scr.requestFocus();
            	   break;
               case button_quit:
            	   System.exit(0);
           }
       }
}
//������ 
class Block
{
   static int[][] pattern = {
	   //��ʮ�����Ʊ�ʾ��ÿ�б�ʾ����״̬ 
       {0x0f00,0x4444,0x0f00,0x4444},
       {0x04e0,0x0464,0x00e4,0x04c4},
       {0x4620,0x6c00,0x4620,0x6c00},
       {0x2640,0xc600,0x2640,0xc600},
       {0x6220,0x1700,0x2230,0x0740},
       {0x6440,0x0e20,0x44c0,0x8e00},
       {0x0660,0x0660,0x0660,0x0660}
   };
   int blockType;                //���ģʽ�ţ�0-6��
   int turnState;               //��ķ�ת״̬��0-3)
   int blockState;             //�������״̬
   int row,col;               //���ڻ����ϵ����� 
   GameCanvas scr; 			 //����Ĺ��췽�� 
   Block(GameCanvas scr)
   {
       this.scr = scr;
       blockType = (int)(Math.random() * 1000)%7;
       turnState = (int)(Math.random() * 1000)%4;
       blockState = 1;
       row = scr.getInitRow();
       col = scr.getInitCol();
   }
   //���³�ʼ���飬����ʾ�¿� 
   public void reset()
   {
       blockType = (int)(Math.random() * 1000)%7;
       turnState = (int)(Math.random() * 1000)%4;
       blockState = 1;
       row = scr.getInitRow();
       col = scr.getInitCol();
       dispBlock(1);
   }
   //ʵ�ֿ鷭ת�ķ��� 
   public void leftTurn()
   {
       if(assertValid(blockType,(turnState + 1)%4,row,col))
       {
           dispBlock(0);
           turnState = (turnState + 1) % 4;
           dispBlock(1);
       }
   }
   //ʵ�ֿ�����Ƶķ��� 
   public void leftMove()
   {
       if(assertValid(blockType,turnState,row,col-1))
       {
           dispBlock(0);
           col --;
           dispBlock(1);
       }
   }
   //ʵ�ֿ������ 
   public void rightMove()
   {
       if(assertValid(blockType,turnState,row,col+1))
       {
           dispBlock(0);
           col ++;
           dispBlock(1);
       }
   }
   //ʵ�ֿ����µĲ����ķ��� 
   public boolean fallDown()
   {
       if(blockState == 2)
           return(false);
       if(assertValid(blockType,turnState,row-1,col))
       {
           dispBlock(0);
           row --;
           dispBlock(1);
           return(true);
       }
       else
       {
           blockState = 2;
           dispBlock(2);
           return(false);
       }
   }
   //�ж��Ƿ���ȷ�ķ��� 
   boolean assertValid(int t,int s,int row,int col)
   {
       int k = 0x8000;
       for(int i = 0; i < 4; i++)
       {
           for(int j = 0; j < 4; j++)
           {
               if((int)(pattern[t][s]&k) != 0)
               {
                   int temp = scr.getScrArrXY(row-i,col+j);
                   if (temp<0||temp==2)
                   return false;
               }
               k >>= 1;
           }
       }
       return true;
   }
   //ͬ����ʾ�ķ��� 
   public synchronized void dispBlock(int s)
   {
       int k = 0x8000;
       for (int i = 0; i < 4; i++)
           for(int j = 0; j < 4; j++)
           {
               if(((int)pattern[blockType][turnState]&k) != 0)
                   scr.drawUnit(row-i,col+j,s);
               k >>= 1;
           }
   }
}
//��ʱ�߳� 
class MyTimer extends Thread
{
   GameCanvas scr;
   public MyTimer(GameCanvas scr)
   {
       this.scr = scr;
   }
   @SuppressWarnings("deprecation")
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
                   suspend();
               }
               else
                   scr.getBlock().reset();
           }
       }
   }
}
class WinListener extends WindowAdapter
{
       public void windowClosing(WindowEvent l)
       {
           System.exit(0);
       }
}