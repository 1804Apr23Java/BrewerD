package com.revature.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class MyThread<T> extends Thread {
	
	//List<T> list = new ArrayList<>();
	
	public void run() {
		
		
		Producer<T> p = new Producer<T>();
		//Consumer c = new Consumer();
		
		while(true) {
			p.produce();
			//c.consume(list);
		}
	}
}
