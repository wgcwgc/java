package lamp.GUI.Frame;

/**
 * @author Jeff
 * ����� 
 * �������
 */
import java.awt.*;

@SuppressWarnings("serial")
public class PanelDemo extends Frame
{
	public PanelDemo()
	{
		this.setTitle("������");//����
		this.setSize(600, 400);//��С
		this.setBackground(Color.BLUE);//������ɫ
//		this.setResizable(false);//���ɸı��С
		this.setLocation(300, 300);//λ��
		this.setLayout(new FlowLayout());
		
		
		this.setVisible(true);
		this.addPanel();
	}

	//������
	public void addPanel()
	{
		//�������
		Panel p1 = new Panel();
		p1.setBackground(Color.yellow);
		p1.setLayout(new FlowLayout());
		p1.add(new Button("����һ��"));
		p1.add(new Button("����һ��"));
		p1.add(new Button("����һ��"));
		p1.add(new Button("����һ��"));
		this.add(p1);

		//�������
		Panel p2 = new Panel();
		p2.setBackground(Color.green);
//		p2.setLayout(new FlowLayout());
		p2.add(new Button("���һ��"));
		p2.add(new Button("���һ��"));
		p2.add(new Button("���һ��"));
		p2.add(new Button("���һ��"));
		this.add(p2);
	}

	public static void main(String[] args)
	{
		new PanelDemo();
	}

}
