package Thread;



/**
 * 单例设计模式：确保一个类只有一个对象
 * @author tokido_saya
 *
 */
public class SynClass {
	public static void main(String[] args) {
		JvmThread t1 = new JvmThread(1000);
		JvmThread t2 = new JvmThread(500);
		t1.start();
		t2.start();
	}
}
class JvmThread extends Thread{
	private long time;
	public JvmThread() {

	}

	public JvmThread(long time) {
		this.time = time;
	}
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+":"+Jvm.getInstance(time));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
/**
 * 确保一个类只有一个对象
 * 单例
 * 1.构造器私有化，避免外部调用
 * 2.声明一个私有的静态变量
 * 3.创建一个对外的公共的静态方法访问变量，如果变量没有对象，创建该对象
 * @author tokido_saya
 *
 */
class Jvm{
	//声明一个私有的静态变量
	private static Jvm instance =null;
	//构造器私有化，避免外部直接创建对象
	private Jvm() {

	}
	public static  Jvm getInstance(long time) throws InterruptedException {//增加synchronized保障对象唯一性
		if(null==instance) {//经典双重检查，提高已经存在对象的效率
		synchronized(Jvm.class) {//静态类没有this需要检查模板
		if(null == instance) {
			Thread.sleep(time);//方法错误
			instance = new Jvm();
		}
		}
	}
		return instance;
	}
}
