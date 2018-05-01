package com.revature.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String args[]) {

		List<Object> basket = new ArrayList<Object>();
		
		new Thread(new Producer(basket)).start();
		new Thread(new Consumer(basket)).start();
		
	}
}
