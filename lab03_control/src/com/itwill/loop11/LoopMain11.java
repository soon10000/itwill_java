package com.itwill.loop11;

public class LoopMain11 {

	public static void main(String[] args) {
		// Ex1. 1부터 10까지 자연수들의 합을 계산하고 출력
		// 1 + 2 + 3 + ... +  + 10 = 55
		// hint) 변수가 2개가 필요하다 (합계가 들어갈 변수, 반복문에서 사용 할 변수)
		
		int sum = 0;
		
		for(int n = 1 ; n < 11 ; n++) {
			sum += n;
		}
		System.out.println("1 ~ 10까지의 합 : " + sum);
		
		
		// Ex2. 1부터 100까지 자연수들 중에서 짝수들의 합을 계산하고 출력
		// 2 + 4 + 6 + 8 + ... + 98 + 100 = ?
		
// 권순만 문풀이	(if문 함께 사용)
		int y = 0;
		for(int x = 1; x < 101 ; x++) {
			if(x%2==0) {
				y += x;
			}
		}
		
// 선생님 문풀이	(for 구문만 사용)
		y = 0;
		for(int x = 2 ; x < 101 ; x += 2) {
			y += x;
		}
		System.out.println("선생님 짝수 합계 : " + y);
		
		
		
		System.out.println("1 ~ 100까지의 짝수의 합 : " + y);
		
		// Ex3. Ex2. 1부터 100까지 자연수들 중에서 홀수들의 합을 계산하고 출력
		// 1 + 3 + 5 + ... + 97 + 99 = ?
		
// 권순만 문풀이
		
		sum = 0;
		int x = 1;
		while(x < 100) {
			if ( x % 2 == 1) {
				sum += x;
			}
			x++;
		}
		System.out.println("선생님 홀수의 합 : " + sum);
		
	}
	
 }

