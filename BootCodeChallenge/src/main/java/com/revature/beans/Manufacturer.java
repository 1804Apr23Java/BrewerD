package com.revature.beans;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MANUFACTURER")
public class Manufacturer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4772369770949858160L;

	public Manufacturer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Manufacturer (String name) {
		super();
		this.name = name;
	}

	public Manufacturer () {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="manufacturerSequence")
	@SequenceGenerator(allocationSize=1,name="manufacturerSequence",sequenceName="SQ_MANUFACTURER_PK")
	@Column(name="MANUFACTURER_ID")
	private int id;
	
	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="MANUFACTURER_NAME")
	private String name;
	
}
