package wgc;
import javax.swing.*;//新的窗口组件包
import java.awt.*;
import java.awt.event.*;
public class rf  implements ActionListener
{   JFrame jf=new JFrame();
     boolean dotExist, operated, equaled; // 帮助运算的布尔变量
     double result; // 目前的结果
    char lastOperator; // 表示上一运算符
     JTextField jtf; // 显示栏
    JButton dot, plus, minus, multi, div, sqrt, equal, change, clear,quyu; // 运算符
    JButton[] numbers;
    Panel p=new Panel();
    
    public rf()    // 构造者
    {
       jf.setTitle("简易计算器");
        // 初始化变量
        dotExist = false; // 表示当前的数是否有小数点
        operated = false; // 表示任意运算符是否被按下
        equaled = false; // 表示等号是否被按下
        result = 0;
        lastOperator = '?';
        // 初始化窗口变量
        jtf = new JTextField("0");
        jtf.setEditable(false); //设置文本框的可编辑性
        jf.setSize(300,250);
        jf.setVisible(true);
        numbers = new JButton[10];
        for (int i = 0; i < 10; i++)
          numbers[i] = new JButton("" + i);  //从0到9，，10个数字按钮
        dot = new JButton(".");
        plus = new JButton("+");
        minus = new JButton("-");
        
        multi = new JButton("*");
        div = new JButton("/");
        sqrt = new JButton("√");
        equal = new JButton("=");
        change= new JButton("±");
        clear = new JButton("NC");   //复位
        quyu=new JButton("%");
        
        p.setLayout(new GridLayout(5,4)); //绘制一个5行4列的布局管理器
        p.add(numbers[1]);       //把各个按钮添加到布局管理器中
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
        jf.add(jtf,BorderLayout.NORTH);  //把显示框添加到北区也就是最上边
        jf.add(p,BorderLayout.CENTER);   //把各个按钮放到中区
        numbers[0].addActionListener(this);  //鼠标事件监听器
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
    // 对按钮进行反应的方法
    public void actionPerformed(ActionEvent e)
    {
        JButton btn = (JButton)e.getSource();
        if (btn == clear)
        {
            jtf.setText("0");
            dotExist = false;      //小数点、运算符、等号、结果、上一个运算符
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
        else if (btn == change)   //正负号
        {
            operate('±');
            operate('=');
            equaled = true;
        }
        else if (btn == sqrt)
        {
            operate('√');
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
                  else if(! operated)    //如果按下的不是运算符
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
    // 进行运算的方法
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
        else if (lastOperator == '±')
         result *= -1;
        else if (lastOperator == '√')
         result = Math.sqrt(currentNumber);
        else if (lastOperator == '=' && equaled)
         result = currentNumber;
        
        jtf.setText("" + result);
        operated = true;
        lastOperator = operator;
    }

public static void main(String[] args)
    {new rf();   }      //创建了一个rf的实例
}

