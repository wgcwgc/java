package wgc;
import javax.swing.*;//�µĴ��������
import java.awt.*;
import java.awt.event.*;
public class rf  implements ActionListener
{   JFrame jf=new JFrame();
     boolean dotExist, operated, equaled; // ��������Ĳ�������
     double result; // Ŀǰ�Ľ��
    char lastOperator; // ��ʾ��һ�����
     JTextField jtf; // ��ʾ��
    JButton dot, plus, minus, multi, div, sqrt, equal, change, clear,quyu; // �����
    JButton[] numbers;
    Panel p=new Panel();
    
    public rf()    // ������
    {
       jf.setTitle("���׼�����");
        // ��ʼ������
        dotExist = false; // ��ʾ��ǰ�����Ƿ���С����
        operated = false; // ��ʾ����������Ƿ񱻰���
        equaled = false; // ��ʾ�Ⱥ��Ƿ񱻰���
        result = 0;
        lastOperator = '?';
        // ��ʼ�����ڱ���
        jtf = new JTextField("0");
        jtf.setEditable(false); //�����ı���Ŀɱ༭��
        jf.setSize(300,250);
        jf.setVisible(true);
        numbers = new JButton[10];
        for (int i = 0; i < 10; i++)
          numbers[i] = new JButton("" + i);  //��0��9����10�����ְ�ť
        dot = new JButton(".");
        plus = new JButton("+");
        minus = new JButton("-");
        
        multi = new JButton("*");
        div = new JButton("/");
        sqrt = new JButton("��");
        equal = new JButton("=");
        change= new JButton("��");
        clear = new JButton("NC");   //��λ
        quyu=new JButton("%");
        
        p.setLayout(new GridLayout(5,4)); //����һ��5��4�еĲ��ֹ�����
        p.add(numbers[1]);       //�Ѹ�����ť��ӵ����ֹ�������
        p.add(numbers[2]);
        p.add(numbers[3]);
        p.add(plus);
        p.add(numbers[4]);
        p.add(numbers[5]);
        p.add(numbers[6]);
        p.add(minus);
        p.add(numbers[7]);
        p.add(numbers[8]);
        p.add(numbers[9]);
        p.add(multi);
        p.add(dot);
        p.add(numbers[0]);
        p.add(sqrt);
        p.add(div);
        p.add(quyu);
        p.add(change);
        p.add(clear);
        p.add(equal);
        jf.add(jtf,BorderLayout.NORTH);  //����ʾ����ӵ�����Ҳ�������ϱ�
        jf.add(p,BorderLayout.CENTER);   //�Ѹ�����ť�ŵ�����
        numbers[0].addActionListener(this);  //����¼�������
        numbers[1].addActionListener(this);
        numbers[2].addActionListener(this);
        numbers[3].addActionListener(this);
        plus.addActionListener(this);
        numbers[4].addActionListener(this);
        numbers[5].addActionListener(this);
        numbers[6].addActionListener(this);
        minus.addActionListener(this);
        numbers[7].addActionListener(this);
        numbers[8].addActionListener(this);
        numbers[9].addActionListener(this);
        multi.addActionListener(this);
        dot.addActionListener(this);
        sqrt.addActionListener(this);
        div.addActionListener(this);
        equal.addActionListener(this);
        change.addActionListener(this);
        clear.addActionListener(this);
        quyu.addActionListener(this);
        
    }
    // �԰�ť���з�Ӧ�ķ���
    public void actionPerformed(ActionEvent e)
    {
        JButton btn = (JButton)e.getSource();
        if (btn == clear)
        {
            jtf.setText("0");
            dotExist = false;      //С���㡢��������Ⱥš��������һ�������
          operated = false; 
        equaled = false; 
            result = 0;
            lastOperator = '?';
        }
        else if (btn == equal)
        {
            operate('=');
            equaled = true;
        }
        else if (btn == plus)
        {
            operate('+');
            equaled = false;
        }
        else if (btn == minus)
        {
            operate('-');
            equaled = false;
        }
        else if (btn == multi)
        {
            operate('*');
            equaled = false;
        }
        else if (btn == div)
        {
            operate('/');
            equaled = false;
        }
        else if (btn==quyu){
         operate('%');
         equaled=false;
        }
        else if (btn == change)   //������
        {
            operate('��');
            operate('=');
            equaled = true;
        }
        else if (btn == sqrt)
        {
            operate('��');
            operate('=');
            equaled = true;
        }
        else
        {
            if (equaled)
              result = 0;
            for (int i = 0; i < 10; i++)
              if (btn == numbers[i])
              {
                  if (jtf.getText().equals("0"))
                    jtf.setText("" + i);
                  else if(! operated)    //������µĲ��������
                    jtf.setText(jtf.getText() + i);
                  else
                  {
                      jtf.setText("" + i);
                      operated = false;
                  }
              }
            if (btn == dot && ! dotExist)
            {
                jtf.setText(jtf.getText() + ".");
               
            }
        }
    }
    // ��������ķ���
    private void operate(char operator)
    {
        double currentNumber = Double.valueOf(jtf.getText()).doubleValue();
        if (lastOperator == '?')
          result = currentNumber;
        else if (lastOperator == '+')
         result += currentNumber;
        else if (lastOperator == '-')
         result -= currentNumber;
        else if (lastOperator == '*')
         result *= currentNumber;
        else if (lastOperator == '/')
         result /= currentNumber;
        else if(lastOperator=='%')
         result %=currentNumber;
        else if (lastOperator == '��')
         result *= -1;
        else if (lastOperator == '��')
         result = Math.sqrt(currentNumber);
        else if (lastOperator == '=' && equaled)
         result = currentNumber;
        
        jtf.setText("" + result);
        operated = true;
        lastOperator = operator;
    }

public static void main(String[] args)
    {new rf();   }      //������һ��rf��ʵ��
}

