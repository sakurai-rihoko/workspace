package Thread;
/**
 * 模拟龟兔赛跑
 * 1.创建多线程继承Thread + 重写run（线程体）
 * 2.使用线程：创建子类对象+对象.Start() 线程启动
 * @author tokido_saya
 *
 */
public class Demo01 extends Thread {

	@Override
	public void run() {
		for(int i = 0;i < 1000 ;i++) {
			System.out.println("兔子跑了"+i );
		}
	}

}

 class Rabbit extends Thread {

	@Override
	public void run() {
		for(int i = 0;i < 1000 ;i++) {
			System.out.println("兔子跑了"+i );
		}
	}

}
 class Tortoise extends Thread {

	@Override
	public void run() {
		for(int i = 0;i < 100 ;i++) {
			System.out.println("龟跑了"+i );
		}
	}

}