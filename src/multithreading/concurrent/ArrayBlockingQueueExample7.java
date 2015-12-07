package multithreading.concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Producer consumer problem using array blocking queue
public class ArrayBlockingQueueExample7 {

	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	private Random random = new Random();
	
	
	public static void main(String[] args) {

		ArrayBlockingQueueExample7 obj = new ArrayBlockingQueueExample7();
		Thread producerThread = new Thread(obj.new Producer());
		producerThread.start();
		Thread consumerThread = new Thread(obj.new Consumer());
		consumerThread.start();
	}

	
	class Producer implements Runnable{

		@Override
		public void run() {
			while(true){
				try {
					queue.put(random.nextInt(100));
					System.out.println("Value added: Queue Size is:"+queue.size() );
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	class Consumer implements Runnable{

		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(100);
					if(random.nextInt(10) == 0){
						Integer value = queue.take();
						System.out.println("Value taken: " + value + ", Queue size is: " + queue.size());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
