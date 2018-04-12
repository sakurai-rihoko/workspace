package Thread;
/**
 * 模拟网络延时+线程安全
 */
public class Web12306 implements Runnable{
	private int ticketNum = 100;
	private boolean flag = true;
	public void run() {
		while(flag) {
			testSyn();
			testSyn2();
		}
	}
	public static void main(String[] args) {
		//真实角色
		Web12306 web12306 = new Web12306();
		Thread t1 = new Thread(web12306);
		Thread t2 = new Thread(web12306);
		Thread t3 = new Thread(web12306);
		Thread t4 = new Thread(web12306);
		Thread t5 = new Thread(web12306);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	public synchronized void testSyn() {
		if(ticketNum <=0) {
			this.flag = false;
			return;
		}
		try {
			Thread.sleep(500);//run方法无法对外声明延时
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//a->1 b->0 c->-1并发
		System.out.println(Thread.currentThread().getName()+"抢到了，剩余票数"+ticketNum--);
	}
	public  void testSyn2() {
		synchronized (this) {
			if(ticketNum <=0) {
				this.flag = false;
				return;
			}
			try {
				Thread.sleep(500);//run方法无法对外声明延时
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//a->1 b->0 c->-1并发
			System.out.println(Thread.currentThread().getName()+"抢到了，剩余票数"+ticketNum--);
		}
	}
		
}
