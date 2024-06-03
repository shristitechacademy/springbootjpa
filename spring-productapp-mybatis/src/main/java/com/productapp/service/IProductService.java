package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;

public interface IProductService {

	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(int productId);
	Product getById(int productId);
	List<Product> getAll();
	List<Product> getByBrand(String brand);
	List<Product> getByLesserPrice(double price);
	
}
