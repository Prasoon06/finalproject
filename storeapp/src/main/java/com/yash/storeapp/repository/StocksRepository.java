package com.yash.storeapp.repository;
/*
  This is a CrudRepository class
 * from which we can access the data from and into the database
 */
import org.springframework.data.repository.CrudRepository;

import com.yash.storeapp.domain.Stocks;


public interface StocksRepository extends CrudRepository<Stocks, Long>{
	Stocks findById(int id);

	
}
