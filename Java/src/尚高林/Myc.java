package 尚高林;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
public class Myc {
	@SuppressWarnings("serial")
	public static class JCalendar extends JPanel{
	  private int year=0, month=0, day=0;
	  private JPanel Main = new JPanel();
	  private JPanel jPanelDay = new JPanel();
	  private JPanel jPanelMonth = new JPanel();
	  private JTextField Year = new JTextField();
	  private JTextField Month = new JTextField();
	  private JButton MonthDown = new JButton();
	  private JButton MonthUp = new JButton();
	  private JPanel jPanelButton = new JPanel();
	  private JButton YearDown = new JButton();
	  private JButton YearUp = new JButton();
	  private JLabel Out = new JLabel();
	  private Locale l=Locale.CHINESE;
	  private GregorianCalendar cal=new GregorianCalendar(l);
	  private JPanel weekPanel=new JPanel();
	  private JToggleButton[] days=new JToggleButton[42];
	  private JPanel Days = new JPanel();
	  private JLabel jLabel1 = new JLabel();
	  private JLabel jLabel2 = new JLabel();
	  private JLabel jLabel3 = new JLabel();
	  private JLabel jLabel4 = new JLabel();
	  private JLabel jLabel5 = new JLabel();
	  private JLabel jLabel6 = new JLabel();
	  private JLabel jLabel7 = new JLabel();
	  @SuppressWarnings("unused")
	private JToggleButton cur=null;
	//月份天数数组，用来取的当月有多少天
	  private int[] ts={31,28,31,30,31,30,31,31,30,31,30,31};

	//3，调用构造函数，初始化组件，添加并设置面板和按钮，并为他们添加监听器，设置网格布局等。

