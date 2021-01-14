package com.yash.storeapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@OneToMany(mappedBy="customer")
    private Set<Bill> bills;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public Set<Bill> getBills() {
//		return bills;
//	}
//	public void setBills(Set<Bill> bills) {
//		this.bills = bills;
//	}
	
	
}
