package com.bookapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringJpaProceduresApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaProceduresApplication.class, args);
	}

	@Autowired
	private IBookService bookService;
	@Override
	public void run(String... args) throws Exception {
		int result = bookService.getCountOfBooks("Robin");
		System.out.println(result);
		result = bookService.getBookCount("Kathy");
		System.out.println(result);
		result = bookService.getCountByAuthor("Robin");
		System.out.println(result);
		
		List<Book> books = bookService.getBookListByAuthor("Kathy");
		books.forEach(System.out::println);
		
	}

}
