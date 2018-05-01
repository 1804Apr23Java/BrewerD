package com.revature.producerconsumer;
import java.util.*;

public class Consumer implements Runnable {
	
	private List<Object> basket;
	
	public Consumer(List<Object> basket) {
		this.basket = basket;
	}
	
	void pullFromBasket(int index) {
		basket.remove(index);
	}
	
	public void run() {
		try {
			this.consume();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void consume() throws InterruptedException {
		
		while(true) {
			
			System.out.println("Consumer");
			
			synchronized (this)
            {
				
                wait();
         
			int numVars = (int) (Math.random() * basket.size());

		for(int i = 1; i < numVars - 1; i++) {
			this.pullFromBasket(i);
			System.out.println("Consumed; new Size: " + basket.size());
			
		}
			notify();
			
			Thread.sleep(5000);
            }
        } 
	}
}                  