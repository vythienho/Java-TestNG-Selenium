package smallprojects.producerConsumer;

import java.util.Queue;
import java.util.LinkedList;

/**
 * __author__ = vyh@vmware.com
 *
 * This class is not used if we go with BlockingQueue
 */
public class DataQueue {
	private final Queue<Message> queue = new LinkedList<>();
	private int maxSize;
	private final Object FULL_QUEUE = new Object();
	private final Object EMPTY_QUEUE = new Object();

	DataQueue(int maxSize){
		this.maxSize = maxSize;
	}

	public void waitOnFull() throws InterruptedException{
		synchronized (FULL_QUEUE){
			FULL_QUEUE.wait();
		}
	}

	public void notifyAllForFull() {
		synchronized (FULL_QUEUE){
			FULL_QUEUE.notifyAll();
		}
	}

	public void waitOnEmpty() throws InterruptedException{
		synchronized (EMPTY_QUEUE){
			EMPTY_QUEUE.wait();
		}
	}

	public void notifyAllForEmpty(){
		synchronized (EMPTY_QUEUE) {
			EMPTY_QUEUE.notifyAll();
		}
	}

	public void add(Message message){
		synchronized (queue){
			queue.add(message);
		}
	}

	public Message remove(){
		synchronized (queue){
			return queue.poll();
		}
	}
}
