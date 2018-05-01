package com.revature.MultiThreadTwo;

public class Threader implements Runnable {
	
	Thread t1;
	Thread t2;
	
	Threader() {
		t1 = new Thread(this, "Thread0");
		t2 = new Thread(this, "Thread1");
		t1.start();
		t2.start();
	}
	
	public void run() {
		System.out.println("inside run() function");
	}
	
	 public static void main(String args[]) {
		 new Threader();
		 System.out.println("Hi.");
	 }

}
