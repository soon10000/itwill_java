package com.itwill.exception03;

import java.util.Scanner;

public class ExceptionMain03 {

	private final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionMain03 app = new ExceptionMain03();

		int x = app.inputInteger2();
		System.out.println("x =" + x);

	}
	
	
	
	
	public int inputInteger2() {
		try {
			System.out.print("정수 입력> ");
			return Integer.parseInt(sc.nextLine());
			
		} catch (NumberFormatException e) {
			System.out.println("정수로 입력하세요...");
			return inputInteger2();
		}
	}
	

	private int inputInteger() { // 사용자가 정수를 입력할 떄 까지 입력을 받아라..
		int result = 0;
		while (true) {
			try {
				System.out.print("x의 정수를 입력하세요>> ");
				result = Integer.parseInt(sc.nextLine());
				return result; //break;		
			} catch (NumberFormatException e) {
				System.out.println("입력한 내용은 정수가 아닙니다.");
			}
		}
//		return result;
	}
}