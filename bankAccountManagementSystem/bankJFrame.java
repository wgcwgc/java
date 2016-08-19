
package bankAccountManagementSystem;

import java.awt.event.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.sql.*;

@SuppressWarnings("serial")
public class bankJFrame extends JFrame implements ActionListener
{
	public JButton jb_denglu;
	public JTextField jt_kahao;
	public JPasswordField jt_mima;
	public double cishu = 0;

	public bankJFrame()
	{
		//���������
		super("���д�ȡ�����ϵͳ");
		setBounds(300, 240, 250, 350);
		setResizable(false);
		setLayout(new FlowLayout(FlowLayout.LEFT,15,30));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new JLabel("          AYIT���мƿ�֧�л�ӭ��������"));
		
		JLabel jl_kahao = new JLabel("���ţ�");
		add(jl_kahao);
		jt_kahao = new JTextField(15);
		add(jt_kahao);
		
		JLabel jl_mima = new JLabel("���룺"); 
		add(jl_mima);
		jt_mima =new JPasswordField(15);
		add(jt_mima);

		add(new JLabel("                     "));
		JButton jb_denglu = new JButton("��¼");
		add(jb_denglu);
		jb_denglu.addActionListener(new Action());
		
		JButton jb_zhuce = new JButton("ע��");
		add(jb_zhuce);
		jb_zhuce.addActionListener(new Action2());
		
		add(new JLabel("                     "));
		JButton jb_wangjimima = new JButton("��������");
		add(jb_wangjimima);
		jb_wangjimima.addActionListener(new Action1());
		
		setVisible(true);
	}
	
	//�������ݿ�
	public static Connection getConnection()throws SQLException
	{
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//�������ݿ�����
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_users_information","root","root");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//ƥ�����ݿ�����
	public boolean judge(String str1_zhanghao,String str1_mima) throws SQLException
	{
		Connection conn = getConnection();//��ȡ�����ݿ�֮�������
		Statement st = conn.createStatement();//����Statement
		ResultSet rs = st.executeQuery("select * from user_information");//ִ��SQL���
		
		while(rs.next())
		{
			if(rs.getString(2).equals(str1_zhanghao) && rs.getString(3).equals(str1_mima))
				return true;
		}
		
		return false;
	}
	
	//��¼������ʵ��
	class Action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String str_zhanghao = jt_kahao.getText();
			@SuppressWarnings("deprecation")
			String str_mima = jt_mima.getText();

			try
			{
				if(judge(str_zhanghao,str_mima))
				{
					new bankJFrame2(str_zhanghao,str_mima);
				}
				else
				{
					cishu ++;
					if(cishu == 3)
					{
						JOptionPane.showMessageDialog(jt_kahao,"�����������3�Σ��˺���ʱ����24Сʱ������\n                     ^-^  ^-^  ^-^  ^-^");
						System.exit(0);
					}
					else
					{
						JOptionPane.showMessageDialog(jt_kahao,"�˺Ż���������󣡣���\n���������룡����");
					}
				}
			}
			catch (HeadlessException e1)
			{
				e1.printStackTrace();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		
	}
	
	//�������������ʵ��
	class Action1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String shuruzhanghao = JOptionPane.showInputDialog("�����������˺ţ�\n");
			
			try
			{
				if(judge1(shuruzhanghao) != " ")
					JOptionPane.showMessageDialog(null, "���������ǣ�" + judge1(shuruzhanghao));
				else
					JOptionPane.showMessageDialog(null, "�����˺�����������߲����ڣ�����");
			}
			catch (HeadlessException e1)
			{
				e1.printStackTrace();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		
		//�ж�ĳ�˺��Ƿ������ݿ���
		public String judge1(String shuruzhanghao) throws SQLException
		{
			Connection conn = getConnection();//��ȡ�����ݿ�֮�������
			Statement st = conn.createStatement();//����Statement
			ResultSet rs = st.executeQuery("select * from user_information");//ִ��SQL���
			while(rs.next())
			{
					if(rs.getString(2).equals(shuruzhanghao))
						return rs.getString(3);
			}
			return " ";
		}
		
	}
	
	//ע�������ʵ��
	class Action2 extends JFrame implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String shuruxinzhanghao = JOptionPane.showInputDialog("�����������˺ţ�\n");
			
				try
				{
					if(judge2(shuruxinzhanghao))
						JOptionPane.showMessageDialog(null, "�����˺��Ѿ����ڣ�����ֱ�ӵ�¼��\n����������룬���Ե�����������һأ�����");
					else
					{
						String shurumima = JOptionPane.showInputDialog("��������������\n");
						String querenmima = JOptionPane.showInputDialog("��ȷ����������\n");
						if(shurumima.equals(querenmima))
						{
							Connection conn = getConnection();//��ȡ�����ݿ�֮�������
							Statement st = conn.createStatement();//����Statement
//							ResultSet rs = st.executeQuery("select * from user_information");//ִ��SQL����ѯ
//							int a = st.executeUpdate("insert into user_information(user_name,user_password,user_income) values('xiaoming','mima',0)");//����
//							int a = st.executeUpdate("delete from user_information where user_id = 1");//ɾ��
//							int a = st.executeUpdate("update user_information set user_name = 'xiaoming' , user_income = 100 where user_id = 1");//����
							if(st.executeUpdate("insert into user_information(user_name,user_password,user_income)" + "values ('"  +  shuruxinzhanghao + "','" + querenmima + "',0)") == 1)
							{
								JOptionPane.showMessageDialog(null, "�����˺�ע��ɹ�������");
							}
						}
						else
							JOptionPane.showMessageDialog(null, "���벻ƥ�䣬������ע�ᣡ����");
					}
				}
				catch (HeadlessException | SQLException e1)
				{
					e1.printStackTrace();
				}
				
		}
		
		//�ж����ݿ����Ƿ��Ѿ���ĳ�˺�
		public boolean judge2(String shuruxinzhanghao) throws SQLException
		{
			Connection conn = getConnection();//��ȡ�����ݿ�֮�������
			Statement st = conn.createStatement();//����Statement
			ResultSet rs = st.executeQuery("select * from user_information");//ִ��SQL���
			
			while(rs.next())
			{
					if(rs.getString(2).equals(shuruxinzhanghao))
						return true;
			}
			
			return false;
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {}
	
}

