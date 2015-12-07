package multithreading.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 class TaskProcessor implements Runnable{

	private CountDownLatch latch;
	
	public TaskProcessor(CountDownLatch latch){
		this.latch = latch;
	}
	
	
	@Override
	public void run() {
		System.out.println("Started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("Completed ");
	}
	
}

public class CountDownLatchExample6 {

	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for(int i = 0;i<3;i++){
			executor.submit(new TaskProcessor(latch));
		}
		
		executor.shutdown();
		System.out.println("All submitted");
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All completed");
	}

}
