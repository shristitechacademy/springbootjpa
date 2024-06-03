package com.productapp.service;

import java.util.List;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductService {
	
	Product addProduct(Product product);
	
	Product getById(int productId)throws ProductNotFoundException;
	List<Product> getAll();
	
	
}
