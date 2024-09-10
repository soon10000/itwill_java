package com.itwill.array09;

import java.util.Random;

public class ArrayMain09 {

	public static void main(String[] args) {
		Random random = new Random();
		
		// 1차원 정수(int) 배열 3개를 갖는 2차원 배열(array) 선언하고 초기화
		int[][] array = new int[3][];
		
		// 2차원 배열 array의 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개
		// 세번째 배열에는 난수 4개를 저장. (난수의 범위는 0 이상 10 미만
		
		array[0] = new int[2];		
		array[1] = new int[3];
		array[2] = new int[4];
		
		
		for(int i = 0; i < array.length ; i++) {
			for(int j = 0; j < array[i].length ; j++) {
				array[i][j] = random.nextInt(10);
			}
		}
		
		
		// 2차원 배열 array의 내용을 출력
		for(int[] x : array) {
			for(int y : x ) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		// 2차원 배열의 모든 원소들(정수 9개)의 합을 계산하고 출력
		int sum = 0; // 배열의 원소들의 합을 저장할 변수
		int count = 0; // 배열의 원소 개수를 저장할 변수
		
		for(int i = 0; i < array.length ; i++) {
			for(int j = 0; j < array[i].length ; j++) {
				sum += array[i][j]; // 배열에서 읽은 값을 sum에 더함
				count++; // 배열에서 읽은 원소 개수를 증가
			}
		}
		
		/*
		for (int[] arr : array) {
			for(int x : arr) {
				sum += x;
			}
		}
		*/
		
		System.out.println("총 합계>> " + sum);
		System.out.println("원소의 총 개수>> " + count);

		
		// 9개 원소의 평균을 계산하고 출력
		double mean = (double) sum/count;
		System.out.println("평균>> " + mean);
		
		
		
		
		

		
		
		
	}

}
