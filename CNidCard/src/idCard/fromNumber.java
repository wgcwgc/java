package idCard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

class fromNumber{
	
	public char[] num = new  char[20];
	private int flag = 0;
	@SuppressWarnings("unused")
	private boolean isEighteen = false;
	private int tempCheck = 0;
	public String code = "";      //ǰ6λ
	public String belong = "";  //����
	public String birthday = "";
	public String sex = "";
	public String newNumber = "";
	String path = this.getClass().getClassLoader().getResource("dataBase/Identity.mdb").getPath().substring(1);//���ݿ����·��
	
	public fromNumber(){
		
	}
	
	public fromNumber(String c,String b){
		code = c;
		belong = b;
	}
	
	public void numIn(String str){
		String s = str;
	    flag=0;
	    for(int i=0;i<s.length();i++){
    		num[ i ]= s.charAt(i);
    		flag++;
	    }
	}
	
	@SuppressWarnings("unused")
	public int checkNumber(){//�жϺ������뷵�ع���
		if(flag == 15){
			for(int m=0;m<=14;m++){
				if(!Character.isDigit(num[m])){
					return 1;
				}
			}
			oldChange();
			showBirthday();
			if(tempCheck == 1){//�������������޴���
				return 1;
			}
			else
				return 0;
		}
		else if(flag == 18){
			for(int n=0;n<=16;n++){
				if(!Character.isDigit(num[n])){
					return 1;
				}
				oldChange();
				showBirthday();
				if(tempCheck == 1){
					return 1;
				}
				if(!Character.isDigit(num[17])){
					if(num[17]=='x' || num[17]=='X'){
						return 0;
					}
					else{
						return 1;
					}
				}
				return 0;
			}
		}
		else
			return 1;
		return 1;
	}
	
	public int checkNumber(int i){//�жϺ��뷵��,����д�ĳ��������ж�
		return i;
	}
	
	public char checkLastNumber(){//18λ�ж�У����
    	int sum=0,m;
		int wi;
		char c = 0;
		for(int i = 2; i<=18 ;i++){
			int temp,tempint;
			wi =(((int)Math.pow(2, (i-1))) % 11);
			String str = String.valueOf(num[18-i]);
			tempint =Integer.parseInt(str);
			temp = tempint * wi;
		    sum +=temp;
		}
		m = (int)(sum%11);
		switch(m){
		case 0: c='1';break;
		case 1: c='0';break;
		case 2: c='X';break;
		case 3: c='9';break;
		case 4: c='8';break;
		case 5: c='7';break;
		case 6: c='6';break;
		case 7: c='5';break;
		case 8: c='4';break;
		case 9: c='3';break;
		case 10: c='2';break;
		}
		return c;
    }
	
	public boolean isCorrect(){//�ж������18λ���֤У������ȷ���
		if(Character.isDigit(num[17])){
			if(num[17] ==checkLastNumber()){
				return true;
			}
			else
				return false;
		}
		else if(num[17] == 'x' || num[17] == 'X'){
			num[17] = 'X';
			newNumber = "";
			for(int i=0;i<18;i++){
	    		newNumber += num[i];
		    }
			if(num[17] ==checkLastNumber()){
				return true;
			}
			else
				return false;
			}
		else
			return false;
	}
		
	public void oldChange(){//15λ�������Ϊ18λ����
    	if(flag == 15){
    		for(int i=14;i>5;i--){
    			num[i+2]=num[i];
    		}
    		String foo="";
    		foo+=num[8];
    		int foo1=Integer.parseInt(foo);
    		if(foo1<2){  //������жϾɱ���ʱǰ��ӵ����Ϊ"19"����"20"
    			num[6]= '2';
    			num[7]= '0';
    		}
    		else{
    			num[6] = '1';
    			num[7] = '9';
    		}
    		flag += 2;
    		int sum=0,m;
    		int wi;
    		char c = 0;
    		for(int i = 2; i<=18 ;i++){
    			int temp,tempint;
    			wi =(((int)Math.pow(2, (i-1))) % 11);
    			String str = String.valueOf(num[18-i]);
    			tempint =Integer.parseInt(str);
    			temp = tempint * wi;
    		    sum +=temp;
    		}
    		m = (int)(sum%11);
    		switch(m){
    		case 0: c='1';break;
    		case 1: c='0';break;
    		case 2: c='X';break;
    		case 3: c='9';break;
    		case 4: c='8';break;
    		case 5: c='7';break;
    		case 6: c='6';break;
    		case 7: c='5';break;
    		case 8: c='4';break;
    		case 9: c='3';break;
    		case 10: c='2';break;
    		}	
    		num[17] = c;
    		for(int k = 0;k<18;k++){
    			newNumber += num[k];//newNumber
    		}
    	}
    	else if(flag == 18){
    		for(int k = 0;k<18;k++){
    			newNumber += num[k];//newNumber
    		}
    	}
    }
	
	public String showBirthday(){
		String bornyear = "";
	    String bornmonth ="";
	    String bornday ="";
	    Calendar rightnow = Calendar.getInstance();
		int nowY=rightnow.get(Calendar.YEAR);
		@SuppressWarnings("unused")
		int nowM=rightnow.get(Calendar.MONTH)+1;//�·�Ϊ0��
		@SuppressWarnings("unused")
		int nowD=rightnow.get(Calendar.DATE);
		int bornY,bornM,bornD;
		
	    for(int Y=6;Y<=9;Y++){		    	
	    		bornyear +=num[Y];
	    }
	    for(int M=10;M<=11;M++){
	    	    bornmonth +=num[M];
	    }
	    for(int D=12;D<=13;D++){
	    	    bornday +=num[D];
	    }
	    bornY=Integer.parseInt(bornyear);
	    bornM=Integer.parseInt(bornmonth);
	    bornD=Integer.parseInt(bornday);
	    if(bornY > nowY){
	    	tempCheck = 1;
			return("���������շǷ�");
		}
	    else if(bornM >= 13 || bornM <=0){
	    	tempCheck = 1;
	    	return("���������շǷ�");
	    }
	    else if(bornD < 1 ||bornD >= 32 || (bornM == 4 && bornD >=31) || (bornM == 6 && bornD >=31) || (bornM == 9 && bornD >= 31) || (bornM == 11 && bornD >= 31) ||((bornY % 400 == 0 && bornY %4 == 0 && bornY % 100 != 0) && bornM == 2 && bornD >=30) || ((bornY % 400 != 0 || bornY %4 != 0 || bornY % 100 != 0) && bornM == 2 && bornD >=29)){
	    	tempCheck = 1;
	    	return("���������շǷ�");
	    }
	    else
	    birthday = (bornyear+"��"+bornmonth+"��"+bornday+"��");
	    return (bornyear+"��"+bornmonth+"��"+bornday+"��");
	}
	
	public String showSex(){
		if((num[16])%2 == 0)
			return ("Ů");
		else
			return ("��");
	}

	public String showArea(){//���ػ���
		showCode();
		try{
 			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 			  String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path;
 			  Connection con = DriverManager.getConnection(url);
 			  Statement st = con.createStatement();
 			  String sql = ("select Belong from Identity where Code = '"+code+"'");
 			  ResultSet rs = st.executeQuery(sql);
 			  while(rs.next()){
 				 belong = rs.getString("Belong");
 			  }
 			  st.close();
 			  con.close();
 		   }catch(Exception ex){
 			   ex.printStackTrace();
 		   }
		return belong;
	}
	
	public String showCode(){
		for(int x = 0;x<6;x++){
			code += num[x];
		}
		return code;
	}
	
	public String showBelong(){//����
		return (belong);
	}
	
}