	//空日期构造函数
	  public JCalendar() {
	    try {jbInit();}
	    catch(Exception e) {e.printStackTrace();}
	}
	//带日期设置的构造函数
	  public JCalendar(int year, int month, int day) {
	    cal.set(year, month, day);
	    try {jbInit();}
	    catch (Exception e) {e.printStackTrace();}
	  }
	//带日历输入的构造函数
	  public JCalendar(GregorianCalendar calendar) {
	    cal=calendar;
	    try {jbInit();}
	    catch (Exception e) {e.printStackTrace();}
	  }
	//带日期输入的构造函数
	  public JCalendar(Date date) {
	    cal.setTime(date);
	    try {jbInit();}
	    catch (Exception e) {e.printStackTrace();}
	  }
	  private void jbInit() throws Exception {
	    iniCalender();
	    this.setLayout(new BorderLayout());
	    this.setBorder(BorderFactory.createRaisedBevelBorder());
	    this.setMaximumSize(new Dimension(200, 200));
	    this.setMinimumSize(new Dimension(200, 200));
	    this.setPreferredSize(new Dimension(200, 200));
	    
	    Main.setLayout(new BorderLayout());
	    Main.setBackground(Color.cyan);
	    Main.setBorder(null);
	    
	    Out.setBackground(Color.blue);
	    Out.setHorizontalAlignment(SwingConstants.CENTER);
	    Out.setMaximumSize(new Dimension(100, 19));
	    Out.setMinimumSize(new Dimension(100, 19));
	    Out.setPreferredSize(new Dimension(100, 19));
	    jPanelDay.setBackground(Color.cyan);
	    jLabel1.setForeground(Color.red);
	    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	    jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
	    jLabel1.setText("Sun");
	    jLabel2.setForeground(Color.red);
	    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	    jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
	    jLabel2.setText("Sat");
	    jLabel3.setForeground(Color.blue);
	    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
	    jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
	    jLabel3.setText("Fri");
	    jLabel4.setForeground(Color.blue);
	    jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
	    jLabel4.setHorizontalTextPosition(SwingConstants.CENTER);
	    jLabel4.setText("Thur");
	    jLabel5.setForeground(Color.blue);
	    jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
	    jLabel5.setHorizontalTextPosition(SwingConstants.CENTER);
	    jLabel5.setText("Wed");
	    jLabel6.setForeground(Color.blue);
	    jLabel6.setBorder(null);
	    jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
	    jLabel6.setHorizontalTextPosition(SwingConstants.CENTER);
	    jLabel6.setText("Tue");
	    jLabel7.setForeground(Color.blue);
	    jLabel7.setBorder(null);
	    jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
	    jLabel7.setHorizontalTextPosition(SwingConstants.CENTER);
	    jLabel7.setText("Mon");
	    
	    weekPanel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
	    weekPanel.setBorder(BorderFactory.createEtchedBorder());
	    weekPanel.setLayout(new GridLayout(1,7));
	    weekPanel.add(jLabel1, null);
	    weekPanel.add(jLabel7, null);
	    weekPanel.add(jLabel6, null);
	    weekPanel.add(jLabel5, null);
	    weekPanel.add(jLabel4, null);
	    weekPanel.add(jLabel3, null);
	    weekPanel.add(jLabel2, null);    
	    
	    MonthUp.setAlignmentX((float) 0.0);
	    MonthUp.setActionMap(null);
	        
	    jPanelMonth.setBackground(Color.blue);
	    jPanelMonth.setLayout(new BorderLayout());
	    jPanelMonth.setBorder(BorderFactory.createEtchedBorder());
	               
	    Month.setBorder(null);
	    Month.setHorizontalAlignment(SwingConstants.CENTER);
	    Month.addMouseListener(new java.awt.event.MouseAdapter() {
	       public void mouseClicked(MouseEvent e) {
	          Month_mouseClicked(e);}});
	    Month.addKeyListener(new java.awt.event.KeyAdapter() {
	       public void keyPressed(KeyEvent e) {
	          Month_keyPressed(e);}});
	    
	    MonthDown.setBorder(null);
	    MonthDown.setText("\u25C4");
	    MonthDown.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	         MonthDown_actionPerformed(e);}});
	    MonthUp.setBorder(null);
	    MonthUp.setText("\u25BA");
	    MonthUp.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        MonthUp_actionPerformed(e);}});
	        
	    jPanelButton.setLayout(null);
	    jPanelButton.setBorder(null);
	    jPanelButton.addComponentListener(new java.awt.event.ComponentAdapter() {
	      public void componentResized(java.awt.event.ComponentEvent evt) {
	        jPanelButtonComponentResized(evt);}});
	    
	 Year.setBorder(BorderFactory.createEtchedBorder());
	    Year.setMaximumSize(new Dimension(58, 25));
	    Year.setMinimumSize(new Dimension(58, 25));
	    Year.setPreferredSize(new Dimension(58, 25));
	    Year.setHorizontalAlignment(SwingConstants.CENTER);
	    Year.addMouseListener(new java.awt.event.MouseAdapter() {
	      public void mouseClicked(MouseEvent e) {
	        Year_mouseClicked(e);}});
	    Year.addKeyListener(new java.awt.event.KeyAdapter() {
	      public void keyPressed(KeyEvent e) {
	        Year_keyPressed(e);}});
	    
	    
	    YearUp.setBorder(null);
	    YearUp.setMaximumSize(new Dimension(16, 16));
	    YearUp.setMinimumSize(new Dimension(16, 16));
	    YearUp.setPreferredSize(new Dimension(16, 16));
	    YearUp.setSize(new Dimension(16, 16));
	    YearUp.setText("▲");
	    YearUp.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        YearUp_actionPerformed(e);}});
	                
	    YearDown.setBorder(null);
	    YearDown.setMaximumSize(new Dimension(16, 16));
	    YearDown.setMinimumSize(new Dimension(16, 16));
	    YearDown.setPreferredSize(new Dimension(16, 16));
	    YearDown.setSize(new Dimension(16, 16));
	    YearDown.setText("▼");
	    YearDown.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        YearDown_actionPerformed(e);}});
	    
	    jPanelDay.setLayout(new BorderLayout());
	    
	    Days.setLayout(new GridLayout(6,7));    
	    Days.setBackground(Color.cyan);
	    
	    for(int i=0;i<42;i++){
	      days[i]=new JToggleButton();
	      days[i].setBorder(null);
	      days[i].setBackground(Color.cyan);
	      days[i].setHorizontalAlignment(SwingConstants.CENTER);
	      days[i].setHorizontalTextPosition(SwingConstants.CENTER);
	      //days[i].setSize(l,l);
	      days[i].addActionListener(new java.awt.event.ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	          day=Integer.parseInt(((JToggleButton)e.getSource()).getText());
	          showDate();
	          showDays();   }});
	      Days.add(days[i]);   }
	    
	    this.add(Main,  BorderLayout.NORTH);
	    this.add(jPanelDay, BorderLayout.CENTER);
	    this.add(jPanelMonth,  BorderLayout.SOUTH);
	    
	    Main.add(Year,  BorderLayout.CENTER);
	    Main.add(Out, BorderLayout.WEST);
	    Main.add(jPanelButton,  BorderLayout.EAST);
	    
	    jPanelButton.add(YearUp);
	    jPanelButton.add(YearDown);
	    
	    jPanelDay.add(weekPanel,BorderLayout.NORTH);
	    jPanelDay.add(Days, BorderLayout.CENTER);
	    
	    jPanelMonth.add(Month, BorderLayout.CENTER);
	    jPanelMonth.add(MonthDown,  BorderLayout.WEST);
	    jPanelMonth.add(MonthUp,  BorderLayout.EAST);
	    
	    showMonth();
	    showYear();
	    showDate();
	    showDays();
	  }
	  
	  void jPanelButtonComponentResized(java.awt.event.ComponentEvent evt){
	    YearUp.setLocation(0,0);
	    YearDown.setLocation(0,YearUp.getHeight());
	    jPanelButton.setSize(YearUp.getWidth(),YearUp.getHeight()*2);
	    jPanelButton.setPreferredSize(new Dimension(YearUp.getWidth(),YearUp.getHeight()*2));
	    jPanelButton.updateUI();
	  }
	  @SuppressWarnings("deprecation")
	public static void main(String[] args){
	    JFrame f=new JFrame("我们的日历");
	    Toolkit tk = Toolkit.getDefaultToolkit();
	    Image img = tk.getImage("icon.gif");
	    f.setIconImage(img);
	    f.setContentPane(new JCalendar());
	    f.pack();
	    f.setSize(280,250);
	    f.setResizable(false);
	    f.show();
	  }

	//4，实现主要方法及监听器

	  void YearUp_actionPerformed(ActionEvent e) {
	    year++;
	    showYear();
	    showDate();
	    showDays();
	  }
	  void YearDown_actionPerformed(ActionEvent e) {
	    year--;
	    showYear();
	    showDate();
	    showDays();
	  }
	  void MonthDown_actionPerformed(ActionEvent e) {
	    month--;
	    if(month<0) {
	      month = 11;
	      year--;
	      showYear();
	    }
	    showMonth();
	    showDate();
	    showDays();
	  }
	  void MonthUp_actionPerformed(ActionEvent e) {
	    month++;
	    if(month==12) {
	      month=0;
	      year++;
	      showYear();
	    }
	    showMonth();
	    showDate();
	    showDays();
	  }
	  void iniCalender(){
	    year=cal.get(Calendar.YEAR);
	    month=cal.get(Calendar.MONTH);
	    day=cal.get(Calendar.DAY_OF_MONTH);
	  }
	  void showMonth(){
	    Month.setText(Integer.toString(month+1)+"月");
	  }
	  void showYear(){
	    Year.setText(Integer.toString(year)+"年");
	  }
	  void showDate(){
	    Out.setText(Integer.toString(year)+"-"+Integer.toString(month+1)+"-"+Integer.toString(day));
	  }
	  void showDays() {
	    cal.set(year,month,1);
	    int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	    int n=ts[month];
	    if(cal.isLeapYear(year)&&month==1) n++;
	    int i=0;
	    for(;i<firstDayOfWeek-1;i++){
	      days[i].setEnabled(false);
	      days[i].setSelected(false);
	      days[i].setText("");
	    }
	    int d=1;
	    for(;d<=n;d++){
	      days[i].setText(Integer.toString(d));
	      days[i].setEnabled(true);
	      if(d==day) days[i].setSelected(true);
	      else days[i].setSelected(false);;
	      i++;
	    }
	    for(;i<42;i++){
	      days[i].setEnabled(false);
	      days[i].setSelected(false);
	      days[i].setText(" ");
	    }
	  }
	  void SelectionYear(){
	    Year.setSelectionStart(0);
	    Year.setSelectionEnd(Year.getText().length());
	  }
	  void SelectionMonth(){
	    Month.setSelectionStart(0);
	    Month.setSelectionEnd(Month.getText().length());
	  }
	  void Month_mouseClicked(MouseEvent e) {
	    inputMonth();
	  }
	  
	  void inputMonth(){
	    String s;
	    if(Month.getText().endsWith("月"))
	    {
	      s=Month.getText().substring(0,Month.getText().length()-1);
	    }
	    else s=Month.getText();
	    month=Integer.parseInt(s)-1;
	    this.showMe();
	  }
	  
	  void Month_keyPressed(KeyEvent e) {
	    if(e.getKeyChar()==10)
	      inputMonth();
	  }
	  
	  void Year_mouseClicked(MouseEvent e) {
	    //SelectionYear();
	    inputYear();
	  }
	  
	  void Year_keyPressed(KeyEvent e) {
	    System.out.print(new Integer(e.getKeyChar()).byteValue());
	    if(e.getKeyChar()==10)
	      inputYear();
	  }
	  
	  void inputYear() {
	    String s;
	    if(Year.getText().endsWith("年"))
	    {
	      s=Year.getText().substring(0,Year.getText().length()-1);
	    }
	    else s=Year.getText();
	    year=Integer.parseInt(s);
	    this.showMe();
	  }
	  
	  public String getDate(){return Out.getText();}
	  
	  public void setDate(String date){
	    if(date!=null){
	      StringTokenizer f = new StringTokenizer(date, "-");
	      if(f.hasMoreTokens())
	        year = Integer.parseInt(f.nextToken());
	      if(f.hasMoreTokens())
	        month = Integer.parseInt(f.nextToken());
	      if(f.hasMoreTokens())
	        day = Integer.parseInt(f.nextToken());
	      cal.set(year,month,day);
	    }
	    this.showMe();
	  }
	  public void setTime(Date date){
	   cal.setTime(date);
	   this.iniCalender();
	   this.showMe();
	  }
	  
	  public Date getTime(){return cal.getTime();}
	  public int getDay() {
	    return day;
	  }
	  public void setDay(int day) {
	    this.day = day;
	    cal.set(this.year,this.month,this.day);
	    this.showMe();
	  }
	  public void setYear(int year) {
	    this.year = year;
	    cal.set(this.year,this.month,this.day);
	    this.showMe();
	  }
	  public int getYear() {
	    return year;
	  }
	  public int getMonth() {
	    return month;
	  }
	  public void setMonth(int month) {
	    this.month = month;
	    cal.set(this.year,this.month,this.day);
	    this.showMe();
	  }
	 
	  public void showMe(){
	   this.showDays();
	   this.showMonth();
	   this.showYear();
	   this.showDate();
	  }
	}
	public static void main(String[] args) {
	}
}