package com.studentapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Student {
	@Id
	@GeneratedValue(generator = "stud_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="stud_gen",sequenceName = "stud_seq", initialValue = 1,allocationSize = 1)
	private Integer studentId;
	@Column(name="studentname")
	private String studentName;
	private String department;
	// save the child ref before saving the parent ref
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	Address address;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String studentName, String department, Address address) {
		super();
		this.studentName = studentName;
		this.department = department;
		this.address = address;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", department=" + department
				+ ", address=" + address + "]";
	}
	
	
	
}
