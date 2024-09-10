package com.itwill.loop08;

public class LoopMain08 {

	public static void main(String[] args) {
		// for문의 경우 총 괄호 안에 3가지 파트(..;..;..)가 나뉘어져 있고 중괄호가 나옴
		// while문의 경우 사용된 변수가 마지막으로 남아 있음(for문과는 다른점) 
		// while의 경우 변수가 선언 된 상태에서 진행되어야 함
		// while 반복문 (while : ~~ 조건에 만족하는 동안에라는 뜻)
		
		System.out.println("----- [1] -----");
		int n = 1;
		while (n <= 5) {
			System.out.print(n + " ");
			n++; // n += 1; n = n + 1
		}
		System.out.println();
		
		
		// 5 4 3 2 1 출력을 while 문으로
		int x = 5;
		while ( x >= 1) {
			System.out.print(x + " ");
			x--;
		}
		
		System.out.println();
		
		// 1 3 5 7 9 출력
		int y = 1;
		while(y < 10) {
			System.out.print(y + " ");
			y += 2;
		}
		System.out.println();
		
		n = 1;
		while(n < 10) { // if 구문이랑 엮는 경우
			if(n%2==1) {
				System.out.print(n + " ");
			}
			n++;
		}
		
		System.out.println();
		
		System.out.println("----- [4] -----");
		//while 문을 사용해서 구구단 9단을 출력하세요
		
		n = 1;
		while (n < 10) {
			System.out.printf("9 x %d = %d\n", n, (n*9));
			n++;
		}
		// for(int i =1; i < 10 ; i++) { print(); 와 동일
		

	}

}
