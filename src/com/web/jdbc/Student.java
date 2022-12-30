package com.web.jdbc;



public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private int no;
	private String email;
	
	public Student(int id, String firstName, String lastName,int no, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.no=no;
		this.email = email;
	}
	public Student(String firstName, String lastName,int no, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.no=no;
		this.email = email;
	
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", no=" + no + ", email="
				+ email + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
