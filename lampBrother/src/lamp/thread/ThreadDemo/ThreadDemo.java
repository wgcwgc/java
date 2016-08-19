package lamp.thread.ThreadDemo;
import java.util.Date;

//自定义线程类1（方法一）
class MyThread extends Thread{
	public void run() {
		System.out.println("当前线程的名字：" + Thread.currentThread().getName());
		for (int i = 0; i < 2; i ++) {
			System.out.println(new Date() + "-" + i);
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
//使用自定义线程1
//		MyThread myThread = new MyThread();
//		System.out.println("当前线程的名字：" + Thread.currentThread().getName());
//		myThread.start();//启动线程
		
		
		
		
		
		//自定义线程2
		MyRunnable myRuannable = new MyRunnable();
		Thread thread2 = new Thread(myRuannable,"白线程");
		thread2.setName("黑线程");//设置线程的名称
		System.out.println("当前线程是否活动状态：" + thread2.isAlive());
		/**
		 * 设置线程的优先级，
		 * 优先级高的抢到线程时间的概率大
		 */
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread2.start();
		System.out.println("当前线程是否活动状态：" + thread2.isAlive());
		System.out.println("当前线程的名字：" + Thread.currentThread().getName());
		
//		MyThread3 myThread3 = new MyThread3();
//		Thread thread3 = new Thread(myThread3);
//		thread3.start();
		
		for (int i = 0; i < 10; i++)
		{
			System.out.println("mian-" + i);
			if(i == 2){
				/**
				 * interrupt()方法只是设置了线程的中断状态为true，并没有真正的中断线程
				 * 可以采用自定义flag标记方法实现线程自己中断（见MyThread3）
				 */
				thread2.interrupt();//中断线程，设置了一个中断标记（中断状态为true）
//				myThread3.setFlag(false);
			}
			
			if(i == 4){
				try {
					thread2.join();//等待该线程终止.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				/**
				 * sleep 方法的原理
				 * 让当前线程进入休眠状态，让出当次执行的CPU时间，
				 * 但是该线程不丢失监视器的所属权
				 */
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//自定义线程2（方法二）
class MyRunnable implements Runnable{
	public void run() {
		System.out.println("当前线程的名字：" + Thread.currentThread().getName());
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
//自定义线程2
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
