package lamp.GUI.Frame;
/**
 * @author Jeff
 * �Զ��崰��
 */
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

@SuppressWarnings("serial")
public class MyFrame extends Frame
{
	public MyFrame()
	{
		this.setTitle("�ҵĵ�һ��GUI����");//����
		this.setSize(300, 200);//��С
		this.setBackground(Color.BLUE);//������ɫ
		this.setResizable(false);//���ɸı��С
		this.setLocation(300, 300);//λ��
		this.setLayout(new FlowLayout());
//		this.setVisible(true);//��ʾ
		
		//�ڴ�������Ӱ�ť
		Button b1 = new Button("����һ��");
		this.add(b1);
		
		this.add(new Button("��һ��"));
		this.add(new Button("һ��"));
		this.add(new Button("��"));
		
		Button b2 = new Button("�Ͳ���");
		this.add(b2);
		
		this.add(new Button("����"));
		this.add(new Button("��"));
		
		this.setVisible(true);
	}
	
	public static void main(String [] args)
	{
		new MyFrame();
	}

}
