package Thread;
/**
 * 优先级MAX_PRIORITY 10
 *      NORM_PRIORITY 5
 *      MIN_PRIORITY 1
 *      概率优先
 * @author tokido_saya
 *
 */
public class ThreadPriorityLevel {
	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();
		Thread proxy1 = new Thread(t1,"proxy1");
		MyThread t2 = new MyThread();
		Thread proxy2 = new Thread(t1,"proxy2");
		proxy1.setPriority(Thread.MAX_PRIORITY);
		proxy2.setPriority(Thread.NORM_PRIORITY);
		proxy1.start();
		proxy2.start();

		Thread.sleep(2000);

		t1.stop();
		t2.stop();
	}
}
