package Thread;
/**
 * 单例创建的几种模式
 * 1.懒汉式
 *  1）构造器私有化
 *  2）声明私有的静态属性
 *  3）对外提供访问属性的静态方法，确保该对象存在
 * @author tokido_saya
 *
 */
public class MyJvm {
	private static MyJvm INSTANCE;
	private MyJvm() {
		
	}
	public static MyJvm getInstance() {
		if(INSTANCE == null) {//提高效率
			synchronized (MyJvm.class) {
				if(INSTANCE == null) {//保证安全
					INSTANCE = new MyJvm();
				}
				
			}	
		}
		return INSTANCE;
	}
}
/**
 * 饿汉式
 * 1)构造器私有化
 * 2）声明私有的静态属性，同时创建该对象
 * 3）对外提供访问属性的静态方法
 * @author tokido_saya
 *
 */
class MyJvm2{
	private static MyJvm2 INSTANCE = new MyJvm2() ;
	private MyJvm2() {
		
	}
	public static MyJvm2 getInstance() {
		
		return INSTANCE;
	}
}
/**
 * 类在使用时加载，延缓加载时间
 * @author tokido_saya
 *
 */
class MyJvm3{
	private static class JVMholder{
	private static MyJvm3 INSTANCE = new MyJvm3() ;
	}
	private MyJvm3() {
		
	}
	public static MyJvm3 getInstance() {
		
		return JVMholder.INSTANCE;
	}
}
