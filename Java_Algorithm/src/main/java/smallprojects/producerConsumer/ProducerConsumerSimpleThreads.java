package smallprojects.producerConsumer;

import java.util.LinkedList;
import java.util.Random;

/**
 * __author__ = vyh@vmware.com
 *
 * https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/
 */
public class ProducerConsumerSimpleThreads {
	LinkedList<Integer> queue = new LinkedList<>();
	int capacity = 2;
	Random random = new Random();

	public void producer() throws InterruptedException{
    while (true) {
      synchronized (this) {
        if (queue.size() == capacity) wait();

        int value = random.nextInt(10);
        System.out.println("producer produced: " + value);
        queue.add(value);

        notify();
        Thread.sleep(1000);
			}
		}
	}

	public void consumer() throws InterruptedException{
		while(true){
      synchronized (this) {
        if (queue.size() == 0) wait();

        int value = queue.removeFirst();
        System.out.println("consumer consumed: " + value);

        notify();
        Thread.sleep(1000);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		ProducerConsumerSimpleThreads pc = new ProducerConsumerSimpleThreads();

		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				try{
					pc.producer();
				} catch (InterruptedException ec){
					ec.printStackTrace();
				}
			}
		});

		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				try{
					pc.consumer();
				} catch (InterruptedException ie){
					ie.printStackTrace();
				}
			}
		});

		producer.start();
		consumer.start();

		producer.join();
		consumer.join();

	}

}
