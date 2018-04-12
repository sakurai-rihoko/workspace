package Thread;

public class ThreadJoin implements Runnable{
	public static void main(String[] args) throws InterruptedException {
		ThreadJoin tj = new ThreadJoin();
		Thread t = new Thread(tj);
		t.start();
		for(int i = 0;i< 1000;i++ ) {
			if(i == 50) {
				t.join();//合并线程，main阻塞
			}
			System.out.println("main running"+ i);
		}
	}
	public void run() {
		for(int i = 0;i < 100000;i++) {
			System.out.println("thread running"+i);
		}
	}
}
