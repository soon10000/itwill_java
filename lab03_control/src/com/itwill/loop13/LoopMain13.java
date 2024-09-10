package com.itwill.loop13;

public class LoopMain13 {

	public static void main(String[] args) {
		
		// 행에 따라 프린트문이 추가적으로 실행되면 됨
		// 교재 5번 문제 - 브레이크로 변환해보기!!
		
		for(int x = 1; x < 5 ; x++) {
			for(int y = 1; y <= x ; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		// 교재 5번 문제 / 브레이크로 변환해보기
		System.out.println("교재 Ex 6-1");
		
		
		for(int x = 1; x < 5 ; x++) {
			for (int y = 1; y < 5 ; y++) {
				if ( y <= 4 - x) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		System.out.println("교재 Ex 6-2");
		for(int x = 1; x < 5 ; x++) {
			for(int y = 4; y > 0 ; y--) {
				if (y > x) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		System.out.println("교재 Ex 6-3");
		for(int x = 1; x < 5 ; x++) {
			for(int y = 1; y <= 4 - x ; y++) {
				System.out.print(" ");
			}
			for (int y = 1; y <= x ; y++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
