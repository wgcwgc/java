package 银行存取款系统;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class bankJFrame extends JFrame implements ActionListener{
		private JButton button_cunkuan,button_qukuan,button_yue,button_lixi,jb_denglu;//定义存款，取款，查询余额按钮
		private double balance;//成员变量--查看余额
		private double rlixi;
		public bankJFrame()
		{
			super("银行存取款管理系统");
			setBounds(300, 240, 250, 300);
			setResizable(false);
			setLayout(new FlowLayout(FlowLayout.LEFT,15,30));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			 
//			add(new JLabel("          AYIT银行计科支行欢迎您！！！"));
			add(new JLabel("卡号："));
			add(new JTextField(15));
			add(new JLabel("密码："));
			add(new JTextField(15));
			add(new JLabel("                     "));
			JButton jb_denglu = new JButton("登录");
			add(jb_denglu);
			
			jb_denglu.addActionListener(this);
			setVisible(true);
		}
		//取款操作，参数为取款金额，返回实际取到金额
		public double get(){
			String password=JOptionPane.showInputDialog(this,"请输入取款数");
			double qukuanzhi=Integer.parseInt(password);
			if (qukuanzhi>0)
	        {
	           if (qukuanzhi<=this.balance)
	               this.balance-= qukuanzhi;            //取款操作使余额值减少
	           else                                  //账户余额不够所取时
	           {
	        	   qukuanzhi = this.balance+rlixi;             //取走全部余额
	               this.balance = 0;
	               JOptionPane.showMessageDialog(this,"您的余额不足，已为您取出全部余额！");
	           }
	           return qukuanzhi;                         //返回实际取款额
	        }
	        return 0;
	    }
		//查看账户余额
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
			getContentPane().add(panel2,"North");//面板布局及添加面板至主面板
			
			button_cunkuan=new JButton("存款");//存款按钮
			panel2.add(button_cunkuan);
			button_cunkuan.addActionListener(this);
			
			button_qukuan=new JButton("取款");//取款按钮
			panel2.add(button_qukuan);
			button_qukuan.addActionListener(this);
			
			button_yue=new JButton("查询当前余额");//查询当前余额按钮
			panel2.add(button_yue);
			button_yue.addActionListener(this);
			
			button_lixi=new JButton("当前利息");//当前利息按钮
			panel2.add(button_lixi);
			button_lixi.addActionListener(this);
			
//			setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			//单击登录按钮
			if(e.getSource()==jb_denglu){
				denglu();
			}
		}
	}
