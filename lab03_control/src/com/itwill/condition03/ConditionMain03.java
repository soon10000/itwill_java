package com.itwill.condition03;

import java.util.Scanner;

public class ConditionMain03 {

	public static void main(String[] args) {
		// Scanner 타입의 변수를 선언, 초기화.
		Scanner sc = new Scanner(System.in);
		
		
		// 콘솔 창에서 Java 과목 점수(0 ~ 100 정수)를 입력받고 저장
		System.out.print("당신의 Java 점수를 입력하세요 : ");
		int java = sc.nextInt();
		// 콘솔 창에서 SQL 과목 점수(0 ~ 100 정수)를 입력받고 저장
		System.out.print("당신의 SQL 점수를 입력하세요 : ");
		int sql = sc.nextInt();
		// 콘솔 창에서 JavaScript 과목 점수(0 ~ 100 정수)를 입력받고 저장
		System.out.print("당신의 JavaScript 점수를 입력하세요 : ");
		int js = sc.nextInt();
		
		// 세 과목의 점수 출력
		System.out.println("Java : " + java);
		System.out.println("SQL : " + sql);
		System.out.println("JavaScript : " + js);
		
		// 세 과목의 총점(정수)을 계산을 하고 출력.
		int total = java + sql + js;
		System.out.println("당신의 3과목 총 점수는 : " + total);
		
		// 세 과목의 평균 점수(소수점까지 계산)를 계산하고 출력.
		double avr = (double)total / 3;
		System.out.println("당신의 3과목 평균 점수는 : " + avr);
		
		// 세 과목 평균이 90점 이상이면 "A"
		if (avr >= 90) {
			System.out.println("당신의 등급은 A입니다.");
		} else if (avr >= 80) {
			System.out.println("당신의 등급은 B입니다.");
		} else if (avr >= 70) {
			System.out.println("당신의 등급은 C입니다.");
		} else {
			System.out.println("당신의 등급은 F입니다.");
		}
		// 세 과목 평균이 80점 이상이면 "B"
		// 세 과목 평균이 70점 이상이면 "C"
		// 세 과목 평균이 70점 미만이면 "F" 라고 출력.
		
		
		
		
		

	}

}
