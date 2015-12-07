package multithreading.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample11 {

	public static void main(String[] args) {
		AccountRunner runner = new AccountRunner();
		Thread t1= new Thread(new Runnable() {
			
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
		
		t1.start();
		Thread t2= new Thread(new Runnable() {
			
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
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		runner.finished();
	}
}

class AccountRunner{
	
	private Account account1 = new Account();
	private Account account2 = new Account();
	private Random random = new Random();
	
	//Second step add locks
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	private void acquireLock(Lock firstLock, Lock secondLock) throws InterruptedException{
		
		while(true){
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			try{
				// First try to get the locks for both
				gotFirstLock = firstLock.tryLock();
   			    gotSecondLock = secondLock.tryLock();
			}finally{
				// If both successful return 			
				if(gotFirstLock && gotSecondLock){
					return;
				}
				// Lock not acquired for both, so unlock everything and try again after a while
				if(gotFirstLock){
					firstLock.unlock();
				}
				if(gotSecondLock){
					secondLock.unlock();
				}
		}
			Thread.sleep(1);
		}
		
	}
	
	public void firstThread() throws InterruptedException{
		for(int i=0;i<10000;i++){
			acquireLock(lock1, lock2);
			try{
				Account.transfer(account1, account2, random.nextInt(100));
			}finally{
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	public void secondThread() throws InterruptedException{
		for(int i=0;i<10000;i++){
			// step3 reverse the order of locks, uncomment to see deadlock
			// lock2.unlock();
			// lock1.unlock();
			
			// step 4 use tryLock method to avoid deadlocks
			acquireLock(lock2, lock1);
			try{
				Account.transfer(account2, account1, random.nextInt(100));
			}finally{
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	public void finished(){
		System.out.println("Account1 balance: " + account1.getBalance());
		System.out.println("Account2 balance: " + account2.getBalance());
		System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()));
	}
}

class Account{
	private int balance = 10000;
	
	public void deposit(int amount){
		balance += amount;
	}
	
	public void withdraw(int amount){
		balance -= amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public static void transfer(Account ac1, Account ac2, int amount){
		ac1.withdraw(amount);
		ac2.deposit(amount);
	}
}

