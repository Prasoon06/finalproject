package com.yash.storeapp.web;
/*
 * This is a controller class
 * from which url mapping will be done
 * 
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.storeapp.domain.Stocks;
import com.yash.storeapp.exceptions.StockIdException;
import com.yash.storeapp.service.MapValidationErrorService;
import com.yash.storeapp.service.StocksServices;
	/*
	 * RestController will creates the restful web services
	 * It is the combination of controller and response body
	 * 
	 */
@RestController 
	/*
	 * Request mapping will maps to the url to give the response
	 */
@RequestMapping("/api/stocks")

	/*
	 *Cross origin will connect backend with different front ends 
	 */
@CrossOrigin 
public class StocksController {
	/*
	 * dependancy injection of
	 * StockServices to perform crud operations
	 */
	@Autowired
	 StocksServices StocksService;
	/*
	 * It will validate the data
	 * weather to perform the service or not
	 */
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	/*
	 * GetMapping is used to get the data from database 
	 * findall method wil return the data
	 */
	@GetMapping("/all")
	public ResponseEntity<?> findAll() {
		List<Stocks> stocks = StocksService.getAllStocks();
		return new ResponseEntity<List<Stocks>>(stocks, HttpStatus.OK);
	}
	/*
	 * Postmapping will takes the url from browser
	 * and maps to createStocks method
	 * to save the stocks into database
	 */
	@PostMapping
	public ResponseEntity<?> createStocks(@RequestBody Stocks stocks, BindingResult result) throws StockIdException {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Stocks save = StocksService.saveOrUpdate(stocks);
		return new ResponseEntity<Stocks>(save, HttpStatus.CREATED);
	}
	/*
	 * DalateMapping will wil maps the url into
	 * deleteByStockId method to delete the 
	 * row based on the id given 
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByStockId(@PathVariable int id) throws StockIdException {
		StocksService.deleteByStocksId(id);
		return new ResponseEntity<String>(
				"Stock Id with " + id + " is successfully deleted", HttpStatus.OK);
	}
	/*
	 * PutMapping will maps the url into updatestore 
	 * method, it will perform the update operation
	 */
	@PutMapping(value = "/update")
    public Stocks updateStore(@RequestBody Stocks stock)
    {
        return StocksService.saveOrUpdate(stock);
    }
	

	
}
