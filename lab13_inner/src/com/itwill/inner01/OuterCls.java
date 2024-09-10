package com.itwill.inner01;

public class OuterCls {
	// filed
	private int x;
	private int y;
	private String s;
	
	// constructor
	public OuterCls(int x, int y, String s) {
		this.x = x;
		this.y = y;
		this.s = s;
	}
	
	// method
	public int getX() {
	return x;
	}
	
	@Override
	public String toString() {
		return String.format("OuterCls(x=%d, y=%d, s=%s)", x, y, s);
	}
	
	// static이 아닌 맴버 내부 클래스
	public class InnerCls{ 
		// field
		private int y;
		
		// constructor
		public InnerCls(int y) {
			this.y = y;
		}
		
		// method
		public void info() {
			System.out.println("--- InnerCls ---");
			System.out.println("y= " + y); // InnerCls 인스턴스의 필드  // 변수의 경우 가까운 범위의 변수를 우선적으로 사용
			System.out.println("x= " + x); // OuterCls 인스턴스의 필드
			System.out.println("OuterCls y= " + OuterCls.this.y); // OuterCls 인스턴스를 이용한 변수를 사용하는 경우
			 // -> 내부 클래스의 필드 이름과 외부 클래스의 필드 이름이 같은 경우,
			 // 외부 클래스 인스턴스의 필드를 사용하는 방법
			System.out.println("s= " + s); // OuterCls 인스터스의 필드 
		}
		
	} // end class InnerCls

}
