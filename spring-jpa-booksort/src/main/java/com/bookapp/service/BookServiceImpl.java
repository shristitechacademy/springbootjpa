package com.bookapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService{
	
	private IBookRepository bookRepository;
	
	@Autowired
	public void setBookRepository(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
	}
	@Override
	public List<Book> getAll() {
//		select * from book order by author desc
		Sort sort = Sort.by(Direction.DESC, "author","title");
		// sort the list of books by author
		List<Book> books = bookRepository.findAll(sort);
		return books;
	}
	@Override
	public List<Book> getByAuthor(String author) {
		Sort sort = Sort.by("title");
		return bookRepository.findByAuthor(author,sort);
	}

	@Override
	public List<Book> getByCategory(String category) {
//		select * from book order by author asc ,title desc
		Order order = Order.asc("author");
		Order order1 = Order.desc("title");
//		List<Order> orders = Arrays.asList(order,order1);
		Sort sort = Sort.by(Arrays.asList(order,order1));
		return bookRepository.readByCategory(category, sort);
	}
}








