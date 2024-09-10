package com.itwill.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		
		
		// 기본 생성자
		Rectangle rect1 = new Rectangle();
		rect1.height = 11.8;
		rect1.width = 14.2;
		System.out.println("rect1 : " + rect1);
		System.out.println("rect1 직사각형의 둘레 : " + rect1.peri());
		System.out.println("rect1 직사각형의 넓이 : " + rect1.area());
		
		
		System.out.println();
		
		// 아규먼트 생성자
		Rectangle rect2 = new Rectangle(12.3, 15.4);
		System.out.println("rect2 : " + rect2);
		System.out.println("rect2 직사각형의 둘레 : " + rect2.peri());
		System.out.println("rect2 직사각형의 넓이 : " + rect2.area());
		
		
		rect2 = new Rectangle(4, 0);
		System.out.println("rect2 : " + rect2);

	}

}
