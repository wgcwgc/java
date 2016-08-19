
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
	public double balance , yuer ,  cunkuanzhi;//��Ա����--�鿴��Ϣ  , ��� , ���ֵ��
	JTextField text_cunkuanshu,text_huoqi;//���������ڴ����ݵ�����
	JLabel jlabel_huoqi,jlabel_dingqi;//�������ޱ�ǩ���������ޱ�ǩ
	JButton button_queding;//ȷ����ť
	JRadioButton radio_dingqi,radio_huoqi;//����ڵ�ѡ��ť
	@SuppressWarnings("rawtypes")
	JComboBox box_dingqi;//���������Ͽ�
	double dnianfen;//�ڲ���Ա����������ݵ�����
	public String zhanghao;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	//������ý�������
	MessageJDialog(String dingqis[] , String zhanghao)
	{
		super("����");
		this.setBounds(350,290,300,220);
		this.zhanghao = zhanghao;
		this.balance = 0;
		
		//�����
		JPanel panel1=new JPanel();
		panel1.add(new JLabel("������������Ԫ����"));
		panel1.add(text_cunkuanshu=new JTextField("100",7));
		text_cunkuanshu.addActionListener(this);
		this.getContentPane().add(panel1);
		JPanel panel_rb=new JPanel(new GridLayout(1,2));
		panel1.add(panel_rb);
		this.setVisible(true);
		
		ButtonGroup bgroup=new ButtonGroup();
		
		//���ڴ�ѡ��ť
		radio_dingqi=new JRadioButton("���ڴ��");
		bgroup.add(radio_dingqi);
		panel_rb.add(radio_dingqi);
		radio_dingqi.addActionListener(this);
		
		//���ڴ�ѡ��ť
		radio_huoqi=new JRadioButton("���ڴ��");
		bgroup.add(radio_huoqi);
		panel_rb.add(radio_huoqi);
		this.setVisible(true);
		radio_huoqi.addActionListener(this);
		
		JPanel panel_rm=new JPanel();
		panel1.add(panel_rm);
		
		//���ڴ������
		panel_rm.add(jlabel_dingqi=new JLabel("��ѡ���ڴ�����ޣ��꣩"));
		box_dingqi=new JComboBox(dingqis);
		box_dingqi.setEditable(true);
		box_dingqi.addActionListener(this);
		panel_rm.add(box_dingqi);
		this.setVisible(true);
		
		JPanel panel_rn=new JPanel();
		panel1.add(panel_rn);
		
		//���ڴ������
		panel_rn.add(jlabel_huoqi=new JLabel("��������ڴ�����ޣ��꣩��"));
		panel_rn.add(text_huoqi=new JTextField("1",7));
		
		button_queding=new JButton("ȷ��");
		panel1.add(button_queding);
		
		this.setVisible(true);
		
		button_queding.addActionListener(this);//ע���ı��༭�¼�������
		
	}

	 //���㶨�ڴ����Ϣ
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
	 
	 //���������Ϣ����
	 public double hlixi()
	 {
		    double hnianfen=Double.parseDouble((text_huoqi.getText()));
		    double a=cunkuanzhi;
			double c=hnianfen;
			double s=a*0.0035*c;
		    return s;
	 }
	 
	 	//�������ݿ�
		public static Connection getConnection()throws SQLException
		{
			Connection conn = null;
			
			try
			{
				
				//�������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_users_information","root","root");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			
			return conn;
		}
		
		//ƥ�����ݿ�����
		public double getyuer(String str1_zhanghao) throws SQLException
		{
			Connection conn = getConnection();//��ȡ�����ݿ�֮�������
			Statement st = conn.createStatement();//����Statement
			ResultSet rs = st.executeQuery("select * from user_information");//ִ��SQL���
			while(rs.next())
			{
				if(rs.getString(2).equals(str1_zhanghao))
					return rs.getDouble(4);
			}
			return 0;
		}
	 
	 //�����ڲ��Ի����൥���¼�������
	 public void actionPerformed(ActionEvent e)
	 {
		 	cunkuanzhi=Double.parseDouble(text_cunkuanshu.getText());
		 	balance = cunkuanzhi;
		 	
		 	if(e.getSource()==box_dingqi)//������Ͽ��ѡ��
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
		 	
		 	//���ڵ�ѡ��ťѡ��
			if(radio_dingqi.isSelected())
			{
			   text_huoqi.setVisible(false);
			   jlabel_huoqi.setVisible(false);
			   jlabel_dingqi.setVisible(true);
				box_dingqi.setVisible(true);
				balance += dlixi();
				yuer += balance;
			}
			
			//���ڵ�ѡ��ťѡ��
			else if(radio_huoqi.isSelected())
			{
				jlabel_dingqi.setVisible(false);
				box_dingqi.setVisible(false);
				text_huoqi.setVisible(true);
				jlabel_huoqi.setVisible(true);
				balance += hlixi();
				yuer += balance;
			}
			
			//����ȷ����ť
			if(e.getSource()==button_queding)
			{
				//������ı����ַ���ǿ��ת��˫������
				cunkuanzhi=Double.parseDouble(text_cunkuanshu.getText());
                JOptionPane.showMessageDialog(this,"���"+cunkuanzhi+"�ɹ���");
                Connection conn = null;
				try
				{
					conn = getConnection();
				}
				catch (SQLException e3)
				{
					e3.printStackTrace();
				}
				
				//��ȡ�����ݿ�֮�������
    			Statement st = null;
				try
				{
					st = conn.createStatement();
				}
				catch (SQLException e2)
				{
					e2.printStackTrace();
				}
				
				//����Statement
                try
                {
					st.executeUpdate("update user_information set user_income = " + yuer + " where user_name = '"+ zhanghao + "'");//����
				}
                catch (SQLException e1)
                {
					e1.printStackTrace();
				}
                
			}
			
		}
	 
}

