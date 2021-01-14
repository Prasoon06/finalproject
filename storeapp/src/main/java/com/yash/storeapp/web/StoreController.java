package com.yash.storeapp.web;

import java.util.List;
import java.util.Map;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.storeapp.domain.Stores;
import com.yash.storeapp.service.MapValidationErrorService;
import com.yash.storeapp.service.StoreService;
import com.yash.storeapp.exceptions.StoreIDException;


@RestController
@RequestMapping("/api/store/")
@CrossOrigin
/**
 * StoreController is a RestController which helps in Mapping URL.
 *
 */
public class StoreController 
{
	@Autowired
	/**
	 * StoreService provide service to perform CRUD Operations.
	 */
	private StoreService storeService;
	
	@Autowired
	/**
	 * MapValidationErrorService used to provide the service to validate the input from User.
	 */
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping(value = "/insert")
	/**
	 * saveStore redirects to save method of StoreService class.
	 * @param stores
	 * @param result
	 * @return
	 * @throws StoreIDException
	 */
	public ResponseEntity<?> saveStore(@RequestBody Stores stores,BindingResult result) throws StoreIDException
	{
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Stores store=storeService.save(stores);
		return new ResponseEntity<Stores>(store,HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/getAll")
	/**
	 * findAll method redirects to findAll method of StoreService class.
	 * @return
	 * @throws StoreIDException
	 */
	public List<Stores> findAll() throws StoreIDException
	{
		return storeService.findAll();
	}
	
	@PutMapping(value = "/update")
	/**
	 * updateStore method redirects to save method of StoreService class.
	 * @param stores
	 * @param result
	 * @return
	 * @throws StoreIDException
	 */
	public ResponseEntity<?> updateStore(@RequestBody Stores stores, BindingResult result) throws StoreIDException
	{
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Stores store=storeService.save(stores);
		return new ResponseEntity<Stores>(store,HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	/**
	 * delete method redirects to Delete method of StoreService class.
	 * @param id
	 * @return
	 * @throws StoreIDException
	 */
	public ResponseEntity<?> delete(@PathVariable int id) throws StoreIDException
	{
		storeService.delete(id);
		return new ResponseEntity<String>(
				"Project with " + id + " is successfully deleted", HttpStatus.OK);
	}
}
