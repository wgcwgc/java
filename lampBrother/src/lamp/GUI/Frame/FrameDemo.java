package lamp.GUI.Frame;
/**
 * @author Jeff
 * ������
 */
import java.awt.Color;
import java.awt.Frame;

public class FrameDemo
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		f.setTitle("�ҵĵ�һ��GUI����");//����
		f.setSize(300, 200);//��С
		f.setBackground(Color.BLUE);//������ɫ
		f.setResizable(false);//���ɸı��С
		f.setLocation(300, 300);//λ��
		f.setVisible(true);//��ʾ
	}

}
