package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringJpaBookqueriesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaBookqueriesApplication.class, args);
	}
	private IBookService bookService;
	
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}


	@Override
	public void run(String... args) throws Exception {
		
		// Using Custom Queries
//		System.out.println("Books By Author");
//		bookService.getByAuth("Robin").forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println("Books By Cat and Price");
//		bookService.getByCatAndPrice("Tech",1000).forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println("Books By Title starting with");
//		bookService.getByStartingTitle("L").forEach(System.out::println);
		
//		// Using Native Query
//		System.out.println();
//		System.out.println("Books By Author and price");
//		bookService.getByAuthAndPrice("Robin",1000).forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println("Books By Category and Starting title");
//		bookService.getByCatAndStartingTitle("Tech","H").forEach(System.out::println);
//		
//		Using Named Query
		System.out.println();
		System.out.println("Books By Category");
		bookService.getBooksByCategory("Tech").forEach(System.out::println);
		
		System.out.println();
		System.out.println("Books By Author");
		bookService.getBooksByAuthor("Robin").forEach(System.out::println);
		
		System.out.println();
		System.out.println("Books By Price");
		bookService.getBooksByLessPrice(1000).forEach(System.out::println);

	}
}







