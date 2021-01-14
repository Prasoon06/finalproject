package com.yash.storeapp.service;
/*
 * It is a service class 
 * This will provide all the CRUD operations to our application
 * It will injecting the dependancy from StocksRepository to access 
 * the database connection
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.storeapp.domain.Stocks;
import com.yash.storeapp.repository.StocksRepository;
@Service
public class StocksServices {
	/*
	 * This Autowired is used to inject
	 *  the dependancy to our service class
	 */
	@Autowired
	/*
	 * StocksRepository is a repository class
	 * from which we can access the connection
	 * and sql inbuilt CRUD operations
	 */
	StocksRepository stocksRepository;
	/*
	 * This saveOrUpdate method is used
	 * to save or update the data
	 */
	public Stocks saveOrUpdate(Stocks stocks)
	{
		
		System.out.println("save");
		Stocks savedStocks=stocksRepository.save(stocks);
		return savedStocks;
	}
	/*
	 * This List method is used
	 * to get the data from the database
	 */
	 public List<Stocks> getAllStocks()
	 {
			System.out.println("save");
		 return (List <Stocks>) stocksRepository.findAll();
	 }
	 /*
	  * This delete method will delete 
	  * the particular row based on the id
	  */
	 
	 public void deleteByStocksId(int stockId)
		{
			Stocks stock=stocksRepository.findById(stockId);
			stocksRepository.delete(stock);
		}
}
