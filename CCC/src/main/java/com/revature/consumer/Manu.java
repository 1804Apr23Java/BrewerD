package com.revature.consumer;

public class Manu {
	
	private int id;
	private String name;
	
	public Manu() {
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setId(int id) { 
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Manu [id=" + id + ", name=" + name + "]";
	}

}
