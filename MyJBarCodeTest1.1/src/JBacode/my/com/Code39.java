package JBacode.my.com;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Code39 {
	String num;
	char[] step_3 ;
	char[] num_char;
	BufferedImage image;
	String step_2;
	char temp;
	public void change(String m){
		num = m;
		@SuppressWarnings("unused")
		String[] num1 = null;
//		step_2 = "100101101101";
		step_2 = "000000000000";
		char [] step_1 = m.toCharArray();
		for(int i=1;i<=step_1.length;i++)
		{
			switch (step_1[i-1]) {
			case ('0'):
				step_2 =step_2+"101001101101";
				break;
			case ('1'):
				step_2 =step_2+"110100101011";
				break;
			case ('2'):
				step_2 =step_2+"101100101011";
				break;
			case ('3'):
				step_2 =step_2+"110110010101";
				break;
			case ('4'):
				step_2 =step_2+"101001101011";
				break;
			case ('5'):
				step_2 =step_2+"110100110101";
				break;
			case ('6'):
				step_2 =step_2+"101100110101";
				break;
			case ('7'):
				step_2 =step_2+"101001011011";
				break;
			case ('8'):
				step_2 =step_2+"110100101101";
				break;
			case ('9'):
				step_2 =step_2+"101100101101";
				break;
			case ('A'):
				step_2 =step_2+"110101001011";
				break;
			case ('B'):
				step_2 =step_2+"101101001011";
				break;
			case ('C'):
				step_2 =step_2+"110110100101";
				break;
			case ('D'):
				step_2 =step_2+"101011001011";
				break;
			case ('E'):
				step_2 =step_2+"110101100101";
				break;
			case ('F'):
				step_2 =step_2+"101101100101";
				break;
			case ('G'):
				step_2 =step_2+"101010011011";
				break;
			case ('H'):
				step_2 =step_2+"110101001101";
				break;
			case ('I'):
				step_2 =step_2+"101101001101";
				break;
			case ('J'):
				step_2 =step_2+"101011001101";
				break;
			case ('K'):
				step_2 =step_2+"110101010011";
				break;
			case ('L'):
				step_2 =step_2+"101101010011";
				break;
			case ('M'):
				step_2 =step_2+"110110101001";
				break;
			case ('N'):
				step_2 =step_2+"101011010011";
				break;
			case ('O'):
				step_2 =step_2+"110101101001";
				break;
			case ('P'):
				step_2 =step_2+"101101101001";
				break;
			case ('Q'):
				step_2 =step_2+"101010110011";
				break;
			case ('R'):
				step_2 =step_2+"110101011001";
				break;
			case ('S'):
				step_2 =step_2+"101101011001";
				break;
			case ('T'):
				step_2 =step_2+"101011011001";
				break;
			case ('U'):
				step_2 =step_2+"110010101011";
				break;
			case ('V'):
				step_2 =step_2+"100110101011";
				break;
			case ('W'):
				step_2 =step_2+"110011010101";
				break;
			case ('X'):
				step_2 =step_2+"100101101011";
				break;
			case ('Y'):
				step_2 =step_2+"110010110101";
				break;
			case ('Z'):
				step_2 =step_2+"100110110101";
				break;
			case ('-'):
				step_2 =step_2+"100101011011";
				break;
			case ('.'):
				step_2 =step_2+"110010101101";
				break;
			case (' '):
				step_2 =step_2+"100110101101";
				break;
			case ('$'):
				step_2 =step_2+"100100100101";
				break;
			case ('/'):
				step_2 =step_2+"100100101001";
				break;
			case ('+'):
				step_2 =step_2+"100101001001";
				break;
			case ('%'):
				step_2 =step_2+"101001001001";
				break;
			case ('*'):
				step_2 =step_2+"100101101101";
				break;

			default:
				break;
			}
		}
			step_2 =step_2+"100101101101";
		graphicsGeneration();			
		}
                

	
	
	public void createImage(String fileLocation) {
		try {
		FileOutputStream fos = new FileOutputStream(fileLocation);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
		encoder.encode(image);
		bos.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
}

	public void graphicsGeneration() {
	// TODO Auto-generated method stub
//	char[] num1 = mychange.mychange();
	int imageWidth = 200;//图片的宽度
	
	int imageHeight = 100;//图片的高度
	
	image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
	Graphics graphics = image.getGraphics();
	graphics.setColor(Color.WHITE);
	graphics.fillRect(0, 0, imageWidth, imageHeight);
	graphics.setColor(Color.BLACK);
	graphics.setFont(new Font("宋体", 20, 12));
	graphics.drawString("安阳工学院", 15,90);
	graphics.drawString(num, 80,90);
	step_3 = step_2.toCharArray();
	int m =1;
	((Graphics2D)graphics).setStroke((Stroke) new BasicStroke((float) m));
	for(int u=0;u<step_2.length();u+=1)
		{	
		if((u+1)%12==0){
			((Graphics2D)graphics).setColor(Color.black);
			((Graphics2D)graphics).drawLine(15+m, 5, 15+m, 75);
			m+=1;
			((Graphics2D)graphics).setStroke((Stroke) new BasicStroke((float) 2));
			((Graphics2D)graphics).setColor(Color.white);
			((Graphics2D)graphics).drawLine(15+m, 5, 15+m, 75);
				m+=2;
		}else{
			temp =step_3[u];
			if (temp=='1'){
				((Graphics2D)graphics).setColor(Color.black);
				((Graphics2D)graphics).drawLine(15+m, 5, 15+m, 75);
			}
			else{
				((Graphics2D)graphics).setColor(Color.white);
				((Graphics2D)graphics).drawLine(15+m, 5, 15+m, 75);
			}
			m+=1;
		}}
	//ImageIcon imageIcon = new ImageIcon(imgurl);
	//graphics.drawImage(imageIcon.getImage(), 230, 0, null);
	
	//改成这样:
	BufferedImage bimg = null;
	  try {
	   bimg = javax.imageio.ImageIO.read(new java.io.File("E:\\360data\\重要数据\\桌面\\1\\"+num+".jpg"));
	  } catch (Exception e) {}
	
	if(bimg!=null)
	graphics.drawImage(bimg, 230, 0, null);
	graphics.dispose();
	
	
	createImage("E:\\360data\\重要数据\\桌面\\1\\"+num+".jpeg");
}
}