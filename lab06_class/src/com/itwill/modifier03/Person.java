package com.itwill.modifier03;

public class Person {
	private String name; // 읽기 전용 필드
	private int age; // 읽기/쓰기 필드
	
	
	
	
	public Person(String name, int age) {
		if(name != null && age != 0) {
			this.name = name;
			this.age = age;			
		} else {
			System.out.println("이름과 나이를 정확히 입력하세요.");
		}
	}
	
	
	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if (age != 0) {
			this.age = age;
		}
	}
	
}
