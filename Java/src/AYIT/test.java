package AYIT;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
@SuppressWarnings("serial")
public class test extends JFrame {
	public JPanel info = new JPanel();
	public JLabel jlNum = new JLabel("打破的气球个数：");
	public JTextField jtNum = new JTextField(5);
	public JLabel jlIntegrated = new JLabel("没打破的气球：");
	public JTextField jtIntegrated = new JTextField(5);
	public MyPanel myPanel;
	public int num = 0;
	public static void main(String[] args) {
		test t = new test();
		t.setSize(600, 500);
		t.setLocationRelativeTo(null);
		t.setVisible(true);
	}
	// 类Test的默认构造函数
	public test() {
		//加载布局管理器
		setLayout(new BorderLayout());
		//设置我们自己设计的容器
		myPanel = new MyPanel(this);
		//这个是设置显示打破气球数的位置和颜色和初值是0
		jtNum.setHorizontalAlignment(JTextField.RIGHT);
		jtNum.setForeground(Color.red);
		setJtNum(0);
		//这个是设置显示失去气球数的位置和颜色和初值是0
		jtIntegrated.setHorizontalAlignment(JTextField.RIGHT);
		jtIntegrated.setForeground(Color.red);
		setJtIntegrated(0);
		info.add(jlNum);
		info.add(jtNum);
		info.add(jlIntegrated);
		info.add(jtIntegrated);
		add(info, BorderLayout.SOUTH);
		add(myPanel, BorderLayout.CENTER);
		// myPanel.init();
	}
	public void setJtNum(int num) {
		jtNum.setText(num + "个");
	}
	public void setJtIntegrated(int num) {
		jtIntegrated.setText(num + "个");
	}
}
@SuppressWarnings("serial")
class MyPanel extends JPanel {
	public javax.swing.Timer timer = new javax.swing.Timer(50,
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					repaint();
				}
			});
	public Vector<Battlet> shell = new Vector<Battlet>();
	public test father = null;
	public int num = 0;
	public int integrated = 0;
	public Point pA = new Point();
	public Point pB = new Point();
	public Point pC = new Point();
	public Point pMouse = new Point();
	public boolean first = true;
	public int len = 0;
	public Balloon balloon = new Balloon();
	public MyPanel(test t) {
		timer.start();
		num = 0;
		integrated = 0;
		father = t;
		len = 50;
		this.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent arg0) {}
			public void mouseMoved(MouseEvent arg0) {
				pMouse = arg0.getPoint();
				// 确定pB
				double tempLen = Math.sqrt((pMouse.x - pA.x)
						* (pMouse.x - pA.x) + (pMouse.y - pA.y)
						* (pMouse.y - pA.y));
				pB.x = (int) (pA.x + (len / tempLen) * (pMouse.x - pA.x));
				pB.y = (int) (pA.y + (len / tempLen) * (pMouse.y - pA.y));
			}
		});
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {
				pMouse = arg0.getPoint();
				// 确定pB
				double tempLen = Math.sqrt((pMouse.x - pA.x)
						* (pMouse.x - pA.x) + (pMouse.y - pA.y)
						* (pMouse.y - pA.y));
				pB.x = (int) (pA.x + (len / tempLen) * (pMouse.x - pA.x));
				pB.y = (int) (pA.y + (len / tempLen) * (pMouse.y - pA.y));
				// 确定pC
				pC.x = (int) (pA.x + (500 / tempLen) * (pMouse.x - pA.x));
				pC.y = (int) (pA.y + (500 / tempLen) * (pMouse.y - pA.y));
				;
				fire();
			}
			public void mouseReleased(MouseEvent arg0) {
			}
		});
	}
	/*
	 * public void init() { pA.y = getHeight(); pA.x = getWidth() / 2;
	 * 
	 * pB.x = pA.x; pB.y = pA.y - 20; System.out.println("********"+ pA.x+" "
	 * +pA.y+"  "+pB.x+"  "+pB.y); repaint(); }
	 */
	public void paint(Graphics g) {
		// 设置枪筒初始化的方向
		if (first == true) {
			pA.y = getHeight();
			pA.x = getWidth() / 2;

			pB.x = pA.x;
			pB.y = pA.y - 50;
			first = false;
		}
		// 绘制背景
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// 绘制枪筒
		g.setColor(Color.WHITE);
		g.drawLine(pA.x, pA.y, pB.x, pB.y);
		// 绘制子弹
		g.setColor(Color.YELLOW);
		int i;
		Battlet b;
		for (i = 0; i < shell.size(); i++) {
			b = shell.get(i);
			g.drawLine(b.start.x, b.start.y, b.end.x, b.end.y);
		}
		shell.clear(); // 将所有的子弹都移除
		// 绘制气球
		g.setColor(Color.lightGray);
		if (balloon.isLive) {
			g.fillOval(balloon.base.x, balloon.base.y, balloon.radius,
					balloon.radius);
			if (balloon.base.y > 0) {
				balloon.base.y -= 2;
				balloon.C.y -= 2;
			} else {
				num++;
				father.setJtIntegrated(num);
				balloon.isLive = false;
			}
		} else {
			g.fillArc(balloon.base.x, balloon.base.y, balloon.radius,
					balloon.radius, 0, 15);
			g.fillArc(balloon.base.x, balloon.base.y, balloon.radius,
					balloon.radius, 90, 15);
			g.fillArc(balloon.base.x, balloon.base.y, balloon.radius,
					balloon.radius, 180, 15);
			g.fillArc(balloon.base.x, balloon.base.y, balloon.radius,
					balloon.radius, 270, 15);
			balloon.setIsLive(true);
			buildBalloon();
		}
	}
	private boolean isHited(Battlet b) {
		int A = pB.y - pA.y;
		int B = pA.x - pB.x;
		int C = pB.x * pA.y - pB.y * pA.x;
		int distance = (int) (Math.abs(A * balloon.C.x + B * balloon.C.y + C) / (Math.sqrt(A * A + B * B)));
		if (balloon.radius > distance) {
			father.num++;
			father.setJtNum(father.num);
			balloon.isLive = false;
			return true;
		}
		return false;
	}
	private void buildBalloon() {
		balloon.setBase(new Point((int) (Math.random() * (getWidth() - 20)),
				(int) (Math.random() * (getHeight() - 20))));
	}
	public void fire() {
		Battlet b = new Battlet(pB, pC);
		isHited(b);
		shell.add(b);
	}
}
class Battlet {
	public Point end;
	public Point start;
	public Battlet(Point pS, Point pE) {
		start = pS;
		end = pE;
	}
}
class Balloon {
	public boolean isLive;
	public Point C = new Point();
	public int radius;
	public Point base = new Point();
	public Balloon() {
		radius = 20;
		setBase(new Point(250, 110));
		isLive = true;
	}
	public void setBase(Point p) {
		base = p;
		C.x = base.x + radius;
		C.y = base.y + radius;
	}
	public void setIsLive(boolean b) {
		isLive = b;
	}
}
