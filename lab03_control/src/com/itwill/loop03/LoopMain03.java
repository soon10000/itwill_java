package com.itwill.loop03;

public class LoopMain03 {

	public static void main(String[] args) {

		/*
		 * Ex1. 아래와 같이 구구단 2단을 출력하세요. 2 x 1 = 2 2 x 2 = 4 2 x 3 = 6 ... 2 x 8 = 16 2 x 9
		 * = 18
		 */

		for (int a = 1; a <= 9; a++) {
//				System.out.println("2 x " + a + " = " + a * 2);     prinln 사용
			System.out.printf("2 x %d = %d\n", a, a * 2); // printf 사용
		}

		/*
		 * Ex2. 아래와 같이 1 ~ 100 숫자를 한 줄에 10개씩 출력하세요. 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
		 * 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40
		 * ... 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100
		 */
		for (int a = 1; a <= 100; a++) {
			System.out.print(a + "\t"); // 숫자를 한 줄에 출력
			if (a % 10 == 0) { // n이 10의 배수이면
				System.out.println(); // 줄바꿈
			}
		}

	}

}
