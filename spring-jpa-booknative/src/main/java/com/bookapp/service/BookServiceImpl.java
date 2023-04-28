package com.bookapp.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;

@Service 
public class BookServiceImpl implements IBookService {

	private IBookRepository bookRepository;

	@Autowired
	public void setBookRepository(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book addBook(Book book) {
		Book nbook = bookRepository.save(book);
		return nbook;
	}

	@Override
	public Book updateBook(Book book) {
		Book nbook = bookRepository.save(book);
		return nbook;
	}


	@Override
	public Book getById(int bookId) {
		Optional<Book> bookOpt = bookRepository.findById(bookId);
		if (bookOpt.isPresent()) {
			Book book = bookOpt.get();
			return book;
		}
		return null;
	}
	@Transactional
	@Override
	public void updatePriceById(int bookId, double price) {
		bookRepository.updatePriceById(bookId, price);
	}
}
