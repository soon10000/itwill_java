package com.itwill.loop07;

public class LoopMain07 {

	public static void main(String[] args) {
		// 과제 : 구구단 출력하기
		// 2단은 2x2 까지만, 3단은 3x3까지만, 4단은 4x4까지만 ... 9단은 9x9 까지 출력
		// (1) break 이용하기
		// (2) break 이용하지 않기.
		
		// (1) break 이용하기
		for(int n = 2; n < 10 ; n++) {
			for(int x = 1; x < 10 ; x++) {
				if(x == n+1) { // if와 println 의 구문이 변경되어야 함
					break; //
				} System.out.println(n + " x " + x + " = " + n*x); // if와 println 의 구문이 변경되어야 함
			}
				
		}
		
		System.out.println("------------------");
		
		
		// (2) break 이용하지 않기
		for(int n = 2; n < 10 ; n++) {
			for(int x = 1; x < 10; x++) {
				if(n >= x) {
					System.out.println(n + " x " + x + " = " + n*x);
				}
			}
		}
		
		
		
		
		System.out.println("----------선생님 해답------------");
		
		
		
		
		// (1) break 이용하기 (선생님 해답)
		for(int x = 2; x < 10 ; x++) {
			System.out.println("----- " + x + "단 ------");
			for (int y = 1; y < 10 ; y++) {
				System.out.printf("%d x %d = %d\n",x, y, (x*y));
				if (x == y) {
					break;
				}
			}
		}
		
		
		
		System.out.println("----------------------");
		// (2) break 사용하지 않기
		for(int x = 2; x < 10 ; x++) {
			System.out.println("------ "+ x + "단 ------");
			for(int y =1; y <= x; y++) { // 조건식일 때 타입이 동일한 변수가 들어가도 사용이 가능하다
				System.out.printf("%d x %d = %d\n",x, y, (x*y));
			}
		}
		

	}

}
