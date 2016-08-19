package lamp.GUI.Frame;

/**
 * @author Jeff
 * 面板类 
 * 组件容器
 */
import java.awt.*;

@SuppressWarnings("serial")
public class PanelDemo extends Frame
{
	public PanelDemo()
	{
		this.setTitle("面板测试");//标题
		this.setSize(600, 400);//大小
		this.setBackground(Color.BLUE);//背景颜色
//		this.setResizable(false);//不可改变大小
		this.setLocation(300, 300);//位置
		this.setLayout(new FlowLayout());
		
		
		this.setVisible(true);
		this.addPanel();
	}

	//添加面板
	public void addPanel()
	{
		//创建面板
		Panel p1 = new Panel();
		p1.setBackground(Color.yellow);
		p1.setLayout(new FlowLayout());
		p1.add(new Button("单击一下"));
		p1.add(new Button("单击一下"));
		p1.add(new Button("单击一下"));
		p1.add(new Button("单击一下"));
		this.add(p1);

		//创建面板
		Panel p2 = new Panel();
		p2.setBackground(Color.green);
//		p2.setLayout(new FlowLayout());
		p2.add(new Button("点击一下"));
		p2.add(new Button("点击一下"));
		p2.add(new Button("点击一下"));
		p2.add(new Button("点击一下"));
		this.add(p2);
	}

	public static void main(String[] args)
	{
		new PanelDemo();
	}

}
