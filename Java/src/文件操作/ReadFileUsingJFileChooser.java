package �ļ�����;

import java.util.*;
import java.io.*;
import javax.swing.*;

public class ReadFileUsingJFileChooser
{

	public static void main(String[] args)  throws Exception
	{
		JFileChooser fileChooser = new JFileChooser();
		
		//if(fileChooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION)//ȡ���Ǵ�
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) //������
		//if(fileChooser.showSaveDialog(null) == JFileChooser.CANCEL_OPTION) //ȡ���Ǳ���
		//if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) //��������
		{
			File file = fileChooser.getSelectedFile();
			Scanner cin = new Scanner(file);
			while(cin.hasNext())
				System.out.println(cin.nextLine());
			cin.close();
		}
		else	System.out.println("No file selected");
	}

}
