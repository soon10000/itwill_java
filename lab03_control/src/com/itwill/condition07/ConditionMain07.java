package com.itwill.condition07;

import java.util.Random;

public class ConditionMain07 {

	public static void main(String[] args) {
		// 조건문, 비교(=, > , < 등) / 논리(and, or) 연산자 연습
		
		// 난수(random number)를 생성할 수 있는 타입의 변수를 선언, 초기화
		Random rand = new Random();
		// rand.nextInt(x): 0이상 X보다 작은 정수인 난수를 반환
		// rand.nextInt(x, y): x 이상, y 미만의 정수 난수를 반환
		
		
		int java = rand.nextInt(101); // 0이상 101 미만의 정수 난수를 저장
		System.out.println("Java : " + java);
		
		int sql = rand.nextInt(101);
		System.out.println("SQL : " + sql);
		
		int javascript = rand.nextInt(101);
		System.out.println("JavaScript : " + javascript);
		
		// 세 과목이 모두 40점 이상(비교)이고, (and) 평균이 60점 이상이면 "합격"
		
		int total = (java + sql + javascript);
		System.out.println("총점 : " + total);
		
		double avr = (total/3.0);
		System.out.println("평균 : " + avr);
		
		// 삼항 연산자 코드
		String score = (java >= 40 && sql >= 40 && javascript >= 40 && avr > 60) ? ("삼항 연산자 : 합격") : ("삼항 연산자 : 불합격");		
		
		System.out.println(score);
		
		// if 구문 코드 
		if(java >= 40 && sql >= 40 && javascript >= 40 & avr >= 60) {
			System.out.println("if 구문 : 합격");
		} else {
			System.out.println("if 구문 : 불합격");
		}
		
		
		// 그렇지 않으면 "불합격"을 출력
		
	}

}
