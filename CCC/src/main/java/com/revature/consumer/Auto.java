package com.revature.consumer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Auto {

		private String model;
		private Manu name;
		
		public Auto() {
		}
		
		public String getModel() {
			return model;
		}
		
		public void setModel(String model) {
			this.model = model;
		}
		
		@Override
		public String toString() {
			return "RestConsumer [model=" + model + ", name=" + name + "]";
		}

		public Manu getName() {
			return name;
		}
		
		public void setName(Manu name) {
			this.name = name;
			
		}

}
