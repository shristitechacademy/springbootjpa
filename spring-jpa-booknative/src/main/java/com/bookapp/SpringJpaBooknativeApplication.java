package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringJpaBooknativeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaBooknativeApplication.class, args);
	}

	private IBookService bookService;

	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Book book = bookService.getById(53);
		System.out.println("Before "+book);
		bookService.updatePriceById(53, 800);
		book = bookService.getById(53);
		System.out.println("After "+book);
		

	}
}
