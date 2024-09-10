package com.itwill.inheritance06;


// 2차원 평면의 점의 좌표를 표현
public class Point {
	// field
	private int x;
	private int y;
	
	//constructor
	public Point() {}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override // Object이 클래스에서 상속받은 toString() 재정의 (객체를 표현할 수 있는 문자열을 리턴만 하면 됨)
	public String toString() {
		return "Point(x = " + x + ", y = " + y + ")";
	}
	
	@Override // Object에서 상속받은 equals를 재정의
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof Point) {
			Point pt = (Point) obj;
			result = (this.x == pt.x) && (this.y == pt.y);
		}	
		return result;
	}
	
	@Override // Object 클래스의 hashCode() 메서드를 재정의
	public int hashCode() {
		return x + y;
		// x * y; 10 * x + y; 등 연산식을 대입 했을 때 서로 같은 값이 나오도록 하면 된다.
	}
	
	
}
