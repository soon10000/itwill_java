package com.itwill.inheritance08;

public class Circle extends Shape{
	// field
	private double radius;
	
	// 생성자
	public Circle(double radius) {
		super("원");
		this.radius = radius;
	}
	
	
	
	// 추상 메소드
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
	
	@Override
	public double perimeter() {
		return Math.PI * (radius*2);
	}

}
