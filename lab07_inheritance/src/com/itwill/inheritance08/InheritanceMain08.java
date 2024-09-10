package com.itwill.inheritance08;

public class InheritanceMain08 {

	public static void main(String[] args) {
		// Ractangle 타입의 객체 생성
//		Rectangle rect = new Rectangle(4.0, 3.0); // 객체 호출
		Shape rect = new Rectangle(4.0, 3.0);     // 객체의 다형성 
		rect.draw();
		
		// Circle 타입의 객체 생성
//		Circle circle = new Circle(1.0);  // 객체 호출
		Shape circle = new Circle(1.0);   // 객체의 다형성
		circle.draw();
	

	}

}
