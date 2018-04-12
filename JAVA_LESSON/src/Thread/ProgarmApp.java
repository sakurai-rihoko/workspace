package Thread;

public class ProgarmApp {
	public static void main(String[] args) {
		/*2.启动多线程 使用静态代理
		 * 1)创建真实角色
		 * 2）创建代理角色+真实角色引用
		 * 3）调用.start()启动多线程
		 * */
		Program pro1 = new Program();
		Thread proxy = new Thread(pro1);
		proxy.start();
		for(int i = 0;i < 1000;i++) {
			System.out.println("主线程运算"+i);
			}
	}
}
