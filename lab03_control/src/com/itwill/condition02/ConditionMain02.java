package com.itwill.condition02; // 패키지 선언문

import java.util.Scanner; // import 문장 (패키지 선언문과 클래스 선언문 사이에 위치해야함)

public class ConditionMain02 {

	public static void main(String[] args) {
		// 콘솔창에서 키보드 입력을 저장하는 방법 : 
		// (1) Scanner 타입의 변수를 선언하고, Scanner 객체를 저장. 
		Scanner sc = new Scanner(System.in); // 입력 도구를 생성하여 변수에 저장
		// 기본 타입이 아닌 나머지 변수 타입의 경우 특별한 경우가 아니면 'import' 문장이 삽입되어야 함
		
		// 콘솔 창에서 정수 1개를 입력받고, int 타입 변수에 저장
		System.out.print("정수를 입력해 주세요: ");
		int number = sc.nextInt(); // (2) 콘솔에서 입력 받은 정수를 변수에 저장 (해당 sc의 경우 스캐너 변수 값)
		
		System.out.println("숫자 = " + number);
		
		if (number > 0) { // 양수이면
			System.out.println("positive");
			
		} else if(number == 0) { // 0이면
			
			System.out.println("zero");
		} else { // 음수이면
			
			System.out.println("negative");
		}
		// 만약 입력받은 정수가 0보다 크면, "positive"라고 출력
		// 만약 입력 받은 정수가 0이면, "zero" 라고 출력
		// 만약 입력 받은 정수가 0보다 작으면 "negative" 라고 출력
		// if / else if
		
		
		
		
		
		
		

	}

}
