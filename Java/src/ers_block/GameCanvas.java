package ers_block;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class GameCanvas extends Canvas implements KeyListener
{
    final int unitSize = 27;                            //С����߳� 
    int rowNum;                                         //����������� 
    int columnNum;                                      //����������� 
    int maxAllowRowNum;                                 //�����ж�����δ��
    int blockInitRow;                                   //�³��ֿ����ʼ������ 
    int blockInitCol;                                   //�³��ֿ����ʼ������ 
    int [][] scrArr;                                    //��Ļ���� 
    Block b;                                            //�Է�������� 
    //������Ĺ��췽�� 
    GameCanvas()
    {
        rowNum = 15;
        columnNum = 10;
        maxAllowRowNum = rowNum;
        b = new Block(this);
        blockInitRow = rowNum - 1;
        blockInitCol = columnNum / 2 - 2;
        scrArr = new int [32][32];
    }
    //��ʼ����Ļ��������Ļ��������ķ��� 
    void initScr()
    {
        for(int i = 0;i < rowNum;i ++)
            for(int j = 0;j < columnNum;j ++)
                scrArr[i][j] = 0;
            b.reset();
            repaint();
    }
    //����ˢ�»������� 
    public void paint(Graphics g)
    {
        for(int i = 0;i < rowNum;i ++)
            for(int j = 0;j < columnNum;j ++)
                drawUnit(i,j,scrArr[i][j]);
    }
    //������ķ��� 
    public void drawUnit(int row,int col,int type)
    {
        scrArr[row][col] = type;
        Graphics g = getGraphics();
        switch(type)
        {
            case 0: g.setColor(Color.black);break;      //�Ա���Ϊ��ɫ�� 
            case 1: g.setColor(Color.blue);break;       //����������ķ��� 
            case 2: g.setColor(Color.yellow);break;    //���Ѿ����µķ��� 
        }
        g.fill3DRect(col*unitSize,getSize().height-(row+1)*unitSize,unitSize,unitSize,true);
        g.dispose();
    }
    public Block getBlock()
    {
        return b;                 //����blockʵ�������� 
    }
    //������Ļ������(row,col)λ�õ�����ֵ 
    public int getScrArrXY(int row,int col)
    {
        if (row < 0  || row >= rowNum || col < 0 || col >= columnNum)
            return(-1);
        else
            return(scrArr[row][col]);
    }
    public int getInitRow()
    {
        return(blockInitRow);            //�����¿�ĳ�ʼ������ 
    }
    public int getInitCol()
    {
        return(blockInitCol);          //�����¿�ĳ�ʼ������ 
    }
    //����
    void deleteFullLine()
    {
        int full_line_num = 0;
        int k = 0;
        for (int i = 0;i < rowNum;i ++)
        {
            boolean isfull = true;
            for(int j = 0;j < columnNum;j ++)
                if(scrArr[i][j] == 0)
                {
                    k ++;
                    isfull = false;
                    break;
                }
            if(isfull)
         	   full_line_num ++;
            if(k != 0 && k-1 != i && !isfull)
                for(int j = 0; j < columnNum; j ++)
                {
                    if (scrArr[i][j] == 0)
                      drawUnit(k-1,j,0);
                    else
                      drawUnit(k-1,j,2);
                    scrArr[k-1][j] = scrArr[i][j];
                }
        }
        for(int i = k-1 ;i < rowNum; i++)
            for(int j = 0; j < columnNum; j++)
            {
                drawUnit(i,j,0);
                scrArr[i][j]=0;
            }
        ERS_block.score += full_line_num;
        ERS_block.scoreField.setText(""+ERS_block.score);
    }
    //�����������ķ��� 
    public void keyPressed(KeyEvent e)
    {
        if(!ERS_block.isPlay)
            return;
       switch(e.getKeyCode())
       {
            case KeyEvent.VK_DOWN:b.fallDown();break;
            case KeyEvent.VK_LEFT:b.leftMove();break;
            case KeyEvent.VK_RIGHT:b.rightMove();break;
            case KeyEvent.VK_UP:b.leftTurn();break;
            case KeyEvent.VK_ENTER:b.leftTurn();break;
            case KeyEvent.VK_SPACE:b.leftTurn();break;
        }
    }
    //�ж���Ϸ�Ƿ�������� 
    public boolean isGameEnd()
    {
        for(int col = columnNum / 2;col < columnNum;col ++)
            if(scrArr[maxAllowRowNum - 2][col] != 0)
	               return true;
        return false;
    }
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}