package com.yash.storeapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/*
 * This is  a domain class
 * In which we declare stock attributes and Methods
 * 
 */
/*
 * Entity represents this class as a Entity
 */
@Entity
/*
 * Table creates a table with name givens as stocks
 */
@Table(name = "stocks")
public class Stocks {
	/*
	 * It represents the attribute as a primary key
	 */
	@Id
	/*
	 * It generates the the value as auto increment
	 */
	@GeneratedValue(strategy=GenerationType.AUTO)
	/**
	 * Id of Stocks log.
	 */
	int id;
	/*
	 * NotBlank represents that field should not be empty
	 */
	@NotBlank(message="Stocks name cannot be blank")
	/*
	 * size represents the maximum characters which will allow to store
	 */
	@Size(min = 3, max = 255,message = "Please use 3 to 200 characters for Project Name")

		/**
	 * Stocks Name
	 * 
	 */
	
	String name;
	
	/*
	 * NotBlank represents that field should not be empty
	 */
	
	@NotBlank(message="Stocks Description cannot be blank")
	/*
	 * size represents the maximum characters which will allow to store
	 */
	@Size(min = 3, max = 255,message = "Please use 3 to 200 characters for Project Name")
    /*
     * Stocks Descrption
     */
    
	String description;
	
	@ManyToOne
	@JoinColumn(name="storeId")
	Stores stores;
	
	

	public Stores getStores() {
		return stores;
	}
	public void setStores(Stores stores) {
		this.stores = stores;
	}
	public Stocks() {
	}
	/*
	 * constructor of the class
	 */
	public Stocks(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	
	/*
	 * This method will returns Stock id
	 */
	
	public int getId() {
		return id;
	}



	/*
	 * This method setter method for Stock id
	 */
	public void setId(int id) {
		this.id = id;
	}


	/*
	 * This method will returns stock name
	 */
	public String getName() {
		return name;
	}



	/*
	 * This method setter method for Stock name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/*
	 * This method will returns stock description
	 */
	public String getDescription() {
		return description;
	}


	/*
	 * This method setter method for Description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/*
	 * This is toSting method it will return the stock object as a string 
	 */
	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", description=" + description + "]";
	}


	
	

}
