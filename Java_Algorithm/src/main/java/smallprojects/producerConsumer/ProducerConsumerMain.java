package smallprojects.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * __author__ = vyh@vmware.com
 *
 * https://www.baeldung.com/java-producer-consumer-problem
 * and using thread safe BlockingQueue
 * https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/BlockingQueue.html
 */
public class ProducerConsumerMain {

	public static void main(String[] args){
		BlockingQueue<Message> queue = new LinkedBlockingQueue<>(20);

		Producer producer = new Producer(queue);
		for( int i = 0; i < 100; i++){
			Thread producerThread = new Thread(producer::produce);
			producerThread.start();
		}

		Consumer consumer = new Consumer(queue);
		for(int i = 0; i < 10; i++){
			Thread consumerThread = new Thread(consumer::consume);
			consumerThread.start();
		}

		producer.stop();
		consumer.stop();

		/* Use DataQueue */
//		int  MAX_QUEUE_CAPACITY = 2;
//		DataQueue dataQueue = new DataQueue(MAX_QUEUE_CAPACITY);
//
//		Producer producer = new Producer(dataQueue);
//		Thread producerThread = new Thread(producer);
//
//		Consumer consumer = new Consumer(dataQueue);
//		Thread consumerThread = new Thread(consumer);
//
//		producerThread.start();
//		consumerThread.start();
//
//		producer.stop();
//		consumer.stop();
	}
}
