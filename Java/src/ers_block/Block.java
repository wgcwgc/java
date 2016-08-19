package ers_block;

public class Block
{
 static int[][] pattern = {
	   //��ʮ�����Ʊ�ʾ��ÿ�б�ʾ����״̬ 
     {0x0f00,0x4444,0x0f00,0x4444},
     {0x04e0,0x0464,0x00e4,0x04c4},
     {0x4620,0x6c00,0x4620,0x6c00},
     {0x2640,0xc600,0x2640,0xc600},
     {0x6220,0x1700,0x2230,0x0740},
     {0x6440,0x0e20,0x44c0,0x8e00},
     {0x0660,0x0660,0x0660,0x0660}
 };
 int blockType;                //���ģʽ�ţ�0-6��
 int turnState;               //��ķ�ת״̬��0-3)
 int blockState;             //�������״̬
 int row,col;               //���ڻ����ϵ����� 
 GameCanvas scr; 			//����Ĺ��췽�� 
 Block(GameCanvas scr)
 {
     this.scr = scr;
     blockType = (int)(Math.random() * 1000)%7;
     turnState = (int)(Math.random() * 1000)%4;
     blockState = 1;
     row = scr.getInitRow();
     col = scr.getInitCol();
 }
 //���³�ʼ���飬����ʾ�¿� 
 public void reset()
 {
     blockType = (int)(Math.random() * 1000)%7;
     turnState = (int)(Math.random() * 1000)%4;
     blockState = 1;
     row = scr.getInitRow();
     col = scr.getInitCol();
     dispBlock(1);
 }
 //ʵ�ֿ鷭ת�ķ��� 
 public void leftTurn()
 {
     if(assertValid(blockType,(turnState + 1)%4,row,col))
     {
         dispBlock(0);
         turnState = (turnState + 1) % 4;
         dispBlock(1);
     }
 }
 //ʵ�ֿ�����Ƶķ��� 
 public void leftMove()
 {
     if(assertValid(blockType,turnState,row,col-1))
     {
         dispBlock(0);
         col --;
         dispBlock(1);
     }
 }
 //ʵ�ֿ������ 
 public void rightMove()
 {
     if(assertValid(blockType,turnState,row,col+1))
     {
         dispBlock(0);
         col ++;
         dispBlock(1);
     }
 }
 //ʵ�ֿ����µĲ����ķ��� 
 public boolean fallDown()
 {
     if(blockState == 2)
         return(false);
     if(assertValid(blockType,turnState,row-1,col))
     {
         dispBlock(0);
         row --;
         dispBlock(1);
         return(true);
     }
     else
     {
         blockState = 2;
         dispBlock(2);
         return(false);
     }
 }
 //�ж��Ƿ���ȷ�ķ��� 
 boolean assertValid(int t,int s,int row,int col)
 {
     int k = 0x8000;
     for(int i = 0; i < 4; i++)
     {
         for(int j = 0; j < 4; j++)
         {
             if((int)(pattern[t][s]&k) != 0)
             {
                 int temp = scr.getScrArrXY(row-i,col+j);
                 if (temp<0||temp==2)
                 return false;
             }
             k >>= 1;
         }
     }
     return true;
 }
 //ͬ����ʾ�ķ��� 
 public synchronized void dispBlock(int s)
 {
     int k = 0x8000;
     for (int i = 0; i < 4; i++)
         for(int j = 0; j < 4; j++)
         {
             if(((int)pattern[blockType][turnState]&k) != 0)
                 scr.drawUnit(row-i,col+j,s);
             k >>= 1;
         }
 }
}