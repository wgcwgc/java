/**
 * 
 */
package com;

/**
 * @author Jeff
 *
 */
import java.util.Scanner;
public class 账户 //class的名字可以自己新建和这个一样或者别的
{
public static void main(String[] args) {
double chushi_jine  = 1000.0;//初始金额
int kahao = 1314;//卡号
int password = 520;
int xuanze;
int cunqu_kuan;
String name = "张三";//用户姓名
@SuppressWarnings("resource")
Scanner s = new Scanner(System.in);//定义扫描器
while (true) {
System.out.println("欢迎进入系统");
System.out.println("请输入您的卡号：");
int js_kahao = s.nextInt();//接受用户输入卡号
System.out.println("请输入您的密码:");
int js_password = s.nextInt();
if (js_kahao == kahao && js_password == password) //如果卡号和密码都正确
{
System.out.println("您的用户名为：" + name + "，" + "卡上金额为"+ chushi_jine);
System.out.println("存款请选择1，取款选择2");
xuanze = s.nextInt();//用来接受用户的输入
if (xuanze != 1 && xuanze != 2)//如果输入的不是1或者2
{
System.out.println("输入错误，退出系统 重新输入");//提示错误 退出系统
continue;//跳过下面的代码 回去for重新执行
}
else//如果输入的是1和2
{
if (xuanze == 1) //判断输入的是不是1
{
System.out.println("请输入要存款的金额");
cunqu_kuan = s.nextInt();
if (cunqu_kuan <= 0) //如果存款小于等于0 提示错误
{
System.out.println("存款失败，输入不合法，请至少存1元。");
} 
else //否则提示成功
{
chushi_jine += cunqu_kuan;//把存款的金额加上原来的金额
System.out.println("存款" + cunqu_kuan+ "元成功，您的卡里现在有" + chushi_jine + "元");
continue;
   }
    } 
else //判断是不是2
{
System.out.println("请输入要取款的金额");
cunqu_kuan = s.nextInt();
if (cunqu_kuan > chushi_jine)//取款的钱超过卡里的钱 
{
System.out.println("对不起余额不足");
   } 
else//取款成功 
{
chushi_jine -= cunqu_kuan;
System.out.println("取款" + cunqu_kuan+ "元成功，您的卡里现在有" + chushi_jine + "元");
continue;
}
       }
}
}
else//卡号和不正确的时候 
{
System.out.println("您的卡号或者密码输入不正确");
continue;
}
}
}
}