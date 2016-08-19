package 银行存取款系统;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private double balance;//成员变量--查看余额
	JTextField text_cunkuanshu,text_huoqi;//存款数与活期存款年份的输入
	JLabel jlabel_huoqi,jlabel_dingqi;//活期期限标签，定期期限标签
	JButton button_queding;//确定按钮
	JRadioButton radio_dingqi,radio_huoqi;//活、定期单选框
	@SuppressWarnings("rawtypes")
	JComboBox box_dingqi;//定期年份组合框
	double dnianfeng;//内部成员变量定期年份的声明
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	MessageJDialog(String dingqis[])
	{
		 
		super("提示");
		this.setBounds(350,290,300,220);
		
		JPanel panel1=new JPanel();
		panel1.add(new JLabel("请输入存款数（元）："));
		panel1.add(text_cunkuanshu=new JTextField("100",6));
		text_cunkuanshu.addActionListener(this);
		this.getContentPane().add(panel1);
		JPanel panel_rb=new JPanel(new GridLayout(1,2));
		panel1.add(panel_rb); 	
		this.setVisible(true);
		
		ButtonGroup bgroup=new ButtonGroup();
		
		radio_dingqi=new JRadioButton("定期存款");
		bgroup.add(radio_dingqi);
		panel_rb.add(radio_dingqi);
		radio_dingqi.addActionListener(this);
		
		radio_huoqi=new JRadioButton("活期存款");
		bgroup.add(radio_huoqi);
		panel_rb.add(radio_huoqi);
		this.setVisible(true);
		radio_huoqi.addActionListener(this);
		
		
		JPanel panel_rm=new JPanel();
		panel1.add(panel_rm);
		
		panel_rm.add(jlabel_dingqi=new JLabel("请选择定期期限（年）"));
		box_dingqi=new JComboBox(dingqis);
		box_dingqi.setEditable(true);
		box_dingqi.addActionListener(this);
		panel_rm.add(box_dingqi);
		this.setVisible(true);
		
		JPanel panel_rn=new JPanel();
		panel1.add(panel_rn);
		
		panel_rn.add(jlabel_huoqi=new JLabel("请输入活期期限（年）："));
		panel_rn.add(text_huoqi=new JTextField("1",7));
		
		button_queding=new JButton("确定");
		panel1.add(button_queding);
		
		this.setVisible(true);
		
		button_queding.addActionListener(this);//注册文本编辑事件监听器
		
	}
	 
	 
	public String str()//成员方法：获取文本框输入存款数字符串
		{
	         
		 String str=text_cunkuanshu.getText();
		 return str;
		 
		}
	 
	 
	 public double dlixi()//成员方法：计算定期利息
		{
		 
			double a=balance;
			double c=dnianfeng;
		   
			switch((int)(c*4)){
				case 1: return(a*0.0248*c); 
			    case 2: return(a*0.0264*c);
					       
				case 4: return(a*0.028*c);
					       
				case 8: return(a*0.0352*c);
					       
				case 12: return(a*0.04*c);
					     
				case 20: return(a*0.044*c);
					       
				default: return 0;
		}
}
	 
	 
	 public double hlixi()//成员方法：计算活期利息方法
	 {
		    double hnianfeng=Double.parseDouble((text_huoqi.getText()));
		    double a=balance;
			double c=hnianfeng;
			double s=a*0.004*c;
		    return s;
	 }
		
	 public void actionPerformed(ActionEvent e)//内部对话框类单击事件处理方法
		{
			
			
			if(radio_dingqi.isSelected())//定期单选框选中
			{
			   text_huoqi.setVisible(false);
			   jlabel_huoqi.setVisible(false);
			   jlabel_dingqi.setVisible(true);
				box_dingqi.setVisible(true);
				dlixi();
			}
			
			else if(radio_huoqi.isSelected())//活期单选框选中
			{
				jlabel_dingqi.setVisible(false);
				box_dingqi.setVisible(false);
				text_huoqi.setVisible(true);
				jlabel_huoqi.setVisible(true);
				hlixi();
				
			}
			if(e.getSource()==button_queding)//单击确定按钮
			{
				double cunkuanzhi=Integer.parseInt(text_cunkuanshu.getText());//存款数文本框字符串强制转换双精度型
	           
                if (cunkuanzhi>0)//存款操作
                {
                    balance+=cunkuanzhi; //存款操作使余额值增加
                }
				JOptionPane.showMessageDialog(this,"存款"+cunkuanzhi+"成功！");
				if(radio_dingqi.isSelected())
					dlixi();
				if(radio_huoqi.isSelected())
					hlixi();
				
				
			}//定期组合框的选择
			if(e.getSource()==box_dingqi){
				String nianfeng=(String) box_dingqi.getSelectedItem();
				dnianfeng=Double.parseDouble(nianfeng);
				
			}
				
		}
		
}