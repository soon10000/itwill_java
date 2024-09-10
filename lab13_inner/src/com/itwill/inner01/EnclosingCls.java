package com.itwill.inner01;

public class EnclosingCls {
	public static int var = 1; // static field
	private int x; // instance field 
	
	public EnclosingCls(int x) {
		this.x = x;
	}
	
	// static method
	public static void test() {
		System.out.println("var = "+ var);
//		System.out.println(x); << x의 변수가 static으로 선언되지 않았기 때문에 static 메서드에서는 사용할 수 없다.
	}
	
	@Override
	public String toString() {
		return String.format("EnclosingCls(x=x%d, var=%d)", x, var);
		 // -> 인스턴스 메서드는 static 필드를 사용할 수 있음.
	}
	
	// static 내부 클래스(중첩 클래스)
	public static class NestedCls {
		private int x;
		
		public NestedCls(int x) {
			this.x = x;
		}
		
		public void info() {
			System.out.println("--- NestedCls ---");
			System.out.println("x = " + x); // 중첩 클래스의 필드(변수 x)
			System.out.println("var =" + var); // 외부 클래스의 static 필드
//			System.out.println(EnclosingCls.this.x); // EnclosingCls 필드의 변수 x는 static 으로 선언이 되어 있지 않기 때문에 사용 불가
			 //-> static 내부 클래스(중첩 클래스)에서는
 			 // 외부 클래스의 static 맴버만 사용 가능하고,
			 // 외부 클래스의 non-static 맴버들은 사용할 수 없음.
		}
	} // NestedCls 종료
	

} // EnclosingCls 종료
