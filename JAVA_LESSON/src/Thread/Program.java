package Thread;
/**
 * 使用Runnable创建线程
 * 1.类实现Runnable接口+重写run（）---->真实角色
 * 2.启动多线程 使用静态代理
 * 1)创建真实角色
 * 2）创建代理角色+真实角色引用
 * 3）调用.start()启动多线程
 * @author tokido_saya
 *
 */
public class Program implements Runnable{
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i < 1000;i++) {
		System.out.println("多线程运算"+i);
		}
	}

	
}
