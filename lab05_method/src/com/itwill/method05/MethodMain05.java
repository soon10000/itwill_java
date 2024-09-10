package com.itwill.method05;

import java.util.Random;

public class MethodMain05 {

	public static void main(String[] args) {
		// TODO 메서드 선언, 호출 그 결과를 출력
		// sum 메서드 호출, 결과 출력
		int[] array = {1, 2, 3, 4, -2}; // 배열 생성
		int total = sum(array); // total 이라는 변수를 만들고 sum 메소드 호출
		System.out.println(total); // sum 메소드 확인
		
		double avr = mean(array);
		System.out.println(avr);
		
		System.out.println("max = " + max(array));
		
		System.out.println("min = " + min(array));


	}
	
	/**
	 * sum.
	 * 아규먼트로 전달받은 정수들의 1차원 배열의 모든 원소들의 합을 리턴.
	 * @param array 정수들의 1차원 배열(int[]).
	 * @return array의 모든 원소들의 합
	 */	
//	public static int sum(int[] array) {
//		int x = 0;
//		for(int i = 0; i < array.length ; i++) {
//			x += array[i];
//		}
//		return x;
//	}
	public static int sum(int[] array) {
		int x = 0;
		for (int y : array) {
			x += y;
		}
		return x;
	}
	

	/**
	 * mean.
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들의 평균을 리턴 (소숫점까지)
	 * @param array 정수들의 1차원 배열 
	 * @return array 원소들의 평균을 double 타입으로 리턴
	 */
	
	public static double mean(int[] array) {
		double x = (double) sum(array) / array.length;
		return x;
	}
	
//	public static double mean(int[] array) {
//		int sum = 0;
//		double y = 0;
//		for(int x : array ) {
//			sum += x;
//		}
//		y = (double) sum / array.length;
//		return y;
//	}
	
	
	
	/**
	 * max
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최대값을 리턴.
	 * @param array
	 * @return 정수들의 1차원 배열 중 최대값
	 */
	
	public static int max(int[] array) {
		int x = array[0];
		for (int y : array) {
			if (y > x) {
				x = y;
			}
		}
		return x;

	}
	
	
	
	
	/**
	 * min
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최소값을 리턴
	 * @param array
	 * @return 정수들의 1차원 배열 중 최소값
	 */
	
	public static int min(int[] array) {
		int x = array[0];
		for(int y : array) {
			if(y < x) {
				x = y;
			}
		}
		return x;
	}

	
	
	
}
