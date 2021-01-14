package com.yash.storeapp.repository;



import org.springframework.data.repository.CrudRepository;

import com.yash.storeapp.domain.Products;

public interface ProductRepository  extends CrudRepository<Products,Long>{
	Iterable<Products> findByStockId(int stockId);
	Products findByName (String name);
}
