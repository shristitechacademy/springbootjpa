package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;

public interface IBookService {

	// crud operation using the inbuilt methods
	
	Book addBook(Book book);
	Book updateBook(Book book);
	void deleteBook(int bookId);
	
	Book getById(int bookId);
	List<Book> getAll();


	// Using derived queries
	List<Book> getByAuthor(String author);
	List<Book> getByCategory(String category);
	List<Book> getByLesserPrice(double price);
	
	List<Book> getByCategoryAndPrice(String category, double price);
	
	// Custom Queries
	List<Book> getByAuth(String author);
	List<Book> getByCatAndPrice(String category, double price);
	List<Book> getByStartingTitle(String choice);

//	Native Query
	List<Book> getByAuthAndPrice(String author,double price);
	List<Book> getByCatAndStartingTitle(String cat, String choice);
	
//	Named Query
	List<Book> getBooksByCategory(String category);
	List<Book> getBooksByAuthor(String auth);
	List<Book> getBooksByLessPrice(double price);
}








