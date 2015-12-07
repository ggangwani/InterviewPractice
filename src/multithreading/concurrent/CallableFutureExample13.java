package multithreading.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample13 {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();
		Future</*Void*/Integer> future = executor.submit(new Callable</*Void*/Integer>() {

			@Override
			public /*Void*/ Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(1000);
				
				System.out.println("Starting...");
				
				if(duration < 500){
					throw new IllegalAccessError("You do not have access to the task");
				}
				
				Thread.sleep(duration);
				
				System.out.println("Finished...");
				//return null;
				return duration;
			}
		});
		
		executor.shutdown();
		
		try {
			System.out.println("Returned value from Callable: " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println(e.getCause().getMessage());
		}
	}

}


