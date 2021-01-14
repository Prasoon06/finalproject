package com.yash.storeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.storeapp.domain.Products;
import com.yash.storeapp.exceptions.ProductIDException;
import com.yash.storeapp.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Products saveOrUpdate(Products products) throws ProductIDException{
		try {
			return productRepository.save(products);
		}catch(Exception e) {
			throw new ProductIDException("wrong id");
		}
	}

	public List<Products> getAllProducts(){
		return (List<Products>)productRepository.findAll();
	}

	public List<Products> getProductByStockId(int stockId) throws ProductIDException{
		List<Products> retrievedProducts=(List<Products>)productRepository.findByStockId(stockId);

		if(retrievedProducts==null) {
			throw new ProductIDException();
		}

		return retrievedProducts;
	}

	public Products getProductByName(String name) {
		Products retrievedProduct=productRepository.findByName(name);
		if(retrievedProduct==null) {

		}
		return retrievedProduct;
	}
	public Products getProductById(long id) {
		Optional<Products> retrievedProduct=productRepository.findById(id);
		if(retrievedProduct==null) {

		}
		return retrievedProduct.get();
	}

	public void deleteByName(String name) {
		Products retrievedProduct=productRepository.findByName(name);
		if(retrievedProduct==null) {

		}
		productRepository.delete(retrievedProduct);
	}
	public void deleteById(long id) {
		Products retrievedProduct=productRepository.findById(id).get();
		if(retrievedProduct==null) {

		}
		productRepository.delete(retrievedProduct);
	}
}
