package com.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {

//	Using @Procedure with procedurename as method name
	@Procedure
	int get_count_of_books(String author);
	
//	Using @Procedure with a different method name
//	add attribute as procedureName/value and assign the procedure name
	@Procedure(procedureName = "get_count_of_books")
	int getBookCount(String author);
	
// Using @NamedStoredProcedureQuery
	  @Procedure(name="getBookCountByAuthor")	
	  int getCountByAuthor(@Param("auth") String author);
	  
	 //Using Query annotation- native query
	  // can be used only with stored procedures taking IN parameter
	  @Query(value = "call get_books_by_author(:author)", nativeQuery = true)
	  List<Book> getBookListByAuthor(@Param("author")String author);
	  
}
 