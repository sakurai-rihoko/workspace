package Commons;

import java.util.Queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * 队列
 * 1.循环队列
 * 2.只读不可改变队列
 * 3.断言队列
 * queue
 * @author tokido_saya
 *
 */
public class Demo5 {
	public static void main(String[] args) {
		circular();
		readOnlyQueue();
	}

	public static void predicate() {
		CircularFifoQueue<String> que  = new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Predicate notNUll = NotNullPredicate.INSTANCE;
		Queue<String> que2 = PredicatedQueue.predicatedQueue(que, notNUll);
		que2.add(null);
	}
	public static void readOnlyQueue() {
		CircularFifoQueue<String> que  = new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Queue<String> readOnlyQue = UnmodifiableQueue.unmodifiableQueue(que);
		readOnlyQue.add("e");
	}

	public static void circular() {
		CircularFifoQueue<String> que  = new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		for(int i = 0;i < que.size();i++) {
			System.out.println(que.get(i));
		}
	}
}
