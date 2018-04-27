package designModel;
/**
 * 单例模式
 * @author tokido_saya
 *
 */
public class SingletonDemo {
/**
 * 静态内部类实现单例，线程安全，效率高，延时加载
 *
 */
	private static class SingletonClassInstance{
		private static final SingletonDemo  instance = new SingletonDemo();
	}
	private SingletonDemo() {

	}


	/*
	 * 枚举实现单例
	 */
	 enum enumSingleton{
		INSTANCE;//枚举元素单例对象
	}
	 //操作添加
	 public void singletonOperation() {

	 }

}


/*
饿汉式单例模式

*/
class  HungryMan{
	//类初始化时立即加载,无需添加同步，安全
	private static HungryMan instance = new HungryMan();

	private HungryMan() {

	}
	public  static HungryMan getInstance() {
		return instance;
	}
}
/*
懒汉式单例模式
*/

class LazyMan{
	private static LazyMan instance;

	private LazyMan() {

	}
	public static synchronized LazyMan getInstance() {//延时加载
		if(instance == null) {
			instance = new LazyMan();
		}
		return instance;
	}
}
/*
 * 双重检查锁式
 */
class DoubleCheckLock{
	private static DoubleCheckLock instance = null;
	private DoubleCheckLock() {

	}
	public static DoubleCheckLock getInstance() {
		if(instance == null) {
			DoubleCheckLock sc;

		synchronized (DoubleCheckLock.class) {
			sc = instance;
			if(sc == null) {
				synchronized (DoubleCheckLock.class) {
					if(sc == null) {
						sc = new DoubleCheckLock();
					}
					instance = sc;
				}
			}
		}
		}
		return instance;
	}
}

