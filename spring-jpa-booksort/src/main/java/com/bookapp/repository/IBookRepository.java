package com.bookapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {

	
	// derived queries
	
	List<Book> findByAuthor(String author,Sort sort);
	List<Book> readByCategory(String category,Sort sort);

	
}
