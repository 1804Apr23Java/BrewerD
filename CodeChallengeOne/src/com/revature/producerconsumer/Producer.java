package com.revature.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Producer<T> {
	
	List<T> list = new ArrayList<>();
	
	synchronized public void produce(){

		Random r = new Random();
		
		int ranVar = r.nextInt(50) + 1;
		
		while(list.size() < ranVar)
			list.add((T) new Object());
		
		System.out.println("Produced; new Size: " + list.size());

	}
	
	public<T> List<T> returnList(){
		return (List<T>) list;
	}
	
	

}
