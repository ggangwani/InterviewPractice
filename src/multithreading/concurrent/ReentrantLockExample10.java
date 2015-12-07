package multithreading.concurrent;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample10 {

	public static void main(String[] args) {

		Runner runner = new Runner();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					runner.firstThread();
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
					runner.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		runner.finished();
	}

}

class Runner{
	
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	private void increment(){
		for(int i=0;i<10000;i++){
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException{
		lock.lock();
		System.out.println("Waiting...");
		condition.await();
		System.out.println("Woken up!");
		try{
			increment();
		}
		finally{
			lock.unlock();
		}
	}
	
	public void secondThread() throws InterruptedException{
		Thread.sleep(1000);
		lock.lock();
		
		System.out.println("Press Enter key");
		new Scanner(System.in).nextLine();
		System.out.println("Enter key Pressed");
		condition.signal();
		
		try{
			increment();
		}
		finally{
			lock.unlock();
		}
	}
	
	public void finished(){
		System.out.println("Count is: " + count);
	}
	
}
