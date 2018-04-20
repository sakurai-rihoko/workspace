package schedual;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Timer()
 * schedule(TimerTask task,Date time)//单次运行
 * schedule(TimerTask task,Date firstTime,long period)//多次运行
 * QUARTZ第三方包
 * @author tokido_saya
 *
 */

public class TimeDemo01 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask tk = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("alterX");

			}
		};
		timer.schedule(tk, new Date(System.currentTimeMillis()+1000),2000);
	}
}
