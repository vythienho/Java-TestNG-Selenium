package smallprojects.producerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * __author__ = vyh@vmware.com
 */
public class Producer implements Runnable {

	private final BlockingQueue dataQueue;
	//private final DataQueue dataQueue;
	private volatile boolean runFlag = true;
	private int idIndex = 0;
	private double dataIndex = 0.0;

	public Producer(BlockingQueue dataQueue){
		this.dataQueue = dataQueue;
	}
//	public Producer(DataQueue dataQueue) {
//		this.dataQueue = dataQueue;
//		runFlag = true;
//	}

	@Override
	public void run() {
		produce();
	}

	public void produce() {
		while (runFlag) {
			Message message = new Message(idIndex++, dataIndex++);
			System.out.println("Producer produced: " + message);
			dataQueue.offer(message);

			//Message message = generateMessage();
			//while (dataQueue.isFull()) {
				//try {
				//	dataQueue.waitOnFull();
				//} catch (InterruptedException e) {
				//	break;
				//}
			//}
			//if (!runFlag) {
			//	break;
			//}
			//dataQueue.add(message);
			//dataQueue.notifyAllForEmpty();
		}
	}

	public void stop() {
		runFlag = false;
		//dataQueue.notifyAllForFull();
	}
}
