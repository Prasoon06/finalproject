package com.yash.storeapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.storeapp.domain.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

	Bill findByBillNumber(String billNumber);

}
