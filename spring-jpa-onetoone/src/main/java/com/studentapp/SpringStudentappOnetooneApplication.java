package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.Address;
import com.studentapp.model.Student;
import com.studentapp.service.IStudentService;

@SpringBootApplication
public class SpringStudentappOnetooneApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringStudentappOnetooneApplication.class, args);
	}

	private IStudentService studentService;
	@Autowired
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("Bangalore","KAR");
		Student student = new Student("Ben", "CSE", address);
//		studentService.addStudent(student);
//		
//		Student nstudent = studentService.getById(2);
//		// set the dept
////		nstudent.setDepartment("mech");
//		
//		// get the address of the student obj
//		Address naddress = nstudent.getAddress();
//		//set the property - city
//		naddress.setCity("Hubli");
//		nstudent.setAddress(naddress);
//		// call update method
//		studentService.updateStudent(nstudent);
//		System.out.println(nstudent);
//		
//		studentService.getAll().forEach(System.out::println);
//		studentService.getByDepartment("CSE").forEach(System.out::println);
		studentService.getByCity("Bangalore").forEach(System.out::println);
	}

}
