package com.itwill.class03;

public class ClassMain03 {

	public static void main(String[] args) {
		//Person 타입의 객체 생성
		Person p1 = new Person();
		
		System.out.println(p1.name);
		System.out.println(p1.age);
		
		p1.name = "오쌤";
		p1.age = 16;
		p1.introduce();
		
		System.out.println();
		
		// 아규먼트를 갖는 생성자를 호출해서 Person 타입 개체를 생성
		Person p2 = new Person("홍길동", 20);
		p2.introduce();

	}

}
