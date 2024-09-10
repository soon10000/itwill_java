package com.itwill.modifier06;

/*
 * 접근 수식어(access modifier)는 지역 변수에은 사용할 수 없음.
 * 
 * final 수식어
 * - 클래스, 클래스의 맴버((필드, 메서드), 지역 변수에서 사용 가능
 * - final 의미 : 바꿀 수 없는.
 * - final 필드/지역변수 : 한 번 초기화가 되면 더 이상 값을 변경할 수 없는 변수. 상수(constant)
 * - final 필드는 반드시 
 *   (1) 선언과 동시에 초기화 하거나,
 *   (2) 아규먼트를 갖는 생성자를 선언해서 명시적으로 초기화 해야함. 
 *   
 *   인스턴스 멤버(필드, 메서드) vs 정적(static) 멤버
 *   1. 인스턴스 맴버(필드, 메서드)
 *     (1) static 수식어가 없는 멤버
 *     (2) 객체를 생성한 후에 참조 변수를 이용해서 사용하는 멤버(필드 or 메서드)
 *     (3) 인스턴스 필드는 JRE(Java Runtime Environment)가 사용하는 메모리 영역중에 힙(Heap)에 생성
 *     
 *   2. 정적 멤버(필드, 메서드)
 *     (1) static 수식어가 사용된 멤버(필드 or 메서드)
 *     (2) 객체를 생성하지 않아도 사용할 수 있는 멤버
 *     (3) 클래스 이름을 이용해서 사용하는 멤버. (예) Math.PI, Math.rendom(), System.in, System.out,
 *     (4) 정적 필드는 JRE(Java Runtime Environment)가 사용하는 메모리 영역중에 메서드(Method)에 생성
 *     (5) 정적 멤버(필드, 메소드) 프로그램의 main() 메서드가 호출되기 전에 프로그램 로딩 시점에 메모리에 생성됨.
 *     (6) static(정적) 메서드는 static 필드와 메서드만 사용 가능
 */


public class ModifierMain06 {
	private static final int version = 1;
	
	private final String message; // 선언 할 때 초기화 되지 않은 final 필드
	
	// final 필드를 명시적으로 초기화하는 생성자:
	public ModifierMain06(String message) {
		this.message = message;
	}

	
	public static void main(String[] args) {
//		message = "a"; // message 라는 변수는 이미 클래스 내 스태틱으로 선언이 되어있기 때문에 불가능하다
		
//		version = 2; final 필드는 값을 변경할 수 없음.
		// 지역 변수 & 초기화.
		int n1 = 10;
		n1 = 100; 
		
		final int n2 = 10; //-> 상수. final 지역 변수
//		n2 = 100; // 값을 변경(재할당) 할 수 없다.
		
		final int n3;
		n3 = 10;
//		n3 = 100; // -> 이미 초기화가 되었기 때문에 변경 할 수 없다.
		
		// ModifierMain06 타입의 객체를 생성:
		ModifierMain06 app = new ModifierMain06("버스 파업");
//		app.message = "변경변경";  //-> final 필드는 객체 생성 이후에 값을 변경할 수 없음.
		
		// Test 클래스의 정적(static) 멤버 사용:
		System.out.println("Test.y = " + Test.y);
		Test.y = 100; // static 필드는 객체 생성과 관계없이 사용할 수 있음.
		System.out.println("Test.y = " + Test.y);
		Test.printFields2();
		
		// Test 클래스의 인스턴스(static이 아닌) 멤버 사용: 먼저 객체 생성해야한다.
		Test test = new Test();
		System.out.println("test.x = " + test.x);
		test.x = 100;
		test.printFields();

		
		
	}

}
