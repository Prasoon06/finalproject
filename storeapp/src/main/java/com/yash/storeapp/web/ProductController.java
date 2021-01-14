package com.yash.storeapp.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yash.storeapp.domain.Products;
import com.yash.storeapp.exceptions.ProductIDException;
import com.yash.storeapp.service.MapValidationErrorService;
import com.yash.storeapp.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	

	@GetMapping("/all")
	public ResponseEntity<?> findAll() {
		List<Products> products = productService.getAllProducts();
		return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Products product, BindingResult result) throws ProductIDException {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Products savedProduct = productService.saveOrUpdate(product);
		return new ResponseEntity<Products>(savedProduct, HttpStatus.CREATED);
	}
//	@GetMapping("/byName/{name}")
//	public ResponseEntity<?> findByName(@PathVariable String name) throws ProductIDException {
//		Products products = productService.getProductByName(name);
//		return new ResponseEntity<Products>(products, HttpStatus.OK);
//	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable long id) throws ProductIDException {
		Products products = productService.getProductById(id);
		return new ResponseEntity<Products>(products, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable long id) throws ProductIDException {
		productService.deleteById(id);
		return new ResponseEntity<String>(
				"Product with Id " + id + " is successfully deleted", HttpStatus.OK);
	}

}
