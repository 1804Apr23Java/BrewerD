package com.revature.producerconsumer;
import java.util.List;

public class Producer implements Runnable {
	
	List<Object> basket;
	
	public Producer(List<Object> basket) {
		this.basket = basket;
	}
	
	void pushToBasket(Object o) {
		basket.add(o);
	}
	
	@Override
	public void run() {
			try {
				this.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}		
	
	public void produce() throws InterruptedException {

		while(true) {
			
			System.out.println("Producer");
			
			synchronized (this)
            {
			
	           wait(); // wait here instead of looping like a jerk
			
			this.pushToBasket(new Object());
			
			System.out.println("Produced; new Size: " + basket.size());
			
			notify();
			
			Thread.sleep(5000);
            }
        }
	}		
}
