package com.itwill.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		// Subject, Student 클래스 객체 생성과 메서드 호출 결과 테스트.
		
		// Subject 타입의 객체 생성
		Subject subject1 = new Subject();
		System.out.println("국어 : " + subject1.korean);
		System.out.println("영어 : " + subject1.english);
		System.out.println("수학 : " + subject1.math);
		System.out.println("과학 : " + subject1.science);
		System.out.println("총점 : " + subject1.getTotal());
		System.out.println("평균 : " + subject1.getMean());
		
		System.out.println("======구분선======");
		 
		// 아규먼트를 갖는 생성자
		Subject subject2 = new Subject(100, 90, 50, 70);
		subject2.info();
		
		Student student1 = new Student(39, "권순만", subject2);
		student1.info();
		
		// 기본 생성자를 사용해서 student 타입의 객체 생성
		Student student2 = new Student();
		student2.info();
		
	}
	
}
