
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
		//�ն���
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
		//�¶���
		int day = 0, month = 0;
		int judge = 1;
		JOptionPane.showMessageDialog(null, "ˮ������������������Ķ�����ֻҪ����ģ�����ܴ��п������Լ���\n                                -------����");
		while(judge == 1){
			day = month = 0;
			int answer = JOptionPane.showConfirmDialog(null, "�������������������������\n" + sec1);
			if(answer == JOptionPane.YES_OPTION)
				day += 1;
			
			answer = JOptionPane.showConfirmDialog(null, "��������������������Ǹ�����\n" + nsec1);
			if(answer == JOptionPane.YES_OPTION)
				month += 1;
			
			answer = JOptionPane.showConfirmDialog(null, "�������������������������\n" + sec2);
			if(answer == JOptionPane.YES_OPTION)
				day += 2;
			
			answer = JOptionPane.showConfirmDialog(null, "��������������������Ǹ�����\n" + nsec2);
			if(answer == JOptionPane.YES_OPTION)
				month += 2;
			
			answer = JOptionPane.showConfirmDialog(null, "�������������������������\n" + sec3);
			if(answer == JOptionPane.YES_OPTION)
				day += 4;
			
			answer = JOptionPane.showConfirmDialog(null, "��������������������Ǹ�����\n" + nsec3);
			if(answer == JOptionPane.YES_OPTION)
				month += 4;
			
			answer = JOptionPane.showConfirmDialog(null, "�������������������������\n" + sec4);
			if(answer == JOptionPane.YES_OPTION)
				day += 8;
			
			answer = JOptionPane.showConfirmDialog(null, "��������������������Ǹ�����\n" + nsec4);
			if(answer == JOptionPane.YES_OPTION)
				month += 8;
			
			answer = JOptionPane.showConfirmDialog(null, "�������������������������\n" + sec5);
			if(answer == JOptionPane.YES_OPTION)
				day += 16;
			if(day == 0 || month == 0){
				JOptionPane.showMessageDialog(null, "һֱ���Ŀɲ��Ǻ���...\n�ٸ���һ�λ����");
			}
			else
				judge = 0;
			if(month > 12){
				judge = 1;
				JOptionPane.showMessageDialog(null, "һֱ���ǵĿɲ��Ǻ���...\n�ٸ���һ�λ����");
			}
		}
		JOptionPane.showMessageDialog(null, "ˮ��������ϣ�������ռ������֡�");
		JOptionPane.showMessageDialog(null, "��ĳ���������" + month + "�� "+ day + "��" + "!");
		//System.out.println(day);
	}
}