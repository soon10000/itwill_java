package com.itwill.list03;

import java.util.ArrayList;
import java.util.Random;

public class ListMain03 {

	public static void main(String[] args) {
		// 1. 정수를 저장할 수 있는 ArrayList를 선언(numbers), 객체생성
		ArrayList<Integer> numbers = new ArrayList<>();
		
		// 2. numbers에 [0, 100) 난수 20개 저장 대괄호는 이상/이하 | 소괄호 초과/미만에 난
		Random random = new Random();
		for(int i = 0; i < 20 ; i++) {
		numbers.add(random.nextInt(0,100));
		}
		
		// 3. numbers를 출력
		System.out.println(numbers);
		
		// 4. 홀수들만 저장할 수 있는 ArrayList를 선언(odds), 객체 생성
		ArrayList<Integer> odds = new ArrayList<Integer>();
		
		// 5. numbers에 저장된 숫자들 중 홀수들을 찾아서 odds에 저장
		for(int x : numbers) {
			if(x % 2 == 1) {
				odds.add(x);
			}
		}
		
		// 6. odds를 출력
		System.out.println(odds);
		
		// 7. 정수를 저장할 수 있는 ArrayList를 선언(evenSquares), 객체 생성
		ArrayList<Integer> evenSquares = new ArrayList<Integer>();
		
		// 8. numbers에 저장된 숫자들 중에서 짝수를 찾아서 짝수의 제곱을 evenSquares에 저장
		for(int y : numbers) {
			if(y % 2 == 0) {
				evenSquares.add(y*y);
			}
		}
		
		// 9. evenSquares 출력
		System.out.println(evenSquares);

	}

}
