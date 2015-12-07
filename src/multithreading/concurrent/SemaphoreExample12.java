package multithreading.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample12 {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i = 0;i < 200; i++){
			executor.submit(new Runnable() {
				
				@Override
				public void run() {
					Connection.getInstance().connect();
					
				}
			});
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Connection{
	private static Connection instance = new Connection();
	private int connections;
	
	//Step2 control the number of connections at one time
	Semaphore sem = new Semaphore(10);
	
	private Connection(){
		
	}
	
	public static Connection getInstance(){
		return instance;
	}

	public void connect(){
		try {
			sem.acquire();
			System.out.println("Available permits: " + sem.availablePermits());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try{
			doConnect();
		}finally{
			sem.release();
		}
	}
	
	public void doConnect(){
	   synchronized (this) {
		 connections++;
		 System.out.println("Current connections: " + connections);
	   }
		
	   try {
		   Thread.sleep(3000);
	   } catch (InterruptedException e) {
		   e.printStackTrace();
	   }
	   
	   synchronized (this) {
		   connections--;
	   }
	   
	}
	
	
}
