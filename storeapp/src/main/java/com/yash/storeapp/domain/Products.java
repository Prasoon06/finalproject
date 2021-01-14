package com.yash.storeapp.domain;

import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Products {
	/*
	 * Id of the product
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/*
	 *  Customer Id related to product
	 */
	@NotNull(message = "Stock Identifier is required")
	private int stockId;

	/*
	 * Product name
	 */
	@NotBlank(message="Product name cannot be blank")
	@Size(min = 3, max = 255,message = "Please use 3 to 200 characters for Project Name")
	@Column(unique = true)
	private String name;

	/*
	 *  Product's Price
	 */
	//@NotBlank(message="Project description cannot be blank")	
	@Min(value=0 ,message = "Enter positive numeric values.")
	private int price;
	
	@ManyToMany
	Set<Bill> bills;

	/*
	 * Product description
	 */
	@NotBlank(message="Product description cannot be blank")
	String description;

	public Products() {
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
