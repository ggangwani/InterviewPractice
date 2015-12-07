package multithreading.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadInterruptionExample14 {

	public static void main(String[] args) {
		//example1();
        example2();
	}

	
	public static void example1(){
		System.out.println("Starting.");
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Random random = new Random();		
				/*try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Thread is interrupted!");
					return;
				}*/
				for(int i=0;i<1E8; i++){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Interruped!!");
						break;
					}
					Math.sin(random.nextDouble());
				}
				
			}
		});
		t.start();
		// No effect by just calling this as this just sets a flag in the thread, unless we catch it with methods
		// like sleep, join, wait etc or check for the interruped flag explicitly
		t.interrupt();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished.");

	}
	
	
	public static void example2(){
		System.out.println("Starting.");
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Future<?> future = exec.submit(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				Random random = new Random();	
				for(int i=0;i<1E8; i++){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Interruped!!");
						break;
					}
					Math.sin(random.nextDouble());
				}
				return null;
			}
		});
		
		
		exec.shutdown();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// One way to interrupt using futures
		//future.cancel(true);
		// Second way where executor service marks all tasks with interrupted as true
		exec.shutdownNow();
		
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished.");
	}
	
}
