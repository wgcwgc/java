package idCard;

import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



/**
* <p>Title: paintJPanel</p>
* <p>Description: Í¼Æ¬Ãæ°å</p>
*/

@SuppressWarnings("serial")
class paintJPanel extends JPanel{
	ImageIcon icon;
	paintJPanel(boolean isRoll){
		URL u=null;  
		if(isRoll){
			u= getClass().getResource("/images/top.png");
		}
		icon=new ImageIcon(u);
	}
	 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(icon.getImage(), 0, 0,this);
	}
}