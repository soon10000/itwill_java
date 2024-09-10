package com.itwill.switch02;

import java.util.Random;

public class SwitchMain02 {

	public static void main(String[] args) {
		// Random 타입의 변수를 선언하고, 초기화.
		Random r = new Random();
		
		// 정수 타입의 변수에 1부터 4까지의 정수 난수 1개를 저장.
		int code = r.nextInt(1, 5);
		System.out.println("code = " + code); // 1 이상 5 미만의 난수
		
		switch (code) {
		case 1:
			System.out.println("남성");
			break;
		case 2:
			System.out.println("여성");
			break;
		case 3:
			System.out.println("남성");
			break;
		case 4:
			System.out.println("여성");
			break;
		}
		
		switch (code) {  // 값이 같을 시 케이스를 묶어서 사용하는 예시
		case 1:
		case 3:
			System.out.println("남성");
			break;
		case 2:
		case 4:
			System.out.println("여성");
			break;
		}
		
		if (code == 1 || code == 3) {
			System.out.println("if 남성");
		} else {
			System.out.println("if 여성");
		}
		
		

	}

}
