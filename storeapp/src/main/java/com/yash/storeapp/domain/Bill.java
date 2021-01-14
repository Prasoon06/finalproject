package com.yash.storeapp.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	@Column(unique = true,nullable = false)
	@NotBlank(message="Bill Number cannot be blank")
	@Size(min = 3, max = 255,message = "Please use 3 to 255 characters for Bill Number")
	String billNumber;
	
	//@OneToMany(targetEntity = Product.class,cascade=CascadeType.ALL)
	@ManyToMany
	@JoinTable(
	  name = "list_product", 
	  joinColumns = @JoinColumn(name = "bill_id",unique = false), 
	  inverseJoinColumns = @JoinColumn(name = "product_id",unique = false))
	Set<Products> listOfProducts;
	
	@NotBlank(message="Bill description cannot be blank")
	String description;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	Customer customer;
	
	@NotBlank(message="Total price cannot be blank")
	int totalPrice;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date createdAt;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public Set<Products> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(Set<Products> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@PrePersist
	public void createdOn() {
		this.createdAt = new Date();
	}
}
