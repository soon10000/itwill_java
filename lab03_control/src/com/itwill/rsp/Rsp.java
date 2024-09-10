package com.itwill.rsp;

import java.util.Random;
import java.util.Scanner;

public class Rsp {

	public static void main(String[] args) {
		// 가위/바위/보 (Rock-Scissrors-Papper) 게임
		// 가위 - 0, 바위 -1, 보 -2
		
		// Todo : Random 타입 변수를 선언, 초기화
		Random rand = new Random();
		int code = rand.nextInt(3);
		// Todo : Scanner 타입 변수를 선언, 초기화
		System.out.print("숫자를 입력하세요(0~2) : " );
		Scanner touch = new Scanner(System.in);
		
		
		
		System.out.println("가위바위보 게임");
		System.out.println("---------------");
		System.out.println("[0] 가위");
		System.out.println("[1] 바위");
		System.out.println("[2] 보");
		System.out.println("---------------");
		System.out.print("User 선택(0 ~ 2까지 고르시오) : ");
		int scode = touch.nextInt();
		
		// Todo : 사용자가 콘솔창에서 입력한 정수의 변수(user)에 저장
		// Todo : 0 이상 3 미만의 정수 난수 1개를 변수(computer)에 저장
		System.out.println("Computer 선택 : " + code);
		// Todo : 가위바위보 게임 결과(User win / Computer win / Tie)를 출력. - if구문 사용
		
		if(scode == code) {
			System.out.println("결과 : Tie");
		} else if((scode == 0 && code == 2) || (scode == 1 && code == 0) || (scode == 2 && code == 1)) {
			System.out.println("User win");
		} else {
			System.out.println("Computer win");
		}

	}

}
