package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicMultipleLockSynchronizedExample4 {

	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.work();
	}

}

class Worker {
	
	Object lock1 = new Object();
	Object lock2 = new Object();
	
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();
	Random random = new Random();
	
	public void stage1(){
		// Step4 add separate lock objects
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			list1.add(random.nextInt(100));
		}
		
	}
	
	// Step 3 - add synchronized at method level but time of processing doubles - to 4 secs
	public /*synchronized*/ void stage2(){
		
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			list2.add(random.nextInt(100));
		}
		
	}
	
	public void process(){
		for(int i = 0;i < 1000; i++){
			stage1();
			stage2();
		}
	}
	
	public void work(){
		System.out.println("Starting...");
		long start = System.currentTimeMillis();
		// Step 1
		//process();
		
		//Step 2 We have 2 threads running parallely to do this job
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end-start));
		System.out.println("List1 size: " + list1.size() + ", List2 size: " + list2.size());
	}
}
