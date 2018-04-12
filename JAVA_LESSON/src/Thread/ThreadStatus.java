package Thread;
/**
 * 停止线程
 * 1.自然结束线程任务
 * 2.外部干涉
 * 1）线程类中定义线程体使用的标识
 * 2）线程体使用该标识
 * 3)提供对外的方法改变标识
 * @author tokido_saya
 *
 */
public class ThreadStatus {
  public static void main(String[] args) {
	  Study s = new Study();
	  new Thread(s).start();
	  for(int i=0;i<100;i++) {
		  if(50==i) {
			  s.stop();
		  }
		  System.out.println("main......");
	  }
	  
}

}
class Study implements Runnable{
	private boolean flag = true;
	public void run() {
		while(flag) {
			System.out.println("study thread.....");
		}
	}
	public void stop() {
		this.flag = false;
	}
}
