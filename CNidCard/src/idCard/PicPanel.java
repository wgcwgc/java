package idCard;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
* <p>Title: PicPanel</p>
* <p>Description: ����ͼ</p>
*/

@SuppressWarnings("serial")
class PicPanel extends JPanel{             
	PicPanel(){  
		paintJPanel jip1=new paintJPanel(true);
		setBackground(Color.white);
		setLayout(new GridLayout(1,4));
		add(jip1);
	}
}