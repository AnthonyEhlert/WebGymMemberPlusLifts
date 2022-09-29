package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Sep 28, 2022
 */

@Entity
public class Lift {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	//default no-arg constructor
	public Lift() {
		super();
	}
	
	//helper constructors
	public Lift(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Lift(String name) {
		super();
		this.name = name;
	}

	//getters and setters
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

	@Override
	public String toString() {
		return "Lift [id=" + id + ", name=" + name + "]";
	}
	
	
}
