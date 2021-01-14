package com.yash.storeapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="stores")
/**
 * Stores is domain class which contains all attributes to create Table.  
 *
 */
public class Stores 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * Store Id
	 */
	private long id;
	
	@NotBlank(message = "Fill the Store Name")
	/**
	 * Name of Store
	 */
	private String name;
	@NotBlank(message = "Fill the Store Description")
	/**
	 * Store Description
	 */
	private String description;
	
	/**
	 * getId() gets the value of id
	 * @return id
	 */
	
	@OneToMany(mappedBy="stores")
    private Set<Stocks> stocks;
	
	public long getId() {
		return id;
	}
	
	/**
	 * setId() sets the value of id
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * getName() gets the value of name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setName sets the value of name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 *  getDescription() gets the value of description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * setDescription() sets the value of description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
