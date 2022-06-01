package smallprojects.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * __author__ = vyh@vmware.com
 */
public class Consumer implements Runnable {

	private final BlockingQueue queue;
	private volatile boolean runFlag = true;

	Consumer(BlockingQueue queue){
		this.queue = queue;
	}


//	private final DataQueue dataQueue;
//	private volatile boolean runFlag;
//
//	Consumer(DataQueue dataQueue) {
//		this.dataQueue = dataQueue;
//		runFlag = true;
//	}

	@Override
	public void run() {
		consume();
	}

	public void consume() {
		while (runFlag) {
			try{
				Message message = (Message) queue.take();
				System.out.println("Consumer consumes: " + message);
			} catch (InterruptedException ie){
				System.out.println("Consumer got exception: " + ie.getStackTrace());
			}
//			Message message;
//			if (dataQueue.isEmpty()) {
//				try {
//					dataQueue.waitOnEmpty();
//				} catch (InterruptedException e) {
//					break;
//				}
//			}
//			if (!runFlag) {
//				break;
//			}
//			message = dataQueue.remove();
//			dataQueue.notifyAllForFull();
//			//useMessage(message);
		}
	}

	public void stop() {
		runFlag = false;
		//dataQueue.notifyAllForEmpty();
	}
}