package JBacode.my.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


@SuppressWarnings("serial")
public class MAIN extends JFrame implements ActionListener{
	
	 	private javax.swing.JButton btn_add;
	    private javax.swing.JButton btn_create;
	    private javax.swing.JButton btn_preview;
	    private javax.swing.JButton btn_print;
	    private javax.swing.JButton btn_setting;
	    private javax.swing.JScrollPane jScrollPane1;
	    @SuppressWarnings("rawtypes")
		private javax.swing.JList list;
	    private javax.swing.JTextField mytext;
	    private javax.swing.JLabel mylabel;
	    
	    Code39 code39 = new Code39();
	    private String num;
	    @SuppressWarnings("unused")
		private String[] strings = {};
	    private static String[] ms;
	    
	    @SuppressWarnings("rawtypes")
		DefaultListModel dlm = new DefaultListModel();
	    
	    
	    
	public static void main(String[] args) {
			 MAIN main = new MAIN();
			 main.initComponents();
			 java.io.File fil = new java.io.File("E://360data//重要数据//桌面//1");
			 if  (!fil .exists()  && !fil .isDirectory())      
			        fil .mkdir(); 
	}
	
	
    @SuppressWarnings("rawtypes")
	private  void initComponents() {

         	jScrollPane1 = new javax.swing.JScrollPane();
	        list = new JList();
	        list.addListSelectionListener(new ListSelectionListener() {
				
				public void valueChanged(ListSelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
	        mytext = new JTextField("请输入书号");
	        btn_add = new javax.swing.JButton();
	        btn_preview = new javax.swing.JButton();
	        btn_create = new javax.swing.JButton();
	        btn_print = new javax.swing.JButton();
	        btn_setting = new javax.swing.JButton();
	        mylabel = new JLabel();
	       
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//        list.setModel(new javax.swing.AbstractListModel() {
//            public int getSize() { return strings.length; }
//            public Object getElementAt(int i) { return strings[i]; }
//        });
        jScrollPane1.setViewportView(list);

       
        mytext.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {}
			
			public void mousePressed(MouseEvent arg0) {}
			
			public void mouseExited(MouseEvent arg0) {}
			
			public void mouseEntered(MouseEvent arg0) {}
			
			public void mouseClicked(MouseEvent arg0) {
				// 设置提示文字，在被点击后清空内容
				mytext.setText("");
				mytext.removeMouseListener(this);
			}
		});

        btn_add.setText(" 添  加 ");
        btn_add.addActionListener(this);
        btn_print.addActionListener(this);
        btn_preview.addActionListener(this);
        btn_create.addActionListener(this);

        btn_preview.setText(" 预  览 ");

        btn_create.setText(" 删  除 ");

        btn_print.setText(" 打  印 ");

        btn_setting.setText(" 设  置 ");

        mylabel.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_add)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(mytext, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addComponent(mylabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_preview)
                    .addComponent(btn_create)
                    .addComponent(btn_print)
                    .addComponent(btn_setting))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(mytext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_preview)
                        .addGap(20, 20, 20)
                        .addComponent(btn_create)
                        .addGap(18, 18, 18)
                        .addComponent(btn_print)
                        .addGap(18, 18, 18)
                        .addComponent(btn_setting)))
                .addGap(18, 18, 18)
                .addComponent(mylabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        this.setVisible(true);
   }


    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == btn_add)
			add();
		else if (e.getSource() == btn_print)
			my_print();
		else if(e.getSource() == btn_preview)
			preview();
		else if(e.getSource() ==btn_create)
			delete();
		
	}
    
  


	@SuppressWarnings("unchecked")
	public void add(){	
    	try {
    		num = mytext.getText().toString();
    		dlm.addElement(num);
    		list.setModel(dlm);
    		code39.change(num); 
    		} catch (Exception m)
    		{System.out.println("bug");}
    }



	public void my_print(){
    	LocatePrint lp = new LocatePrint(); 
    	
    	if(dlm.getSize()==1){
    		ms = new String[2];
    		ms[0] = (String) dlm.getElementAt(0);
    		ms[1] = "0000000";
    	}else{
    		ms = new String[dlm.getSize()];
    	for(int i=0;i<dlm.getSize();i++){
    		ms[i] = (String) dlm.getElementAt(i);
    	}
    	}
    	try{
        lp.printContent(dlm.getSize(),ms);
    	}catch(InterruptedException m){
    		System.out.println("我出错了");
    	}
    }
  
    public String[] getMs() {
		return ms;
	}


	private void preview() {
		// TODO Auto-generated method stub
    	ImageIcon img = new ImageIcon("E://360data//重要数据//桌面//1/"+num+".jpeg");
    	mylabel.setIcon(img);
	}
    
    
    public void delete(){
    	dlm.remove(list.getSelectedIndex());
    }
    
}
