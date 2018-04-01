package queue;
/**
 * 使用队列实现自定义堆栈
 * @author tokido_saya
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<E> {
	private Deque<E> container = new ArrayDeque<E>();
	private int cap;
	public MyStack(int cap) {
		super();
		this.cap = cap;
	}
	
	public boolean push(E e) {
		if(container.size()+1 > cap) {
			return false;
		}
		return container.offerLast(e);
	}
	
	public E pop() {
		return container.pollLast();
	}
	
	public E pick() {
		return container.peekLast();
	}
	public int size() {
		return this.container.size();
	}
}
