/**
 * 
 */
package com;

/**
 * @author Jeff
 *
 */
import java.util.Scanner;
public class �˻� //class�����ֿ����Լ��½������һ�����߱��
{
public static void main(String[] args) {
double chushi_jine  = 1000.0;//��ʼ���
int kahao = 1314;//����
int password = 520;
int xuanze;
int cunqu_kuan;
String name = "����";//�û�����
@SuppressWarnings("resource")
Scanner s = new Scanner(System.in);//����ɨ����
while (true) {
System.out.println("��ӭ����ϵͳ");
System.out.println("���������Ŀ��ţ�");
int js_kahao = s.nextInt();//�����û����뿨��
System.out.println("��������������:");
int js_password = s.nextInt();
if (js_kahao == kahao && js_password == password) //������ź����붼��ȷ
{
System.out.println("�����û���Ϊ��" + name + "��" + "���Ͻ��Ϊ"+ chushi_jine);
System.out.println("�����ѡ��1��ȡ��ѡ��2");
xuanze = s.nextInt();//���������û�������
if (xuanze != 1 && xuanze != 2)//�������Ĳ���1����2
{
System.out.println("��������˳�ϵͳ ��������");//��ʾ���� �˳�ϵͳ
continue;//��������Ĵ��� ��ȥfor����ִ��
}
else//����������1��2
{
if (xuanze == 1) //�ж�������ǲ���1
{
System.out.println("������Ҫ���Ľ��");
cunqu_kuan = s.nextInt();
if (cunqu_kuan <= 0) //������С�ڵ���0 ��ʾ����
{
System.out.println("���ʧ�ܣ����벻�Ϸ��������ٴ�1Ԫ��");
} 
else //������ʾ�ɹ�
{
chushi_jine += cunqu_kuan;//�Ѵ��Ľ�����ԭ���Ľ��
System.out.println("���" + cunqu_kuan+ "Ԫ�ɹ������Ŀ���������" + chushi_jine + "Ԫ");
continue;
   }
    } 
else //�ж��ǲ���2
{
System.out.println("������Ҫȡ��Ľ��");
cunqu_kuan = s.nextInt();
if (cunqu_kuan > chushi_jine)//ȡ���Ǯ���������Ǯ 
{
System.out.println("�Բ�������");
   } 
else//ȡ��ɹ� 
{
chushi_jine -= cunqu_kuan;
System.out.println("ȡ��" + cunqu_kuan+ "Ԫ�ɹ������Ŀ���������" + chushi_jine + "Ԫ");
continue;
}
       }
}
}
else//���źͲ���ȷ��ʱ�� 
{
System.out.println("���Ŀ��Ż����������벻��ȷ");
continue;
}
}
}
}