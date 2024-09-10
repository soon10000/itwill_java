package com.itwill.array05;

import java.util.Random;

public class ArrayMain05 {

	public static void main(String[] args) {
        // 과제:
        // 정수(int) 5개를 저장할 수 있는 배열을 선언하고, 기본값으로 초기화.
		int[] scores = new int[5];
        // 배열에 0이상 10이하의 난수 5개를 저장.
		Random rand = new Random();
		
		for(int i = 0 ; i < scores.length ; i++) {
			scores[i] = rand.nextInt(11);
		}
		
		//배열 원소들을 출력
		for(int x :scores) {
			System.out.print(x + " ");
		}
		
		System.out.println();
        // 배열 원소들 중 최댓값을 찾아서 출력.
		
		int max = 0; // 혹은 int max = codes[0] 으로도 가능 배열의 첫번째 원소를 최대값이라고 가정
		int min = 11;
		
		for (int i = 0 ; i < scores.length ;  i++ ) { // for 문 사용
			if(scores[i] > max) {
				max = scores[i];
			}
		}
		System.out.println("최대값 : " + max);
		
		for (int x : scores) { // 향상된 for 문 사용 : 배열의 모든 원소를 순서대로 하나씩 꺼내면서 반복
			if ( x > max ) { // 배열에서 꺼낸 값이 현재까지의 최대값 보다 크다면
				max = x; // 최대값을 배열에서 꺼낸 값으로 변경
			}
		}
		System.out.println("최대값 : " + max);
		
		
        // 배열 원소들 중 최솟값을 찾아서 출력.
		
		for (int i = 0 ; i < scores.length ; i ++) { // for 문 사용
			if(scores[i] < min) {
				min = scores[i];
			}
		}
		System.out.println("최소값 : " + min); 
		
		
		for (int x : scores) { // 향상된 for 문 사용
			if(x < min) {
				min = x;
			}
		}
		System.out.println("최소값 : " + min);
		

	}

}
