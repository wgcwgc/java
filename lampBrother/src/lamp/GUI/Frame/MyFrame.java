package lamp.GUI.Frame;
/**
 * @author Jeff
 * 自定义窗体
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
		this.setTitle("我的第一个GUI程序");//标题
		this.setSize(300, 200);//大小
		this.setBackground(Color.BLUE);//背景颜色
		this.setResizable(false);//不可改变大小
		this.setLocation(300, 300);//位置
		this.setLayout(new FlowLayout());
//		this.setVisible(true);//显示
		
		//在窗体上添加按钮
		Button b1 = new Button("点我一下");
		this.add(b1);
		
		this.add(new Button("我一下"));
		this.add(new Button("一下"));
		this.add(new Button("下"));
		
		Button b2 = new Button("就不点");
		this.add(b2);
		
		this.add(new Button("不点"));
		this.add(new Button("点"));
		
		this.setVisible(true);
	}
	
	public static void main(String [] args)
	{
		new MyFrame();
	}

}
