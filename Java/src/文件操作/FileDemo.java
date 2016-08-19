package ÎÄ¼þ²Ù×÷;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import javax.swing.JFileChooser;
 
public class FileDemo
{
    public static void main(String[] args)
	{
        File sourcePath = getSourcePath();
        File outputPath = getOutputPath();
        handlePath(sourcePath, outputPath);
    }
 
    private static void handlePath(File sourcePath, File outputPath)
	{
        if (sourcePath == null || outputPath == null)
            return;
        for (File file : sourcePath.listFiles())
		{
            if (file.isDirectory()) 
			{
                handlePath(file, outputPath);
            }
			else
			{
                String fileName = file.getName();
                if (fileName.contains("."))
				{
                    String suffix = fileName.substring(fileName.lastIndexOf('.') + 1);
                    copy(file, new File(outputPath, suffix));
                }
				else
				{
                    copy(file, new File(outputPath, "nosuffix"));
                }
            }
        }
    }
 
    private static void copy(File sourceFile, File targetDir)
	{
        System.out.println("copying " + sourceFile);
        if (!targetDir.exists())
		{
            targetDir.mkdir();
        }

        try
		{
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(new File(targetDir, sourceFile.getName()));
            byte[] buf = new byte[102400];
            int available = 0;
            while ((available = fis.available()) > buf.length)
			{
                fis.read(buf);
                fos.write(buf);
            }
            fis.read(buf, 0, available);
            fos.write(buf, 0, available);
            fis.close();
            fos.close();
        }

		catch (FileNotFoundException e)
		{
            e.printStackTrace();
        } 

		catch (IOException e)
		{
            e.printStackTrace();
        }
 
    }
 
    private static File getSourcePath()
	{
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
            return chooser.getSelectedFile();
        }
        return null;

    }
 
    private static File getOutputPath()
	{
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{
            return chooser.getSelectedFile();
        }
        return null;

    }

}
