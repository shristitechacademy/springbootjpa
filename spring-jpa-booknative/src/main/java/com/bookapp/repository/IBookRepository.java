package com.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer>{

	@Modifying
	@Query(value="update book set cost=?2 where book_id=?1",nativeQuery = true)
	void updatePriceById(int bookId, double price);
	
}