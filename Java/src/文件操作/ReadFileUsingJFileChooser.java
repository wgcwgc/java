package 文件操作;

import java.util.*;
import java.io.*;
import javax.swing.*;

public class ReadFileUsingJFileChooser
{

	public static void main(String[] args)  throws Exception
	{
		JFileChooser fileChooser = new JFileChooser();
		
		//if(fileChooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION)//取消是打开
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) //正常打开
		//if(fileChooser.showSaveDialog(null) == JFileChooser.CANCEL_OPTION) //取消是保存
		//if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) //正常保存
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
