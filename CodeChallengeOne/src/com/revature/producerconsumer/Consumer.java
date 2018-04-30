package com.revature.producerconsumer;
import java.util.*;

public class Consumer<T> extends Thread {
	
	public void run(List<T> list) {
		this.consume(list);
	}
	
	synchronized public <T> List<T> consume(List<T> list) {
		
		Random r = new Random();
		int numVars = 0;
		numVars = list.size();
		numVars = r.nextInt(numVars) + 1;
		
		while(true) {
			numVars = r.nextInt(list.size());
		for(int i = numVars; i > 0; i--)
			list.remove(numVars);
		
			System.out.println("Consumed; new Size: " + list.size());
		
			return list;
		
		}
	}
}
