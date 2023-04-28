package com.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// if the bookId exists save will perform update operation
		Book nbook = bookRepository.save(book);
		return nbook;
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
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

	@Override
	public List<Book> getAll() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	@Override
	public List<Book> getByAuthor(String author) {
		return bookRepository.getByAuthor(author);
	}

	@Override
	public List<Book> getByCategory(String category) {
		return bookRepository.readByCategory(category);
	}

	@Override
	public List<Book> getByLesserPrice(double price) {
		return bookRepository.findByPriceLessThan(price);
	}

	@Override
	public List<Book> getByCategoryAndPrice(String category, double price) {
		return bookRepository.findByCategoryAndPriceLessThan(category, price);
	}

	@Override
	public List<Book> getByStartingTitle(String choice) {
		return bookRepository.getByStartingTitle(choice);
	}

	@Override
	public List<Book> getByAuth(String author) {
		return bookRepository.getByAuth(author);
	}

	@Override
	public List<Book> getByCatAndPrice(String category, double price) {
		return bookRepository.getByCatAndPrice(category, price);
	}

	@Override
	public List<Book> getByAuthAndPrice(String author, double price) {
		return bookRepository.getByAuthAndPrice(author, price);
	}

	@Override
	public List<Book> getByCatAndStartingTitle(String cat, String choice) {
		return bookRepository.getByCatAndStartingTitle(cat, choice);
	}

	@Override
	public List<Book> getBooksByCategory(String category) {
		return bookRepository.findBooksByCat(category);
	}

	@Override
	public List<Book> getBooksByAuthor(String auth) {
		return bookRepository.findBooksByAuthor(auth);
	}

	@Override
	public List<Book> getBooksByLessPrice(double price) {
		return bookRepository.findBooksByLessPrice(price);
	}


}
