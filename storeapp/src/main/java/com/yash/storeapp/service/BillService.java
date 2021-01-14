package com.yash.storeapp.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.storeapp.domain.Bill;
import com.yash.storeapp.domain.Products;
import com.yash.storeapp.exceptions.BillIDException;
import com.yash.storeapp.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	BillRepository billRepository;
	
	public Bill save(Bill bill) throws BillIDException
	{
			bill.setBillNumber(bill.getBillNumber().toUpperCase());
			Bill savedBill = billRepository.save(bill);
			return savedBill;
	}
	public List<Bill> getAllBills() {
		List<Bill> bills=(List<Bill>) billRepository.findAll();
		Iterator iterator=bills.listIterator();
		while(iterator.hasNext())
		{
			Bill bill=(Bill) iterator.next();
			bill.setTotalPrice(calculateTotalPrice(bill.getListOfProducts()));
			billRepository.save(bill);
		}
		return bills;

	}
	
	public Bill getBillByBillNumber(String billNumber) throws BillIDException {
		Bill bill = billRepository.findByBillNumber(billNumber.toUpperCase());
		if (bill == null) {
			throw new BillIDException("Bill number " + billNumber.toUpperCase() + " not exists");
		}
		bill.setTotalPrice(calculateTotalPrice(bill.getListOfProducts()));
		bill=billRepository.save(bill);
		return bill;
	}
	
	public int calculateTotalPrice(Set<Products> set)
	{
		return set.stream().mapToInt(e->e.getPrice()).sum();
	}
}
