package Thread;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 倒计时
 *
 * @author tokido_saya
 *
 */
public class ThreadSleep {
	public static void main(String[] args) throws InterruptedException {
		testSleep02();
	}
	public static void testSleep() throws InterruptedException {
		int num = 10;
		while(true) {
			System.out.println(num--);
			Thread.sleep(1000);//线程等待
			if(num <= 0) {
				break;
			}
		}
	}
	public static void testSleep02() throws InterruptedException {
		Date endTime = new Date(System.currentTimeMillis()+10*1000);
		long end = endTime.getTime();

		while(true) {
			//输出
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			//等待一秒
			Thread.sleep(1000);
			//构建下一秒
			endTime = new Date(endTime.getTime()-1000);

			//10秒以内继续否则退出
			if(end-10000>endTime.getTime()) {
				break;
			}

		}
	}
	
	
}
