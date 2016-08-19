
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
	public JButton button_cunkuan,button_qukuan,button_yu_e,button_lixi;//,jb_denglu;//定义存款，取款，查询余额按钮
	public double balance,yuer;//成员变量--查看余额
	public double rlixi;
	public String str_zhanghao, str_mima;
	
	//副界面的设计
	public bankJFrame2(String str_zhanghao,String str_mima)
	{
		super("银行存取款管理系统");
		setBounds(300, 240, 250, 350);
		setResizable(false);
		setLayout(new GridLayout(5,1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new JLabel("          AYIT银行计科支行欢迎您！！！"));
		
		button_cunkuan=new JButton("存款");
		add(button_cunkuan);
		button_cunkuan.addActionListener(this);
		
		button_qukuan=new JButton("取款");
		add(button_qukuan);
		button_qukuan.addActionListener(this);
		
		button_yu_e=new JButton("查询当前余额");
		add(button_yu_e);
		button_yu_e.addActionListener(this);
		
		button_lixi=new JButton("当前利率");
		add(button_lixi);
		button_lixi.addActionListener(this);
		
		this.setVisible(true);
		
		this.str_zhanghao = str_zhanghao;
		this.str_mima = str_mima;
		
	}

	//取款时对数据库的操作
	public double get() throws SQLException
    {
		String qukuanshu=JOptionPane.showInputDialog(this,"请输入取款数");
		double qukuanzhi=Double.parseDouble(qukuanshu);
		Connection conn = bankJFrame.getConnection();//获取跟数据库之间的连接
		Statement st = conn.createStatement();//创建Statement
		ResultSet rs = st.executeQuery("select * from user_information");//执行SQL语句
		
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
               yuer -= qukuanzhi;            //取款操作使余额值减少
			st.executeUpdate("update user_information set user_income = " + yuer  + " where user_name = '" + str_zhanghao + "'");
               return qukuanzhi;
           }
           else
           {
			JOptionPane.showMessageDialog(this, "您的余额不足，请重新选择！！！");
           }
          
        }
		else
		{
			JOptionPane.showMessageDialog(this, "如果想要存款，请点击存款按钮！！！");
		}
		
        return 0;
    }
	
	//单击事件处理方法
	public void actionPerformed(ActionEvent e)
	{
		
		//单击存款按钮
		if(e.getSource()==button_cunkuan)
		{
			String dingqis[]={"0.25","0.5","1","2","3","5","10","20","50","100"};
			new MessageJDialog(dingqis , str_zhanghao);
		}
		
		//单击查询余额按钮
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
			
			//获取跟数据库之间的连接
			Statement st = null;
			try
			{
				st = conn.createStatement();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			
			//创建Statement
			ResultSet rs = null;
			try
			{
				rs = st.executeQuery("select * from user_information");
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			
			//执行SQL语句
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
			
			JOptionPane.showMessageDialog(this,"您的当前账户余额为： "+(yuer)+" 元.");
			
		}
		
		//单击取款按钮
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
				JOptionPane.showMessageDialog(this,"取款"+qk+"元成功！");
		}
		
		//单击计算利率按钮
		if(e.getSource()==button_lixi)
		{
			String nianfen=JOptionPane.showInputDialog(this,"请输入年数");
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
			
			JOptionPane.showMessageDialog(this , "目前  " + nianshu +  " 年的年利率为：" + rlixi + "元");
			
		}
		
	}
	
}

