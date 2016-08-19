package lamp.GUI.Frame;
/**
 * @author Jeff
 * 窗体类
 */
import java.awt.Color;
import java.awt.Frame;

public class FrameDemo
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		f.setTitle("我的第一个GUI程序");//标题
		f.setSize(300, 200);//大小
		f.setBackground(Color.BLUE);//背景颜色
		f.setResizable(false);//不可改变大小
		f.setLocation(300, 300);//位置
		f.setVisible(true);//显示
	}

}
