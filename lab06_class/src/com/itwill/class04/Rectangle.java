package com.itwill.class04;

public class Rectangle {
	// field
	double width; // 직사각형의 가로 길이
	double height; // 직사각형의 세로 길이
	
	
	
	
	// 생성자
	// (1) 기본 생성자
	public Rectangle() {
	}
	
	// (2) 아규먼트를 갖는 생성자 
	public Rectangle(double width, double height) {
		this.height = height;
		this.width = width;
	}
	
	
	
	
	// method
	// (1) 넓이를 리턴
	public double area() {
		return width * height; 
	}
	
	// (2) 둘레길이를 리턴
	public double peri() {
		return width*2 + height*2;
	}
	

}
