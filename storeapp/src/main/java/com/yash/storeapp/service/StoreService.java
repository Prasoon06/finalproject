package com.yash.storeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.storeapp.domain.Stores;
import com.yash.storeapp.repository.StoreRepository;
import com.yash.storeapp.exceptions.StoreIDException;

@Service
/**
 * StoreService provides service to perform CRUD operations.
 *
 */
public class StoreService 
{
	@Autowired
	/**
	 * StoreRepository is a Repository.
	 */
	private StoreRepository storeRepository;
	
	/**
	 * save method returns save method of StoreRepository
	 * @param stores
	 * @return
	 * @throws StoreIDException
	 */
	public Stores save(Stores stores) throws StoreIDException
	{
		return storeRepository.save(stores);
	}
	
	/**
	 * findAll method returns findAll method of StoreRepository
	 * @return
	 * @throws StoreIDException
	 */
	public List<Stores> findAll() throws StoreIDException
	{
		return (List<Stores>) storeRepository.findAll();
	}
	
	/**
	 * update method returns save method of StoreRepository
	 * @param stores
	 * @return
	 * @throws StoreIDException
	 */
	public Stores update(Stores stores) throws StoreIDException
	{
		return storeRepository.save(stores);
	}
	
	/**
	 * delete method returns deleteById method of StoreRepository
	 * @param id
	 * @return
	 * @throws StoreIDException
	 */
	public String delete(int id) throws StoreIDException
	{
		storeRepository.deleteById((long) id);
		return "Deleted Sucessfully";
		
	}
}
