package multithreading;

import java.util.LinkedList;
import java.util.Random;

// FIFO list implementation using producer consumer
public class BasicProducerConsumerExample9 {

	public static void main(String[] args) {
		ProducerConsumerWorker processor = new ProducerConsumerWorker();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
	}

}

class ProducerConsumerWorker{
	
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Random random = new Random();
	private Object lock = new Object();
	private int value = 0;
	
	public void produce() throws InterruptedException{
		while(true){
			synchronized (lock) {
				while(list.size() == LIMIT){
					System.out.println("Waiting to add");
					lock.wait();
					System.out.println("After wait()");
				}
				list.add(value++);
				System.out.println("Added");
				lock.notify();
			}
		}
		
	}
	
	public void consume() throws InterruptedException{
		while(true){
			synchronized (lock) {
				while(list.size() == 0){
					lock.wait();
				}
				Integer value = list.removeFirst();
				System.out.println("Value removed: " + value + ", List size: " + list.size());
				lock.notify();
			}
			Thread.sleep(random.nextInt(2000));
			
		}
		
	}
	
}