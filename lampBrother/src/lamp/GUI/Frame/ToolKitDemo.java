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
		this.setTitle("ToolKit工具类");//标题
		this.setSize(600, 400);//大小
		this.setBackground(Color.BLUE);//背景颜色
//		this.setResizable(false);//不可改变大小
		this.setLayout(new FlowLayout());
		
		/**
		 * 设置窗体居中
		 */
		//获取工具对象
		Toolkit tool = Toolkit.getDefaultToolkit();
		//获取当前屏幕的尺寸
		Dimension d = tool.getScreenSize();
		//获取屏幕的宽高
		double h = d.getHeight();
		double w = d.getWidth();
		
		int x = (int) ( h - 600 ) / 2;
		int y = (int) ( w - 400 ) / 2;
		
		this.setLocation(x, y);//位置
//		this.setVisible(true);
		/**
		 * 设置窗体的图标
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
