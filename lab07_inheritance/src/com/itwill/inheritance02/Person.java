package com.itwill.inheritance02;

public class Person {
	
	//field
	private String name;
	
	
	//constructor
	public Person() {
		System.out.println("Person() 생성자");
	}
	
	public Person(String name) {
		this.name = name;  
		System.out.println("Person(name) 생성자");
	}
	
	
	//method
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
