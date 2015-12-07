package multithreading;


public class BasicSynchronizedExample3 {
	// count is the shared data
    private int count = 0;
	
	public static void main(String[] args) {
		BasicSynchronizedExample3 example = new BasicSynchronizedExample3();
		Thread t1 = new Thread(example.new SimpleProcessor());
		Thread t2 = new Thread(example.new SimpleProcessor());
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("count is : " + example.count);
	}
	
	// removing synchronized will give different results in each run
	private synchronized void incrementCount(){
		count++;
	}

	class SimpleProcessor implements Runnable{

		@Override
		public void run() {
			for(int i =0 ; i < 10000; i++){
				incrementCount();
			}
		}
		
	}
}
