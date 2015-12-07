package multithreading;

import java.util.Scanner;

public class BasicWaitNotifyExample8 {

	public static void main(String[] args){

		ProducerConsumerProcessor processor = new ProducerConsumerProcessor();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t2.start();
	}

}

class ProducerConsumerProcessor{
	
	public void produce() throws InterruptedException{
		synchronized (this) {
			System.out.println("Started producer thread...");
			// Wait releases the lock and thread is blocked waiting for a notify signal
			wait();
			System.out.println("Resumed");
		}
		
	}
	
	public void consume() throws InterruptedException{
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized(this){
			System.out.println("Hit enter key ");
			scanner.nextLine();
			System.out.println("Enter key pressed");
			// Calling notify itself does not release the lock. 
			// The lock is released only after exiting synchronized block
			notify();
			Thread.sleep(5000);
		}
		
	}
}
