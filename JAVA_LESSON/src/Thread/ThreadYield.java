package Thread;

public class ThreadYield implements Runnable{
	public static void main(String[] args) throws InterruptedException {
		ThreadYield tj = new ThreadYield();
		Thread t = new Thread(tj);
		t.start();
		for(int i = 0;i< 1000;i++ ) {
			if(i % 5==0) {
				t.yield();//暂停main线程，写在谁的线程中暂停谁
			}
			System.out.println("main running"+ i);
		}
	}
	public void run() {
		for(int i = 0;i < 1000;i++) {
			System.out.println("thread running"+i);
		}
	}
}
