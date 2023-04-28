package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappDatajpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappDatajpaApplication.class, args);
	}
	private IBookService bookService;
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	@Override
	public void run(String... args) throws Exception {
		Book nbook = new Book("Leadership",1,"Robin","Selfhelp",800);
		Book book = new Book("Jsp in action",2,"Kathy","Tech",700);
		Book book1 = new Book("Learn HTML",3,"Helen","Tech",600);
		Book book2 = new Book("CSS in 5 days",4,"Helen","Tech",1700);
		Book cbook = new Book("The Monk",5,"Robin","Selfhelp",550);
		bookService.addBook(book);
		bookService.addBook(book1);
		bookService.addBook(book2);
		bookService.addBook(nbook);
		bookService.addBook(cbook);
		
		System.out.println("All Books");
		bookService.getAll().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Books By Author");
		bookService.getByAuthor("Helen").forEach(System.out::println);
		
		System.out.println();
		System.out.println("Books By Category");
		bookService.getByCategory("Tech").forEach(System.out::println);
	
	}

}





