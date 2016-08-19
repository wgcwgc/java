package lamp.GUI.Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ToolKitDemo extends Frame
{

	public ToolKitDemo()
	{
		this.setTitle("ToolKit������");//����
		this.setSize(600, 400);//��С
		this.setBackground(Color.BLUE);//������ɫ
//		this.setResizable(false);//���ɸı��С
		this.setLayout(new FlowLayout());
		
		/**
		 * ���ô������
		 */
		//��ȡ���߶���
		Toolkit tool = Toolkit.getDefaultToolkit();
		//��ȡ��ǰ��Ļ�ĳߴ�
		Dimension d = tool.getScreenSize();
		//��ȡ��Ļ�Ŀ��
		double h = d.getHeight();
		double w = d.getWidth();
		
		int x = (int) ( h - 600 ) / 2;
		int y = (int) ( w - 400 ) / 2;
		
		this.setLocation(x, y);//λ��
//		this.setVisible(true);
		/**
		 * ���ô����ͼ��
		 */
		java.net.URL url = this.getClass().getClassLoader().getResource("lampImage/Java.jpg");
		Image image = tool.getImage(url);
		this.setIconImage(image);
		
		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		new ToolKitDemo();

	}

}
