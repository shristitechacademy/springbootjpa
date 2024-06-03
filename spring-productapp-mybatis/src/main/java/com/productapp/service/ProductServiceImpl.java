package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductRepository productRepository;
	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		 productRepository.updateProduct(product);
	}

	@Override
	public void deleteProduct(int productId) {
		 productRepository.deleteProduct(productId);
	}

	@Override
	public Product getById(int productId) {
		return  productRepository.getById(productId);
	}

	@Override
	public List<Product> getAll() {
		return  productRepository.getAll();
	}

	@Override
	public List<Product> getByBrand(String brand) {
		return productRepository.getByBrand(brand);
	}

	@Override
	public List<Product> getByLesserPrice(double price) {
		return productRepository.getByLesserPrice(price);
	}
	

}
