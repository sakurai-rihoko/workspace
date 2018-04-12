package Thread;
/**
 * Thread.currentThread()当前线程
 * setName()设置名称
 * getName()获取名称
 * isAlive()查看线程状态
 *
 * @author tokido_saya
 *
 */
public class InfoThread {
public static void main(String[] args) throws InterruptedException {
	MyThread t1 = new MyThread();
	Thread proxy = new Thread(t1);
	proxy.setName("测试线程");
	System.out.println(proxy.getName());
    System.out.println(Thread.currentThread().getName());
	proxy.start();
	System.out.println("启动时状态:"+proxy.isAlive());
	Thread.sleep(2000);
	t1.stop();
	Thread.sleep(2000);
	System.out.println("启动时状态:"+proxy.isAlive());
}
}
