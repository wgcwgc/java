package ���д�ȡ��ϵͳ;

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
	private double balance;//��Ա����--�鿴���
	JTextField text_cunkuanshu,text_huoqi;//���������ڴ����ݵ�����
	JLabel jlabel_huoqi,jlabel_dingqi;//�������ޱ�ǩ���������ޱ�ǩ
	JButton button_queding;//ȷ����ť
	JRadioButton radio_dingqi,radio_huoqi;//����ڵ�ѡ��
	@SuppressWarnings("rawtypes")
	JComboBox box_dingqi;//���������Ͽ�
	double dnianfeng;//�ڲ���Ա����������ݵ�����
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	MessageJDialog(String dingqis[])
	{
		 
		super("��ʾ");
		this.setBounds(350,290,300,220);
		
		JPanel panel1=new JPanel();
		panel1.add(new JLabel("������������Ԫ����"));
		panel1.add(text_cunkuanshu=new JTextField("100",6));
		text_cunkuanshu.addActionListener(this);
		this.getContentPane().add(panel1);
		JPanel panel_rb=new JPanel(new GridLayout(1,2));
		panel1.add(panel_rb); 	
		this.setVisible(true);
		
		ButtonGroup bgroup=new ButtonGroup();
		
		radio_dingqi=new JRadioButton("���ڴ��");
		bgroup.add(radio_dingqi);
		panel_rb.add(radio_dingqi);
		radio_dingqi.addActionListener(this);
		
		radio_huoqi=new JRadioButton("���ڴ��");
		bgroup.add(radio_huoqi);
		panel_rb.add(radio_huoqi);
		this.setVisible(true);
		radio_huoqi.addActionListener(this);
		
		
		JPanel panel_rm=new JPanel();
		panel1.add(panel_rm);
		
		panel_rm.add(jlabel_dingqi=new JLabel("��ѡ�������ޣ��꣩"));
		box_dingqi=new JComboBox(dingqis);
		box_dingqi.setEditable(true);
		box_dingqi.addActionListener(this);
		panel_rm.add(box_dingqi);
		this.setVisible(true);
		
		JPanel panel_rn=new JPanel();
		panel1.add(panel_rn);
		
		panel_rn.add(jlabel_huoqi=new JLabel("������������ޣ��꣩��"));
		panel_rn.add(text_huoqi=new JTextField("1",7));
		
		button_queding=new JButton("ȷ��");
		panel1.add(button_queding);
		
		this.setVisible(true);
		
		button_queding.addActionListener(this);//ע���ı��༭�¼�������
		
	}
	 
	 
	public String str()//��Ա��������ȡ�ı������������ַ���
		{
	         
		 String str=text_cunkuanshu.getText();
		 return str;
		 
		}
	 
	 
	 public double dlixi()//��Ա���������㶨����Ϣ
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
	 
	 
	 public double hlixi()//��Ա���������������Ϣ����
	 {
		    double hnianfeng=Double.parseDouble((text_huoqi.getText()));
		    double a=balance;
			double c=hnianfeng;
			double s=a*0.004*c;
		    return s;
	 }
		
	 public void actionPerformed(ActionEvent e)//�ڲ��Ի����൥���¼�������
		{
			
			
			if(radio_dingqi.isSelected())//���ڵ�ѡ��ѡ��
			{
			   text_huoqi.setVisible(false);
			   jlabel_huoqi.setVisible(false);
			   jlabel_dingqi.setVisible(true);
				box_dingqi.setVisible(true);
				dlixi();
			}
			
			else if(radio_huoqi.isSelected())//���ڵ�ѡ��ѡ��
			{
				jlabel_dingqi.setVisible(false);
				box_dingqi.setVisible(false);
				text_huoqi.setVisible(true);
				jlabel_huoqi.setVisible(true);
				hlixi();
				
			}
			if(e.getSource()==button_queding)//����ȷ����ť
			{
				double cunkuanzhi=Integer.parseInt(text_cunkuanshu.getText());//������ı����ַ���ǿ��ת��˫������
	           
                if (cunkuanzhi>0)//������
                {
                    balance+=cunkuanzhi; //������ʹ���ֵ����
                }
				JOptionPane.showMessageDialog(this,"���"+cunkuanzhi+"�ɹ���");
				if(radio_dingqi.isSelected())
					dlixi();
				if(radio_huoqi.isSelected())
					hlixi();
				
				
			}//������Ͽ��ѡ��
			if(e.getSource()==box_dingqi){
				String nianfeng=(String) box_dingqi.getSelectedItem();
				dnianfeng=Double.parseDouble(nianfeng);
				
			}
				
		}
		
}