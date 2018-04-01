package queue;

import java.util.ArrayDeque;
import java.util.*;
public class queue {
	public static void main(String[] args) {
		Queue<Request> q1 = new ArrayDeque<Request>();
		
		//模拟排队
		for(int i=0;i < 10;i++) {
			final int num = i;
			q1.offer(new Request(){
				public void deposit() {
					System.out.println("第"+num+"个人，办理存款业务，存款额度："+(Math.random()*10000));
				}
			});
		}
		dealWith(q1);
	}
	public static void dealWith(Queue<Request> que) {
		Request req = null;
		while(null!=(req = que.poll() )) {
			req.deposit();
		}
	}
	interface Request{
		void deposit();
	}
}
