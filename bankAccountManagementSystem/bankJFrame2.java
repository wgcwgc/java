
package bankAccountManagementSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class bankJFrame2 extends JFrame implements ActionListener
{
	public JButton button_cunkuan,button_qukuan,button_yu_e,button_lixi;//,jb_denglu;//�����ȡ���ѯ��ť
	public double balance,yuer;//��Ա����--�鿴���
	public double rlixi;
	public String str_zhanghao, str_mima;
	
	//����������
	public bankJFrame2(String str_zhanghao,String str_mima)
	{
		super("���д�ȡ�����ϵͳ");
		setBounds(300, 240, 250, 350);
		setResizable(false);
		setLayout(new GridLayout(5,1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new JLabel("          AYIT���мƿ�֧�л�ӭ��������"));
		
		button_cunkuan=new JButton("���");
		add(button_cunkuan);
		button_cunkuan.addActionListener(this);
		
		button_qukuan=new JButton("ȡ��");
		add(button_qukuan);
		button_qukuan.addActionListener(this);
		
		button_yu_e=new JButton("��ѯ��ǰ���");
		add(button_yu_e);
		button_yu_e.addActionListener(this);
		
		button_lixi=new JButton("��ǰ����");
		add(button_lixi);
		button_lixi.addActionListener(this);
		
		this.setVisible(true);
		
		this.str_zhanghao = str_zhanghao;
		this.str_mima = str_mima;
		
	}

	//ȡ��ʱ�����ݿ�Ĳ���
	public double get() throws SQLException
    {
		String qukuanshu=JOptionPane.showInputDialog(this,"������ȡ����");
		double qukuanzhi=Double.parseDouble(qukuanshu);
		Connection conn = bankJFrame.getConnection();//��ȡ�����ݿ�֮�������
		Statement st = conn.createStatement();//����Statement
		ResultSet rs = st.executeQuery("select * from user_information");//ִ��SQL���
		
		while(rs.next())
		{
			if(rs.getString(2).equals(str_zhanghao))
			{
				yuer = rs.getDouble(4);
				break;
			}
		}
		
		if (qukuanzhi>0)
        {
           if (qukuanzhi <= yuer)
           {
               yuer -= qukuanzhi;            //ȡ�����ʹ���ֵ����
			st.executeUpdate("update user_information set user_income = " + yuer  + " where user_name = '" + str_zhanghao + "'");
               return qukuanzhi;
           }
           else
           {
			JOptionPane.showMessageDialog(this, "�������㣬������ѡ�񣡣���");
           }
          
        }
		else
		{
			JOptionPane.showMessageDialog(this, "�����Ҫ��������ť������");
		}
		
        return 0;
    }
	
	//�����¼�������
	public void actionPerformed(ActionEvent e)
	{
		
		//������ť
		if(e.getSource()==button_cunkuan)
		{
			String dingqis[]={"0.25","0.5","1","2","3","5","10","20","50","100"};
			new MessageJDialog(dingqis , str_zhanghao);
		}
		
		//������ѯ��ť
		if(e.getSource()==button_yu_e)
		{
			Connection conn = null;
			
			try
			{
				conn = bankJFrame.getConnection();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			
			//��ȡ�����ݿ�֮�������
			Statement st = null;
			try
			{
				st = conn.createStatement();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			
			//����Statement
			ResultSet rs = null;
			try
			{
				rs = st.executeQuery("select * from user_information");
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			
			//ִ��SQL���
			try
			{
				while(rs.next())
				{
					if(rs.getString(2).equals(str_zhanghao))
					{
						yuer = rs.getDouble(4);
						break;
					}
				}
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(this,"���ĵ�ǰ�˻����Ϊ�� "+(yuer)+" Ԫ.");
			
		}
		
		//����ȡ�ť
		if(e.getSource()==button_qukuan)
		{
			double qk = 0;
			try
			{
				qk = get();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			if(qk != 0)
				JOptionPane.showMessageDialog(this,"ȡ��"+qk+"Ԫ�ɹ���");
		}
		
		//�����������ʰ�ť
		if(e.getSource()==button_lixi)
		{
			String nianfen=JOptionPane.showInputDialog(this,"����������");
			double nianshu=Double.parseDouble(nianfen);
			if(nianshu < 0.25 && nianshu > 0)
				rlixi = 0.017;
			else if(nianshu >= 0.25 && nianshu < 0.5)
				rlixi = 0.026;
			else if(nianshu >= 0.5 && nianshu < 1)
				rlixi = 0.028;
			else if(nianshu >= 1 && nianshu < 2)
				rlixi = 0.03;
			else if(nianshu >= 2 && nianshu < 3)
				rlixi = 0.035;
			else if(nianshu >= 3 && nianshu < 5)
				rlixi = 0.04;
			else if(nianshu >= 5 && nianshu < 10)
				rlixi = 0.044;
			else if(nianshu >= 10 && nianshu < 100)
				rlixi = 0.057;
			else if(nianshu >= 100 && nianshu < 1000)
				rlixi = 0.077;
			else if(nianshu >= 1000 && nianshu < 10000)
				rlixi = 0.1;
			else if(nianshu >= 10000 && nianshu < 100000)
				rlixi = 0.57;
			else if(nianshu >= 100000 && nianshu < 1000000)
				rlixi = 0.77;
			else if(nianshu >= 1000000 && nianshu < 10000000)
				rlixi = 0.98;
			else if(nianshu >= 100000000)
				rlixi = 1.0000001;
			else rlixi = 0;
			
			JOptionPane.showMessageDialog(this , "Ŀǰ  " + nianshu +  " ���������Ϊ��" + rlixi + "Ԫ");
			
		}
		
	}
	
}

