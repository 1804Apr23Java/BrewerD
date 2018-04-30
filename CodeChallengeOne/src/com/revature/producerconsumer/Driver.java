package com.revature.producerconsumer;

public class Driver {
	
	public static void main(String args[]) {

		MyThread T1 = new MyThread();
		
		T1.start();
		Consumer c = new Consumer();
		c.start();
	}
}
