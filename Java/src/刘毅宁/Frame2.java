package ������;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
@SuppressWarnings("serial")
public class Frame2 extends JFrame implements Runnable
{
    JPanel contentPane;
    JPanel jPanel1 = new JPanel();
    JButton jButton1 = new JButton();
    JSlider jSlider1 = new JSlider();
    JLabel jLabel1 = new JLabel();
    JButton jButton2 = new JButton();
    JLabel jLabel2 = new JLabel();
    int count = 1, rapidity = 80; // count ��ǰ���еĸ���, rapidity �α��λ��
    int zhengque = 0, cuowu = 0;
    int rush[] = { 10 ,20 ,30 };//��Ϸÿ�صĸ��� �����������.�� { 10 ,20 ,30 ,40,50}
    int rush_count = 0;      //��¼����
    char list[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
    'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y','Z',
    '1', '2', '3', '4', '5', '6', '7', '8', '9'};           //������ֵ����� �����������
    @SuppressWarnings("rawtypes")
    Vector number = new Vector();
    String paiduan = "true";
    public Frame2()
    {
        try
        {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
    /**
    * Component initialization.
    *
    * @throws java.lang.Exception
    */
    private void jbInit() throws Exception
    {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);
        setSize(new Dimension(588, 530));
        setTitle("Frame Title");
        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        jPanel1.setBounds(new Rectangle(4, 4, 573, 419));
        jPanel1.setLayout(null);
        jButton1.setBounds(new Rectangle(277, 442, 89, 31));
        jButton1.setText("��ʼ");
        jButton1.addActionListener(new Frame1_jButton1_actionAdapter(this));
        jSlider1.setBounds(new Rectangle(83, 448, 164, 21));
        jSlider1.setMaximum(100);
        jSlider1.setMinimum(1);
        jSlider1.setValue(50);
        jLabel1.setText("�ٶ�");
        jLabel1.setBounds(new Rectangle(35, 451, 39, 18));
        jButton2.setBounds(new Rectangle(408, 442, 89, 31));
        jButton2.setText("����");
        jButton2.addActionListener(new Frame1_jButton2_actionAdapter(this));
        jLabel2.setText("��һ��:100��");
        jLabel2.setBounds(new Rectangle(414, 473, 171, 21));
        contentPane.add(jPanel1);
        contentPane.add(jButton2);
        contentPane.add(jButton1);
        contentPane.add(jSlider1);
        contentPane.add(jLabel1);
        contentPane.add(jLabel2);
        this.addKeyListener(new MyListener());
        jButton1.addKeyListener(new MyListener());
        jSlider1.addKeyListener(new MyListener());
        jSlider1.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                rapidity = jSlider1.getValue();
            }
        });
    }
    public void run()
    {
        number.clear();
        zhengque = 0;
        cuowu = 0;
        paiduan = "true";
        while (count <= rush[rush_count])
        {
            try
            {
                Thread t = new Thread(new Tthread());
                t.start();
                count += 1;
                Thread.sleep(1000 + (int) (Math.random() * 2000)); // ��������ͣ��ʱ��
                // ���1��.����2��
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        while (true)   // �ȴ����һ���ַ���ʧ
        {
            if (number.size() == 0)
            {
                break;
            }
        }
        if (zhengque == 0)   // Ϊ���Ժ����..���ȫ����ȷ���ߴ���ͻ���ִ���. ����..
        {
            zhengque = 1;
        }
        if (cuowu == 0)
        {
            cuowu = 1;
        }
        if (paiduan.equals("true"))   // �ж��Ƿ�����Ȼ����
        {
            if (zhengque / cuowu >= 2)
            {
                JOptionPane.showMessageDialog(null, "��ϲ�������");
                rush_count += 1; // �Զ���1��
                if (rush_count < rush.length)
                {
                    if (rapidity > 10)   // ���ٶȴ���10��ʱ����-5����ٶ�.���ٶ�̫��
                    {
                        rapidity -= 5; // �ٶ��Զ���10����
                        jSlider1.setValue(rapidity); // ѡ��λ��
                    }
                    Thread t = new Thread(this);
                    t.start();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "ţB...��ͨ����..");
                    rush_count = 0;
                    count = 0;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "���ٽ�����");
                rush_count = 0;
                count = 0;
            }
        }
        else
        {
            rush_count = 0;
            count = 0;
        }
    }
    public void jButton1_actionPerformed(ActionEvent e)
    {
        Thread t = new Thread(this);
        t.start();
    }
    public void jButton2_actionPerformed(ActionEvent e)
    {
        count = rush[rush_count] + 1;
        paiduan = "flase";
    }
    class Tthread implements Runnable
    {
        @SuppressWarnings("unchecked")
        public void run()
        {
            boolean fo = true;
            int Y = 0, X = 0;
            JLabel show = new JLabel();
            show.setFont(new java.awt.Font("����", Font.PLAIN, 33));
            jPanel1.add(show);
            X = 10 + (int) (Math.random() * 400);
            String parameter = list[(int) (Math.random() * list.length)] + "";
            Bean bean = new Bean();
            bean.setParameter(parameter);
            bean.setShow(show);
            number.add(bean);
            show.setText(parameter);
            while(fo)
            {
                // ---------------------��������--------------------
                show.setBounds(new Rectangle(X, Y += 2, 33, 33));
                try
                {
                    Thread.sleep(rapidity);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                if (Y >= 419)
                {
                    fo = false;
                    for (int i = number.size() - 1; i >= 0; i--)
                    {
                        Bean bn = ((Bean) number.get(i));
                        if (parameter.equalsIgnoreCase(bn.getParameter()))
                        {
                            cuowu += 1;
                            jLabel2.setText("��ȷ:" + zhengque + "��,����:" + cuowu + "��");
                            number.removeElementAt(i);
                            break;
                        }
                    }
                }
            }
        }
    }
    class MyListener extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            String uu = e.getKeyChar() + "";
            for (int i = 0; i < number.size(); i++)
            {
                Bean bean = ((Bean) number.get(i));
                if (uu.equalsIgnoreCase(bean.getParameter()))
                {
                    zhengque += 1;
                    number.removeElementAt(i);
                    bean.getShow().setVisible(false);
                    jLabel2.setText("��ȷ:" + zhengque + "��,ʧ��:" + cuowu + "��");
                    break;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        Frame2 frame = new Frame2();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height)
        {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width)
        {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2,(screenSize.height - frameSize.height) / 2);
        frame.setVisible(true);
    }
}
class Frame1_jButton2_actionAdapter implements ActionListener
{
    private Frame2 adaptee;
    Frame1_jButton2_actionAdapter(Frame2 adaptee)
    {
        this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e)
    {
        adaptee.jButton2_actionPerformed(e);
    }
}
class Frame1_jButton1_actionAdapter implements ActionListener
{
    private Frame2 adaptee;
    Frame1_jButton1_actionAdapter(Frame2 adaptee)
    {
        this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e)
    {
        adaptee.jButton1_actionPerformed(e);
    }
}
class Bean
{
    String parameter = null;
    JLabel show = null;
    public JLabel getShow()
    {
        return show;
    }
    public void setShow(JLabel show)
    {
        this.show = show;
    }
    public String getParameter()
    {
        return parameter;
    }
    public void setParameter(String parameter)
    {
        this.parameter = parameter;
    }
}