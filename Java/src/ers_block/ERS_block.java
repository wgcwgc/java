package ers_block;
import java.awt.*;
//����˹������ 
@SuppressWarnings("serial")
public class ERS_block extends Frame
{
   public static boolean isPlay = false;
   public static int level=1,score=0;
   public static TextField scoreField,levelField;
   public static MyTimer timer;
   GameCanvas gameScr;
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