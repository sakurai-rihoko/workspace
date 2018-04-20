package Thread;

public class SynDemo03 {
	public static void main(String[] args) {
		Object goods = new Object();
		Object money = new Object();
		Test t1 = new Test(goods,money);
		Test2 t2 = new Test2(goods,money);
		Thread proxy = new Thread(t1);
		Thread proxy2 = new Thread(t2);
		proxy.start();
		proxy2.start();
	}
}
class Test implements Runnable{
	Object goods ;
	Object money ;

	public Test(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	public void run() {
		while(true) {
			test();
		}
	}
	public void test() {
		synchronized (goods) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (money) {

			}
		}
		System.out.println(Thread.currentThread().getName()+"一手给钱");
	}
}
class Test2 implements Runnable{
	Object goods ;
	Object money ;

	public Test2(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	public void run() {
		while(true) {
			test2();
		}
	}
	public void test2() {
		synchronized (money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (goods) {

			}
		}
		System.out.println(Thread.currentThread().getName()+"一手给货");
	}
}