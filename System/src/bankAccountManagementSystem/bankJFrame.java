
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
		//主界面设计
		super("银行存取款管理系统");
		setBounds(300, 240, 250, 350);
		setResizable(false);
		setLayout(new FlowLayout(FlowLayout.LEFT,15,30));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new JLabel("          AYIT银行计科支行欢迎您！！！"));
		
		JLabel jl_kahao = new JLabel("卡号：");
		add(jl_kahao);
		jt_kahao = new JTextField(15);
		add(jt_kahao);
		
		JLabel jl_mima = new JLabel("密码："); 
		add(jl_mima);
		jt_mima =new JPasswordField(15);
		add(jt_mima);

		add(new JLabel("                     "));
		JButton jb_denglu = new JButton("登录");
		add(jb_denglu);
		jb_denglu.addActionListener(new Action());
		
		JButton jb_zhuce = new JButton("注册");
		add(jb_zhuce);
		jb_zhuce.addActionListener(new Action2());
		
		add(new JLabel("                     "));
		JButton jb_wangjimima = new JButton("忘记密码");
		add(jb_wangjimima);
		jb_wangjimima.addActionListener(new Action1());
		
		setVisible(true);
	}
	
	//连接数据库
	public static Connection getConnection()throws SQLException
	{
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_users_information","root","root");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//匹配数据库数据
	public boolean judge(String str1_zhanghao,String str1_mima) throws SQLException
	{
		Connection conn = getConnection();//获取跟数据库之间的连接
		Statement st = conn.createStatement();//创建Statement
		ResultSet rs = st.executeQuery("select * from user_information");//执行SQL语句
		
		while(rs.next())
		{
			if(rs.getString(2).equals(str1_zhanghao) && rs.getString(3).equals(str1_mima))
				return true;
		}
		
		return false;
	}
	
	//登录监听器实现
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
						JOptionPane.showMessageDialog(jt_kahao,"密码输入错误3次，账号暂时冻结24小时！！！\n                     ^-^  ^-^  ^-^  ^-^");
						System.exit(0);
					}
					else
					{
						JOptionPane.showMessageDialog(jt_kahao,"账号或者密码错误！！！\n请重新输入！！！");
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
	
	//忘记密码监听器实现
	class Action1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String shuruzhanghao = JOptionPane.showInputDialog("请输入您的账号：\n");
			
			try
			{
				if(judge1(shuruzhanghao) != " ")
					JOptionPane.showMessageDialog(null, "您的密码是：" + judge1(shuruzhanghao));
				else
					JOptionPane.showMessageDialog(null, "您的账号输入有误或者不存在！！！");
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
		
		//判断某账号是否在数据库中
		public String judge1(String shuruzhanghao) throws SQLException
		{
			Connection conn = getConnection();//获取跟数据库之间的连接
			Statement st = conn.createStatement();//创建Statement
			ResultSet rs = st.executeQuery("select * from user_information");//执行SQL语句
			while(rs.next())
			{
					if(rs.getString(2).equals(shuruzhanghao))
						return rs.getString(3);
			}
			return " ";
		}
		
	}
	
	//注册监听器实现
	class Action2 extends JFrame implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String shuruxinzhanghao = JOptionPane.showInputDialog("请输入您的账号：\n");
			
				try
				{
					if(judge2(shuruxinzhanghao))
						JOptionPane.showMessageDialog(null, "您的账号已经存在，可以直接登录。\n如果忘记密码，可以点击忘记密码找回，，，");
					else
					{
						String shurumima = JOptionPane.showInputDialog("请输入您的密码\n");
						String querenmima = JOptionPane.showInputDialog("请确认您的密码\n");
						if(shurumima.equals(querenmima))
						{
							Connection conn = getConnection();//获取跟数据库之间的连接
							Statement st = conn.createStatement();//创建Statement
//							ResultSet rs = st.executeQuery("select * from user_information");//执行SQL语句查询
//							int a = st.executeUpdate("insert into user_information(user_name,user_password,user_income) values('xiaoming','mima',0)");//插入
//							int a = st.executeUpdate("delete from user_information where user_id = 1");//删除
//							int a = st.executeUpdate("update user_information set user_name = 'xiaoming' , user_income = 100 where user_id = 1");//更改
							if(st.executeUpdate("insert into user_information(user_name,user_password,user_income)" + "values ('"  +  shuruxinzhanghao + "','" + querenmima + "',0)") == 1)
							{
								JOptionPane.showMessageDialog(null, "您的账号注册成功！！！");
							}
						}
						else
							JOptionPane.showMessageDialog(null, "密码不匹配，请重新注册！！！");
					}
				}
				catch (HeadlessException | SQLException e1)
				{
					e1.printStackTrace();
				}
				
		}
		
		//判断数据库中是否已经有某账号
		public boolean judge2(String shuruxinzhanghao) throws SQLException
		{
			Connection conn = getConnection();//获取跟数据库之间的连接
			Statement st = conn.createStatement();//创建Statement
			ResultSet rs = st.executeQuery("select * from user_information");//执行SQL语句
			
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

