package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringJpaBookappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaBookappApplication.class, args);
	}
	
	private IBookService bookService;
	
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}


	@Override
	public void run(String... args) throws Exception {
		
		/**------------Part-I------------------**/
//		Book book =  new Book("Secret","Rhonda",13,780,"Selfhelp");
//		Book abook = bookService.addBook(book);
//		System.out.println("added"+abook);
//		
////		// get the book object, set the property to be changed and call update method
////		// get book by id => 10
////		Book nbook = bookService.getById(10);
////		// set the title to a diff name
////		nbook.setTitle("Head First Java!!");
////		// call update book method
////		Book newbook = bookService.updateBook(nbook);
////		// print the updated book
////		System.out.println(newbook);
////		
////		bookService.deleteBook(10);
//		
//		// getting all the books
//		bookService.getAll().forEach(System.out::println);
		
//		/**------------Part-II------------------**/
//		Book book =  new Book("Leadership","Robin",1200,"Selfhelp");
//		bookService.addBook(book);
//		Book abook =  new Book("5amclub","Robin",500,"Selfhelp");
//		bookService.addBook(abook);
//		abook =  new Book("7 habits","Steve",900,"Selfhelp");
//		bookService.addBook(abook);
//		System.out.println("added"+abook);
		
		/**------------Part-III Derived queries------------------**/
		System.out.println("Books By Author");
		bookService.getByAuthor("Robin").forEach(System.out::println);
		System.out.println();
//		
//		System.out.println("Books By Category");
//		bookService.getByCategory("Tech").forEach(System.out::println);
//		System.out.println();
//		System.out.println("Books By Lesser Price");
//		bookService.getByLesserPrice(1000).forEach(System.out::println);
//		
//		
//		System.out.println();
//		System.out.println("Books By Category and Lesser Price");
//		bookService.getByCategoryAndPrice("Selfhelp", 1000).forEach(System.out::println);
//		
		
		
	}

}
