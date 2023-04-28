package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;


public interface IBookService {

	void addBook(Book book);
	
	List<Book> getAll();
	// derived queries
	List<Book> getByAuthor(String author );
	List<Book> getByCategory(String category);

}
