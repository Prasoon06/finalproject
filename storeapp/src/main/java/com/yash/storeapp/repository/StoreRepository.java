package com.yash.storeapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.storeapp.domain.Stores;

@Repository
/**
 * The StoreRepository is a Repository which helps to perform CRUD operation.
 *
 */
public interface StoreRepository extends CrudRepository<Stores, Long>
{
	Stores findById(long id);
}
