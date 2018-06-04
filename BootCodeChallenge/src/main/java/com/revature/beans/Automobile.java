package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="AUTOMOBILE")
public class Automobile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1564373227460000915L;

	public Automobile(int id, String model, Manufacturer manufacturer) {
		super();
		this.id = id;
		this.model = model;
		this.manufacturer = manufacturer;
	}


	public Automobile(String model, Manufacturer manufacturer) {
			super();
			this.model = model;
			this.manufacturer = manufacturer;
	}
	
	public Automobile () {
		super();
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="automobileSequence")
	@SequenceGenerator(allocationSize=1, name="automobileSequence", sequenceName="SQ_AUTOMOBILE_PK")
	@Column(name="AUTOMOBILE_ID")
	private int id;
	
	@Column(name="AUTOMOBILE_MODEL")
	private String model;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="AUTOMOBILE_MANUFACTURER_ID")
	private Manufacturer manufacturer;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public Manufacturer getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}


	@Override
	public String toString() {
		return "Automobile [id=" + id + ", model=" + model + ", manufacturer=" + manufacturer + "]";
	}
	
}
	