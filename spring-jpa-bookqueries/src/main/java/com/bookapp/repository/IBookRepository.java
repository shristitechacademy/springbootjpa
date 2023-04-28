package com.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer>{

//	 derived queries start with findBy, readBy, getBy
	
	List<Book> getByAuthor(String author);
	List<Book> readByCategory(String category);
	List<Book> findByPriceLessThan(double price);
	
	List<Book> findByCategoryAndPriceLessThan(String category,double price);
	
	// custom queries
	// this is JPQL
	// Book represents the entity name
	
	@Query("from Book b where b.author=?1")
	List<Book> getByAuth(String author);
	
	@Query("from Book b where b.category =?1 and b.price<?2")
	List<Book> getByCatAndPrice(String cat, double price);
	
	@Query("from Book b where b.title like ?1%")
	List<Book> getByStartingTitle(String choice);
	
	
//	Native Query - use native sql - use tbale name and column names
	
	@Query(value = "select * from book b where b.author=?1 and b.cost<?2",nativeQuery = true)
	List<Book> getByAuthAndPrice(String author,double price);
	
	@Query(value = "select * from book b where b.title like ?2% and b.category=?1",nativeQuery = true)
	List<Book> getByCatAndStartingTitle(String cat, String choice);
	
//	NamedQuery
	@Query(name = "showByCategory")
	List<Book> findBooksByCat(String category);
	
	@Query(name = "showByAuthor",nativeQuery = true)
	List<Book> findBooksByAuthor(String auth);
	
	@Query(name = "showByPrice")
	List<Book> findBooksByLessPrice(double price);
}







