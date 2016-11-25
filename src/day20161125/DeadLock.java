package day20161125;

import java.util.concurrent.TimeUnit;

public class DeadLock {
	private Object lock_1 = new int[1]; 
	private Object lock_2 = new int[1];  
	public void method1() {
		System.out.println("等待lock_1....");
		  synchronized(lock_1){
			  System.out.println("mothod1-lock_1-被锁....");
			  delay(500) ;
			  System.out.println("等待lock_2....");
			  synchronized(lock_2){
				  delay(500) ;
			  }
		  }
	}  
		  
	public void method2() {  
		System.out.println("等待lock_2....");
		 synchronized(lock_2){
			 System.out.println("mothod2-lock_2-被锁....");
			  delay(500) ;
			  System.out.println("等待lock_1....");
			  synchronized(lock_1){
				  delay(500) ;
			  }
		  }
	}  
	public static void main(String[] args) {
		final DeadLock dead_lock = new DeadLock();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				dead_lock.method1();
			}
		}).start() ;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				dead_lock.method2();
			}
		}).start() ;
	}
	
	private void delay(int delay){
		try {
			TimeUnit.MILLISECONDS.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
