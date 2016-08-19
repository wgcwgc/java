package org.jbarcode;

	/*
    * To change this template, choose Tools | Templates 
    * and open the template in the editor. 
    */
   import java.awt.image.BufferedImage;  
   import java.io.FileOutputStream;  
   import org.jbarcode.JBarcode;  
   import org.jbarcode.encode.EAN8Encoder;
   import org.jbarcode.paint.EAN8TextPainter;
   import org.jbarcode.paint.WidthCodedPainter;  
   import org.jbarcode.util.ImageUtil;  
   /** 
    * 支持EAN13, EAN8, UPCA, UPCE, Code 3 of 9, Codabar, Code 11, Code 93, Code 128, MSI/Plessey, Interleaved 2 of PostNet等
    * 利用jbarcode生成各种条形码
    */ 
   public class Barcode {
     public static void main(String[] paramArrayOfString) {  
         try {  
             JBarcode localJBarcode = new JBarcode(EAN8Encoder.getInstance(),WidthCodedPainter.getInstance(),EAN8TextPainter.getInstance());  
             String str = "2219646";
             BufferedImage localBufferedImage = localJBarcode.createBarcode(str);  
                   saveToJPEG(localBufferedImage, "EAN.jpg");
         }  
         catch (Exception localException) {  
             localException.printStackTrace();  
         }  
     }
     static void saveToJPEG(BufferedImage paramBufferedImage, String paramString) {  
         saveToFile(paramBufferedImage, paramString, "jpeg");  
     }  
     static void saveToFile(BufferedImage paramBufferedImage, String paramString1, String paramString2) {  
         try {  
             FileOutputStream localFileOutputStream = new FileOutputStream("E:\\360data\\重要数据\\桌面\\" + paramString1);
             ImageUtil.encodeAndWrite(paramBufferedImage, paramString2, localFileOutputStream, 96, 96);  
             localFileOutputStream.close();  
         }  
         catch (Exception localException) {  
             localException.printStackTrace();  
         }  
     }  
}