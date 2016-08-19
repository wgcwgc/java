package idCard;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;


 /**
* <p>Title: 窗体设置</p>
* <p>Description: main方法入口</p>
* @author    DonG
* @date       2013-5-16
*/

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener{
	
	private JButton btn1 = new JButton("查询");
	private JButton btn2 = new JButton("查询");
	private JButton btn3 = new JButton("生成号码");
	private JButton clr1 = new JButton("复位");
	private JButton clr2 = new JButton("复位");
	private JTextField input1 = new JTextField();
	private JTextField input2 = new JTextField();
	private JTextField[] result = new JTextField[2];
	@SuppressWarnings("rawtypes")
	private JComboBox[] box= new JComboBox[6];
	private JLabel count,counter;
	private JLabel[] info = new JLabel[4];
	private JLabel[] infom = new JLabel[3];
	private int countInt = 0;
	private String countStr = Integer.toString(countInt);
	private String[] Sheng ={"","北京市","天津市","河北省","山西省","内蒙古自治区","辽宁省","吉林省","黑龙江省","上海市","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","广西壮族自治区","海南省","重庆市","四川省","贵州省","云南省","西藏自治区","陕西省","甘肃省","青海省","宁夏回族自治区","新疆维吾尔族自治区","台湾省","香港特别行政区","澳门特别行政区"};
	String path = this.getClass().getClassLoader().getResource("dataBase/Identity.mdb").getPath().substring(1);//数据库相对路径
	
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public Main(){
		super("身份证号码查询/生成器");
		Toolkit t=getToolkit();
		Dimension d=t.getScreenSize();
		setBounds(d.width/4,d.height/4,740,500);
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int x = 0;x<2;x++){
			result[x] = new JTextField();
			result[x].setEnabled(true);
		}
		for(int y = 0;y<6;y++){
			//box[y].setEditable(false);
			if(y == 0 || y ==3){
				box[y] = new JComboBox(Sheng);
				continue;
			}
				box[y] = new JComboBox();
		}
		//————————————————————————————
		JPanel p0 = new JPanel();
		p0.setLayout(new GridLayout(1,1,0,0));
		PicPanel pic = new PicPanel();
		p0.add(pic);
		p0.setBounds(5,5,725,50);
		add(p0);
		//————————————————————————————
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(7,1,5,5));
		p1.setBounds(5,60,230,150);
		p1.setBorder(BorderFactory.createTitledBorder("功能简述"));
		p1.add(new JLabel("①根据身份证号码查询"));
		p1.add(new JLabel("    ●查询户籍"));
		p1.add(new JLabel("    ●查询生日"));
		p1.add(new JLabel("    ●查询性别"));
		p1.add(new JLabel("    ●查询号码是否正确"));
		p1.add(new JLabel("②查询某市县对应的号码"));
		p1.add(new JLabel("③生成身份证号码"));
		add(p1);
		//————————————————————————————
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(250,60,480,225);
		p2.setBorder(BorderFactory.createTitledBorder("根据身份证号码查询"));
		JLabel j2 = new JLabel("请输入身份证号码：");
		j2.setBounds(10,10,130,35);
		p2.add(j2);
		input1.setBounds(140,15,300,30);
		input1.setDocument(new NumberLenghtLimitedDmt(18));
		p2.add(input1);
		btn1.setBounds(140,60,100,30);
		p2.add(btn1);
		count = new JLabel("已输入      位数");
		count.setBounds(280,60,150,35);
		p2.add(count);
		counter = new JLabel(countStr);
		counter.setForeground(Color.red);
		counter.setBounds(320,60,15,35);
		p2.add(counter);
		String[] str = {"户籍：","生日：","性别："};
		for(int i = 0;i<3;i++){
			info[i] = new JLabel(str[i]);
			info[i].setBounds(10,105+25*i,50,35);
			infom[i] = new JLabel();
			infom[i].setBounds(55,105+25*i,350,35);
			p2.add(info[i]);
			p2.add(infom[i]);
		}
		info[3] = new JLabel("请输入身份证号码进行查询");
		info[3].setBounds(10,105+25*3,400,35);
		p2.add(info[3]);
		add(p2);
		//————————————————————————————
		JPanel p3 = new JPanel();
		p3.setLayout(null);
		p3.setBounds(250,290,480,155);
		p3.setBorder(BorderFactory.createTitledBorder("生成身份证号码"));
		JLabel foo1 = new JLabel("请选择籍贯：");
		JLabel foo2 = new JLabel("省/自治区");
		JLabel foo3 = new JLabel("市");
		JLabel foo4 = new JLabel("区/县");
		foo1.setBounds(10,13,100,30);
		box[0].setBounds(10,40,82,28);
		foo2.setBounds(100,40,100,30);
		box[1].setBounds(160,40,100,28);
		foo3.setBounds(270,40,30,30);
		box[2].setBounds(288,40,120,28);
		foo4.setBounds(420,40,50,30);
		JLabel f0 = new JLabel("请输入出生年月日(格式 YYYYMMDD)：");
		f0.setBounds(10,75,220,30);
		input2.setBounds(235,78,115,28);
		btn3.setBounds(360,75,100,30);
		JLabel showNum0 = new JLabel("生成的身份证号码：");
		showNum0.setBounds(10,110,120,30);
		result[0].setBounds(150,110,200,30);
		clr1.setBounds(360,110,100,30);
		p3.add(f0);
		p3.add(input2);
		p3.add(showNum0);
		p3.add(foo1);
		p3.add(result[0]);
		p3.add(box[0]);
		p3.add(foo2);
		p3.add(box[1]);
		p3.add(foo3);
		p3.add(box[2]);
		p3.add(foo4);
		p3.add(btn3);
		p3.add(clr1);
		add(p3);
		//————————————————————————————
		JPanel p4 = new JPanel();
		p4.setLayout(null);
		p4.setBounds(5,215,230,230);
		p4.setBorder(BorderFactory.createTitledBorder("查询某市县对应号码"));
		
		JLabel[] fool = new JLabel[4];
		String[] foolstr = {"选择籍贯：","省/自治区","市","县/区"};
		for(int k = 0;k<4;k++){
			fool[k] = new JLabel(foolstr[k]);
		}
		fool[0].setBounds(10,10,80,30);
		box[3].setBounds(10,45,120,28);
		fool[1].setBounds(145,45,80,30);
		box[4].setBounds(10,80,120,28);
		fool[2].setBounds(145,80,50,30);
		box[5].setBounds(10,115,120,28);
		fool[3].setBounds(145,115,30,30);
		btn2.setBounds(88,150,60,30);
		clr2.setBounds(150,150,60,30);
		result[1].setBounds(10,185,200,30);
		JLabel showNum1 = new JLabel("前六位号码：");
		showNum1.setBounds(10,155,200,30);
		for(int z = 0;z<4;z++){
			p4.add(fool[z]);
		}
		p4.add(box[3]);
		p4.add(box[4]);
		p4.add(box[5]);
		p4.add(btn2);
		p4.add(clr2);
		p4.add(result[1]);
		p4.add(showNum1);
		add(p4);
		//————————————————————————————
		JPanel p5 = new JPanel();
		p5.setLayout(null);
		p5.setBounds(5,440,730,45);
		JLabel note = new JLabel(" @Author  王光春 ");
		note.setBounds(300,440,200,45);
		p5.add(note);
		add(p5);
		//————————————————————————————
		input1.addActionListener(this);
		input1.getDocument().addDocumentListener(textChangeListener);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		clr2.addActionListener(this);
		btn3.addActionListener(this);
		clr1.addActionListener(this);
		box[0].addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				Box0ItemStateChanged(evt);
			}
		});
		box[1].addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				Box1ItemStateChanged(evt);
			}
		});
		box[3].addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				Box3ItemStateChanged(evt);
			}
		});
		box[4].addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				Box4ItemStateChanged(evt);
			}
		});
		show();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1){//查询身份证号码
			fromNumber number = new fromNumber();
			number.numIn(input1.getText());
			switch(number.checkNumber()){
				case 0:{//已正确输入15位或者18位
					infom[0].setText(number.showArea());
					infom[1].setText(number.showBirthday());
					infom[2].setText(number.showSex());
					if(number.isCorrect()){
						info[3].setText("身份证号码："+number.newNumber+"      该身份证号码是合法的！");
					}
					else if(!number.isCorrect()){
						info[3].setText("身份证号码："+number.newNumber+"      该身份证号码不合法！");
					}
					input1.setText("");
					break;
				}
				case 1:{//号码输入错误
					JOptionPane.showMessageDialog(null, "请输入正确的15位或者18位身份证号码！","",2);//对话框
					input1.setText("");
					break;
				}
			}
		}
		else if(e.getSource() == btn2){//查询前6位
			
			String s1 = (String)box[3].getSelectedItem();
			String s2 = (String)box[4].getSelectedItem();
			String s3 = (String)box[5].getSelectedItem();
			String showNum = "";
			if(s1 == "" && s2 == "" & s3 ==""){
				
			}
			else{
				try{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path;
	 			  	Connection con = DriverManager.getConnection(url);
	 			  	Statement st = con.createStatement();
	 			  	String sql = ("select Code from Identity where Sheng = '"+s1+"' AND Shi = '"+s2+"' AND Xian = '"+s3+"'");
	 			  	ResultSet rs = st.executeQuery(sql);
	 			  	while(rs.next()){
	 			  		showNum = rs.getString("Code");
	 			  		Main.this.result[1].setText(showNum);
	 			  	}
	 			  	st.close();
	 			  	con.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		else if(e.getSource() == btn3){//生成身份证号码
			JOptionPane.showMessageDialog(null, "声明：此功能仅限于JAVA编程思想讨论及其使用，不可将所生成的身份证号码用于任何正规场所和互联网，一切后果由使用者自行承担\r\n\r\n使用身份证生成器的行为，涉嫌伪造、变造居民身份证，已经触犯《中华人民共和国居民身份证法》\r\n\r\n根据《刑法》第二百八十条 第三款规定：\r\n“伪造、变造居民身份证的，处三年以下有期徒刑、拘役、管制或者剥夺政治权利；情节严重的，处三年以上七年以下有期徒刑。” ","警告",2);
			String sheng = (String)box[0].getSelectedItem();
			String shi = (String)box[1].getSelectedItem();
			String xian = (String)box[2].getSelectedItem();
			String tempCode = "";
			String tempRan = "";
			String bir = input2.getText();
			result[0].setText("");
			
			Calendar rightnow = Calendar.getInstance();
			int nowY=rightnow.get(Calendar.YEAR);
			@SuppressWarnings("unused")
			int nowM=rightnow.get(Calendar.MONTH)+1;//月份为0序
			@SuppressWarnings("unused")
			int nowD=rightnow.get(Calendar.DATE);
			int bornY,bornM,bornD;
			String bornyear = "";
		    String bornmonth ="";
		    String bornday ="";
			for(int y =0;y<4;y++){
				bornyear += bir.charAt(y);
			}bornY = Integer.valueOf(bornyear);
			for(int m =4;m<6;m++){
				bornmonth += bir.charAt(m);
			}bornM = Integer.valueOf(bornmonth);
			for(int d =6;d<8;d++){
				bornday += bir.charAt(d);;
			}bornD = Integer.valueOf(bornday);
			
leap:	for(int time = 0;time<1;time++){
				if(bornY > nowY || bornM >= 13 || bornM < 1 || bornD < 1 || bornD >= 32 || (bornM == 4 && bornD >=31) || (bornM == 6 && bornD >=31) || (bornM == 9 && bornD >= 31) || (bornM == 11 && bornD >= 31) ||((bornY % 400 == 0 && bornY %4 == 0 && bornY % 100 != 0) && bornM == 2 && bornD >=30) || ((bornY % 400 != 0 || bornY %4 != 0 || bornY % 100 != 0) && bornM == 2 && bornD >=29)){
					JOptionPane.showMessageDialog(null, "请输入正确的出生日期！","",2);
					/* 复位 */
					for(int i = 1;i<3;i++){
						box[i].removeAllItems();
						result[0].setText("");
					}
					input2.setText("");
					box[0].setSelectedIndex(0);
					break leap;
				}
				JOptionPane.showMessageDialog(null, "正在生成身份证号码，可能需要一点时间，请稍等","",1);
				try{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path;
					Connection con = DriverManager.getConnection(url);
					Statement st = con.createStatement();
					String sql = ("select Code from Identity where Sheng = '"+sheng+"' AND Shi = '"+shi+"' AND Xian = '"+xian+"'");
					ResultSet rs = st.executeQuery(sql);
					while(rs.next()){
			  		tempCode = rs.getString("Code");
					}
					st.close();
					con.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				for(int z = 0;z<3;z++){	
					tempRan += Integer.toString((int)(10*Math.random()));//随机生成三个数存入身份证的倒数234位
				}
				String Q17 = tempCode+bir+tempRan;
				char[] tempNum = new char[20];
				for(int i =0;i<16;i++){
					tempNum[i] = Q17.charAt(i);
				}
				fromNumber tempRandom = new fromNumber();
				tempRandom.numIn(Q17);
				System.out.println(Q17+tempRandom.checkLastNumber());
				result[0].setText(Q17+tempRandom.checkLastNumber());
				
			}
		}
		else if(e.getSource() == clr1){
			for(int i = 1;i<3;i++){
				box[i].removeAllItems();
				result[0].setText("");
			}
			input2.setText("");
			box[0].setSelectedIndex(0);
		}
		else if(e.getSource() == clr2){
			for(int i = 4;i<6;i++){
				box[i].removeAllItems();
				result[1].setText("");
			}
			box[3].setSelectedIndex(0);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void Box0ItemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            String sheng = (String)box[0].getSelectedItem();
            Main.this.box[1].removeAllItems();
            try{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path;
	 			  	Connection con = DriverManager.getConnection(url);
	 			  	Statement st = con.createStatement();
	 			  	String sql = ("select Shi from AD where Sheng = '"+sheng+"'");
	 			  	ResultSet rs = st.executeQuery(sql);
	 			  	while(rs.next()){
	 			  		Main.this.box[1].addItem(rs.getString("Shi"));
	 			  	}
	 			  	st.close();
	 			  	con.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}
            Main.this.box[1].setSelectedItem("");
        }
	}
	
	@SuppressWarnings("unchecked")
	public void Box1ItemStateChanged(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			String sheng = (String)box[0].getSelectedItem();
			String shi =(String)box[1].getSelectedItem();
			Main.this.box[2].removeAllItems();
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path;
				Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				String sql = ("select Xian from Identity where Sheng = '"+sheng+"'"+" AND Shi = '"+shi+"'");
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					Main.this.box[2].addItem(rs.getString("Xian"));
				}
				st.close();
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			Main.this.box[2].setSelectedIndex(0);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void Box3ItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
			String sheng = (String)box[3].getSelectedItem();
			Main.this.box[4].removeAllItems();
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path;
				Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				String sql = ("select Shi from AD where Sheng = '"+sheng+"'");
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					Main.this.box[4].addItem(rs.getString("Shi"));
				}
				st.close();
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			Main.this.box[4].setSelectedItem("");
		}
	}
	 
	@SuppressWarnings("unchecked")
	public void Box4ItemStateChanged(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			String sheng = (String)box[3].getSelectedItem();
			String shi =(String)box[4].getSelectedItem();
			Main.this.box[5].removeAllItems();
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path;
				Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				String sql = ("select Xian from Identity where Sheng = '"+sheng+"'"+" AND Shi = '"+shi+"'");
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					Main.this.box[5].addItem(rs.getString("Xian"));
				}
				st.close();
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			Main.this.box[5].setSelectedIndex(0);
		}
	}
	
	DocumentListener textChangeListener=new DocumentListener() {
		protected void changeFilter(DocumentEvent event) {
			javax.swing.text.Document document = event.getDocument();
			try {
				String text=document.getText(0, document.getLength());  
				countInt = text.length();
				countStr = Integer.toString(countInt);

				Main.this.counter.setText(countStr);//要人命的匿名内嵌类。次奥。
						

			} catch (Exception ex) {
				                ex.printStackTrace();
				                System.err.println(ex);
			}
		}

		public void changedUpdate(DocumentEvent e) {
			changeFilter(e);
		}

		public void insertUpdate(DocumentEvent e) {
			changeFilter(e);
		}

		public void removeUpdate(DocumentEvent e) {
			changeFilter(e);
		}
	};
	
	public class NumberLenghtLimitedDmt extends PlainDocument {//限制输入身份证号码位数
		
		private int limit; 
		public NumberLenghtLimitedDmt(int limit) {
			super();
			this.limit = limit;
		} 
		public void insertString
		(int offset, String str, AttributeSet attr)
				throws BadLocationException {   
			if (str == null){
				return;
			}
			if ((getLength() + str.length()) <= limit) {
				char[] upper = str.toCharArray();
				int length=0;
				for (int i = 0; i < upper.length; i++) {     
					      
						upper[length++] = upper[i];
					
				}
				super.insertString(offset, new String(upper,0,length), attr);
			}
		}
	}
	
	public static void main(String[] args){
		new Main();
	}
}