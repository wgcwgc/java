package lamp.thread.ThreadDemo;
import java.util.Date;

//�Զ����߳���1������һ��
class MyThread extends Thread{
	public void run() {
		System.out.println("��ǰ�̵߳����֣�" + Thread.currentThread().getName());
		for (int i = 0; i < 2; i ++) {
			System.out.println(new Date() + "-" + i);
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
//ʹ���Զ����߳�1
//		MyThread myThread = new MyThread();
//		System.out.println("��ǰ�̵߳����֣�" + Thread.currentThread().getName());
//		myThread.start();//�����߳�
		
		
		
		
		
		//�Զ����߳�2
		MyRunnable myRuannable = new MyRunnable();
		Thread thread2 = new Thread(myRuannable,"���߳�");
		thread2.setName("���߳�");//�����̵߳�����
		System.out.println("��ǰ�߳��Ƿ�״̬��" + thread2.isAlive());
		/**
		 * �����̵߳����ȼ���
		 * ���ȼ��ߵ������߳�ʱ��ĸ��ʴ�
		 */
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread2.start();
		System.out.println("��ǰ�߳��Ƿ�״̬��" + thread2.isAlive());
		System.out.println("��ǰ�̵߳����֣�" + Thread.currentThread().getName());
		
//		MyThread3 myThread3 = new MyThread3();
//		Thread thread3 = new Thread(myThread3);
//		thread3.start();
		
		for (int i = 0; i < 10; i++)
		{
			System.out.println("mian-" + i);
			if(i == 2){
				/**
				 * interrupt()����ֻ���������̵߳��ж�״̬Ϊtrue����û���������ж��߳�
				 * ���Բ����Զ���flag��Ƿ���ʵ���߳��Լ��жϣ���MyThread3��
				 */
				thread2.interrupt();//�ж��̣߳�������һ���жϱ�ǣ��ж�״̬Ϊtrue��
//				myThread3.setFlag(false);
			}
			
			if(i == 4){
				try {
					thread2.join();//�ȴ����߳���ֹ.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				/**
				 * sleep ������ԭ��
				 * �õ�ǰ�߳̽�������״̬���ó�����ִ�е�CPUʱ�䣬
				 * ���Ǹ��̲߳���ʧ������������Ȩ
				 */
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//�Զ����߳�2����������
class MyRunnable implements Runnable{
	public void run() {
		System.out.println("��ǰ�̵߳����֣�" + Thread.currentThread().getName());
		for (int i = 0; i < 10; i++)
		{
			System.out.println("MyRunnable-" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
//�Զ����߳�2
class MyThread3 implements Runnable{
	private boolean flag = true;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void run() {
		@SuppressWarnings("unused")
		int i = 0;
		while(flag){
			System.out.println(Thread.currentThread().getName());
			i ++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
