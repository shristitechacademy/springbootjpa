package com.productapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.productapp.model.Product;

@Mapper
public interface IProductRepository {
	
	@Insert("insert into product(product_name,cost,brand,category) values(#{productName},#{price},#{brand},#{category})")
	void addProduct(Product product);
	
	@Update("update product set cost=#{price} where product_id=#{productId}")
	void updateProduct(Product product);
	
	@Delete("delete from product where product_id = #{productId}")
	void deleteProduct(int productId);
	
	@Select("select * from product where product_id = #{productId}")
	@Results({
			@Result(property = "productId", column = "product_id"),
			@Result(property = "productName", column = "product_name"),
			@Result(property = "price", column = "cost")
	})
	Product getById(int productId);
	
	@Select("select * from product")
	@Results({
			@Result(property = "productId", column = "product_id"),
			@Result(property = "productName", column = "product_name"),
			@Result(property = "price", column = "cost")
	})
	List<Product> getAll();
	
	@Select("select * from product where brand = #{brand}")
	@Results({
			@Result(property = "productId", column = "product_id"),
			@Result(property = "productName", column = "product_name"),
			@Result(property = "price", column = "cost")
	})
	List<Product> getByBrand(String brand);
	@Select("select * from product where cost < #{price}")
//	@Results({
//			@Result(property = "productId", column = "product_id"),
//			@Result(property = "productName", column = "product_name"),
//			@Result(property = "price", column = "cost")
//	})
	List<Product> getByLesserPrice(double price);
}
