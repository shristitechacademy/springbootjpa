package com.studentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>{

	// findBy,readBy, getBy
	
	List<Student> findByDepartment(String department);
	List<Student> findByAddressCity(String city);
}
