package com.itwill.variable04;

public class VariableMain04 {

	public static void main(String[] args) {
		// 문자(character) 타입 변수 char
		// char 타입 : 문자 1개의 유니코드 값(2byte 정수)를 저장하는 타입
		// 문자는 작은따옴표를 사용('a'), 문자열은 큰따옴표를 사용("abc")
		
		char ch1 = 'B';
		System.out.println(ch1);
		System.out.println((int) ch1);
		
		// char는 문자의 유니코드를 저장하는 특별한 종류의 정수 타입
		//  -> 사칙연산이 가능, 크기 비교도 가능
		
		char ch2 = (char) (ch1 + 1);
		System.out.println(ch2);
		
		char ch3 = (char) (ch1-1);
		System.out.println(ch3);
		
		// 1. 변수는 같은 타입의 값만 저장할 수 있다.
		//  -> 예) int i = 1; >> i = 1.0; 으로 변환 불가능 
		// 2. 큰 범위의 타입에는 작은 범위 타입의 값을 저장할 수 있다.
		//  -> 예) double x = 1; 이 가능(double 타입의 경우 8byte의 정수이지만 정수 1은 4byte이기 때문에 자동 변환이 가능 
		//  -> float x = 1.0; << 해당 변수의 경우 float는 4byte의 실수이기 때문에 자동변환이 불가능
		//   -> float x = 1.0F; << 의 경우 가능
		// 3. 작은 범위의 타입에 큰 범위 값을 저장하려고 하면 에러가 발생
		//  -> short s = 123; << 은 가능하나 해당 바이트 이상의 숫자가 들어 갈 경우 불가능 ex) 123000 등
		// 4. 정수 리터럴(literal, 상수)은 범위를 넘지 않으면 byte, short, char에 저장하는게 가능하다.
		// 5. 강제 타입 변환(casting) : 변수의 타입을 강제로 변경 (보통 큰 값을 작은 범위의 타입에 넣으려고 할 때 사용)
		

	}

}


