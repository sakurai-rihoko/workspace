package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 使用callable创建线程
 * @author tokido_saya
 *
 */
public class call {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建线程
		ExecutorService ser =  Executors.newFixedThreadPool(2);
		Race player01 = new Race("美羽",1000);
		Race player02 = new Race("由希子",500);
		//获取值
		Future<Integer> result01 = ser.submit(player01);
		Future<Integer> result02 = ser.submit(player02);
		Thread.sleep(2000);
		player01.setFlag(false);
		player02.setFlag(false);
 		int num01 = result01.get();
 		int num02 = result02.get();
		System.out.println(num01);
		System.out.println(num02);
		//停止服务
		ser.shutdownNow();
	}
}
class Race implements Callable<Integer>{
	private String name;
	private long time;
	private boolean flag = true;
	private int step = 0;
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		while(flag) {
			Thread.sleep(time);
			step++;
		}
		return step;
	}
	public Race() {

	}
	public Race(String name,long time) {
		this();
		this.name = name;
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}

}
