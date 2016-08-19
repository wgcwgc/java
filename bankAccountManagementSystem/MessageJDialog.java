
package bankAccountManagementSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MessageJDialog extends JFrame implements ActionListener
{
	public double balance , yuer ,  cunkuanzhi;//成员变量--查看利息  , 余额 , 存款值。
	JTextField text_cunkuanshu,text_huoqi;//存款数与活期存款年份的输入
	JLabel jlabel_huoqi,jlabel_dingqi;//活期期限标签，定期期限标签
	JButton button_queding;//确定按钮
	JRadioButton radio_dingqi,radio_huoqi;//活、定期单选按钮
	@SuppressWarnings("rawtypes")
	JComboBox box_dingqi;//定期年份组合框
	double dnianfen;//内部成员变量定期年份的声明
	public String zhanghao;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	//存款配置界面的设计
	MessageJDialog(String dingqis[] , String zhanghao)
	{
		super("设置");
		this.setBounds(350,290,300,220);
		this.zhanghao = zhanghao;
		this.balance = 0;
		
		//存款数
		JPanel panel1=new JPanel();
		panel1.add(new JLabel("请输入存款数（元）："));
		panel1.add(text_cunkuanshu=new JTextField("100",7));
		text_cunkuanshu.addActionListener(this);
		this.getContentPane().add(panel1);
		JPanel panel_rb=new JPanel(new GridLayout(1,2));
		panel1.add(panel_rb);
		this.setVisible(true);
		
		ButtonGroup bgroup=new ButtonGroup();
		
		//定期存款单选按钮
		radio_dingqi=new JRadioButton("定期存款");
		bgroup.add(radio_dingqi);
		panel_rb.add(radio_dingqi);
		radio_dingqi.addActionListener(this);
		
		//活期存款单选按钮
		radio_huoqi=new JRadioButton("活期存款");
		bgroup.add(radio_huoqi);
		panel_rb.add(radio_huoqi);
		this.setVisible(true);
		radio_huoqi.addActionListener(this);
		
		JPanel panel_rm=new JPanel();
		panel1.add(panel_rm);
		
		//定期存款年限
		panel_rm.add(jlabel_dingqi=new JLabel("请选择定期存款期限（年）"));
		box_dingqi=new JComboBox(dingqis);
		box_dingqi.setEditable(true);
		box_dingqi.addActionListener(this);
		panel_rm.add(box_dingqi);
		this.setVisible(true);
		
		JPanel panel_rn=new JPanel();
		panel1.add(panel_rn);
		
		//活期存款年限
		panel_rn.add(jlabel_huoqi=new JLabel("请输入活期存款期限（年）："));
		panel_rn.add(text_huoqi=new JTextField("1",7));
		
		button_queding=new JButton("确定");
		panel1.add(button_queding);
		
		this.setVisible(true);
		
		button_queding.addActionListener(this);//注册文本编辑事件监听器
		
	}

	 //计算定期存款利息
	 public double dlixi()
	 {
			double a = cunkuanzhi , c = dnianfen;
			switch((int)(c*4))
			{
				case 1:   return (a * 0.0260 * c);
			    case 2:   return (a * 0.0280 * c);
				case 4:   return (a * 0.0300 * c);
				case 8:   return (a * 0.0350 * c);
				case 12:  return (a * 0.0400 * c);
				case 20:  return (a * 0.0425 * c);
				case 40:  return (a * 0.0500 * c);
				case 80:  return (a * 0.1000 * c);
				case 200: return (a * 0.2500 * c);
				case 400: return (a * 0.5000 * c);
				default:  return 0;
			}
			
	 }
	 
	 //计算活期利息方法
	 public double hlixi()
	 {
		    double hnianfen=Double.parseDouble((text_huoqi.getText()));
		    double a=cunkuanzhi;
			double c=hnianfen;
			double s=a*0.0035*c;
		    return s;
	 }
	 
	 	//连接数据库
		public static Connection getConnection()throws SQLException
		{
			Connection conn = null;
			
			try
			{
				
				//加载数据库驱动
				Class.forName("com.mysql.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_users_information","root","root");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			
			return conn;
		}
		
		//匹配数据库数据
		public double getyuer(String str1_zhanghao) throws SQLException
		{
			Connection conn = getConnection();//获取跟数据库之间的连接
			Statement st = conn.createStatement();//创建Statement
			ResultSet rs = st.executeQuery("select * from user_information");//执行SQL语句
			while(rs.next())
			{
				if(rs.getString(2).equals(str1_zhanghao))
					return rs.getDouble(4);
			}
			return 0;
		}
	 
	 //设置内部对话框类单击事件处理方法
	 public void actionPerformed(ActionEvent e)
	 {
		 	cunkuanzhi=Double.parseDouble(text_cunkuanshu.getText());
		 	balance = cunkuanzhi;
		 	
		 	if(e.getSource()==box_dingqi)//定期组合框的选择
			{
				String nianfen=(String) box_dingqi.getSelectedItem();
				dnianfen=Double.parseDouble(nianfen);
			}
		 	
		 	try
			{
				yuer = getyuer(zhanghao);
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		 	
		 	//定期单选按钮选中
			if(radio_dingqi.isSelected())
			{
			   text_huoqi.setVisible(false);
			   jlabel_huoqi.setVisible(false);
			   jlabel_dingqi.setVisible(true);
				box_dingqi.setVisible(true);
				balance += dlixi();
				yuer += balance;
			}
			
			//活期单选按钮选中
			else if(radio_huoqi.isSelected())
			{
				jlabel_dingqi.setVisible(false);
				box_dingqi.setVisible(false);
				text_huoqi.setVisible(true);
				jlabel_huoqi.setVisible(true);
				balance += hlixi();
				yuer += balance;
			}
			
			//单击确定按钮
			if(e.getSource()==button_queding)
			{
				//存款数文本框字符串强制转换双精度型
				cunkuanzhi=Double.parseDouble(text_cunkuanshu.getText());
                JOptionPane.showMessageDialog(this,"存款"+cunkuanzhi+"成功！");
                Connection conn = null;
				try
				{
					conn = getConnection();
				}
				catch (SQLException e3)
				{
					e3.printStackTrace();
				}
				
				//获取跟数据库之间的连接
    			Statement st = null;
				try
				{
					st = conn.createStatement();
				}
				catch (SQLException e2)
				{
					e2.printStackTrace();
				}
				
				//创建Statement
                try
                {
					st.executeUpdate("update user_information set user_income = " + yuer + " where user_name = '"+ zhanghao + "'");//更改
				}
                catch (SQLException e1)
                {
					e1.printStackTrace();
				}
                
			}
			
		}
	 
}

