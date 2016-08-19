
import javax.swing.JOptionPane;

public class stars{
	public static void main(String[] args){
		String sec1 = 
		" 1  3  5  7\n" + 
		" 9 11 13 15\n" +
		"17 19 21 23\n" + 
		"25 27 29 31";
		String sec2 = 
		" 2  3  6  7\n" +
		"10 11 14 15\n" +
		"18 19 22 23\n" + 
		"26 27 30 31\n";
		String sec3 = 
		" 4  5  6  7\n" +
		"12 13 14 15\n" +
		"20 21 22 23\n" + 
		"28 29 30 31";
		String sec4 = 
		" 8  9 10 11\n" +
		"12 13 14 15\n" +
		"24 25 26 27\n" +
		"28 29 30 31";
		String sec5 =
		"16 17 18 19\n" +
		"20 21 22 23\n" +
		"24 25 26 27\n" +
		"28 29 30 31";
		//日定义
		String nsec1 = 
		" 1  3  5  7\n" +
		" 9 11";
		String nsec2 = 
		" 2  3  6  7\n" +
		"10 11";
		String nsec3 =
		" 4  5  6  7";
		String nsec4 = 
		" 8  9 10 11";
		//月定义
		int day = 0, month = 0;
		int judge = 1;
		JOptionPane.showMessageDialog(null, "水晶球是世界上最神奇的东西，只要你诚心，你就能从中看到你自己。\n                                -------李琨");
		while(judge == 1){
			day = month = 0;
			int answer = JOptionPane.showConfirmDialog(null, "看看，里面有你出生的那天吗？\n" + sec1);
			if(answer == JOptionPane.YES_OPTION)
				day += 1;
			
			answer = JOptionPane.showConfirmDialog(null, "看看，里面有你出生的那个月吗？\n" + nsec1);
			if(answer == JOptionPane.YES_OPTION)
				month += 1;
			
			answer = JOptionPane.showConfirmDialog(null, "看看，里面有你出生的那天吗？\n" + sec2);
			if(answer == JOptionPane.YES_OPTION)
				day += 2;
			
			answer = JOptionPane.showConfirmDialog(null, "看看，里面有你出生的那个月吗？\n" + nsec2);
			if(answer == JOptionPane.YES_OPTION)
				month += 2;
			
			answer = JOptionPane.showConfirmDialog(null, "看看，里面有你出生的那天吗？\n" + sec3);
			if(answer == JOptionPane.YES_OPTION)
				day += 4;
			
			answer = JOptionPane.showConfirmDialog(null, "看看，里面有你出生的那个月吗？\n" + nsec3);
			if(answer == JOptionPane.YES_OPTION)
				month += 4;
			
			answer = JOptionPane.showConfirmDialog(null, "看看，里面有你出生的那天吗？\n" + sec4);
			if(answer == JOptionPane.YES_OPTION)
				day += 8;
			
			answer = JOptionPane.showConfirmDialog(null, "看看，里面有你出生的那个月吗？\n" + nsec4);
			if(answer == JOptionPane.YES_OPTION)
				month += 8;
			
			answer = JOptionPane.showConfirmDialog(null, "看看，里面有你出生的那天吗？\n" + sec5);
			if(answer == JOptionPane.YES_OPTION)
				day += 16;
			if(day == 0 || month == 0){
				JOptionPane.showMessageDialog(null, "一直点否的可不是好人...\n再给你一次机会吧");
			}
			else
				judge = 0;
			if(month > 12){
				judge = 1;
				JOptionPane.showMessageDialog(null, "一直点是的可不是好人...\n再给你一次机会吧");
			}
		}
		JOptionPane.showMessageDialog(null, "水晶球检测完毕，你的生日即将浮现。");
		JOptionPane.showMessageDialog(null, "你的出生日期是" + month + "月 "+ day + "日" + "!");
		//System.out.println(day);
	}
}