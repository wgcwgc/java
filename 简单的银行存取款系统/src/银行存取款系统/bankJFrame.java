package ���д�ȡ��ϵͳ;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class bankJFrame extends JFrame implements ActionListener{
		private JButton button_cunkuan,button_qukuan,button_yue,button_lixi,jb_denglu;//�����ȡ���ѯ��ť
		private double balance;//��Ա����--�鿴���
		private double rlixi;
		public bankJFrame()
		{
			super("���д�ȡ�����ϵͳ");
			setBounds(300, 240, 250, 300);
			setResizable(false);
			setLayout(new FlowLayout(FlowLayout.LEFT,15,30));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			 
//			add(new JLabel("          AYIT���мƿ�֧�л�ӭ��������"));
			add(new JLabel("���ţ�"));
			add(new JTextField(15));
			add(new JLabel("���룺"));
			add(new JTextField(15));
			add(new JLabel("                     "));
			JButton jb_denglu = new JButton("��¼");
			add(jb_denglu);
			
			jb_denglu.addActionListener(this);
			setVisible(true);
		}
		//ȡ�����������Ϊȡ�������ʵ��ȡ�����
		public double get(){
			String password=JOptionPane.showInputDialog(this,"������ȡ����");
			double qukuanzhi=Integer.parseInt(password);
			if (qukuanzhi>0)
	        {
	           if (qukuanzhi<=this.balance)
	               this.balance-= qukuanzhi;            //ȡ�����ʹ���ֵ����
	           else                                  //�˻�������ȡʱ
	           {
	        	   qukuanzhi = this.balance+rlixi;             //ȡ��ȫ�����
	               this.balance = 0;
	               JOptionPane.showMessageDialog(this,"�������㣬��Ϊ��ȡ��ȫ����");
	           }
	           return qukuanzhi;                         //����ʵ��ȡ���
	        }
	        return 0;
	    }
		//�鿴�˻����
		public double balance(){
	        return balance+rlixi; 
	    }
		
		
		public void denglu(){
			System.out.println("111111111111111111");
			getContentPane().removeAll();
			this.setBounds(300, 240, 350, 400);
			this.setResizable(false);
			
			JPanel panel2=new JPanel();
			
//			this.setLayout(new FlowLayout(FlowLayout.LEFT,15,30));
//			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			panel2.setLayout(new GridLayout(5,1,5,20));
			getContentPane().add(panel2,"North");//��岼�ּ��������������
			
			button_cunkuan=new JButton("���");//��ť
			panel2.add(button_cunkuan);
			button_cunkuan.addActionListener(this);
			
			button_qukuan=new JButton("ȡ��");//ȡ�ť
			panel2.add(button_qukuan);
			button_qukuan.addActionListener(this);
			
			button_yue=new JButton("��ѯ��ǰ���");//��ѯ��ǰ��ť
			panel2.add(button_yue);
			button_yue.addActionListener(this);
			
			button_lixi=new JButton("��ǰ��Ϣ");//��ǰ��Ϣ��ť
			panel2.add(button_lixi);
			button_lixi.addActionListener(this);
			
//			setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			//������¼��ť
			if(e.getSource()==jb_denglu){
				denglu();
			}
		}
	}
