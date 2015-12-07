package multithreading;

import java.util.Scanner;

class Processor implements Runnable{

	// By making shared variable volatile, this thread does not cache the data
	private volatile boolean running = true;
	@Override
	public void run() {
		// This thread is reading shared variable "running" value
		while(running){
			System.out.println("Hello");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void shutdown(){
		running = false;
	}
}



public class BasicVolatileExample2 {

	public static void main(String[] args) {
		Processor processor = new Processor();
		Thread t = new Thread(processor);
		t.start();
		System.out.println("Hit enter to stop");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		// This main thread is writing to shared variable "running" value of other thread
		processor.shutdown();
	}

}
