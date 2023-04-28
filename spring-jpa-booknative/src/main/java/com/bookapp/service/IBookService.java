package com.bookapp.service;

import com.bookapp.model.Book;

public interface IBookService {

	// crud operation using the inbuilt methods
	
	Book addBook(Book book);
	Book updateBook(Book book);
	Book getById(int bookId);
	
	void updatePriceById(int bookId,double price);


	
	

}
