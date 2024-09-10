package com.itwill.list01;

import java.util.ArrayList;

/*
 * Collection<E> 
 *  |__ List<E>
 *      |__ ArrayList<E>, LinkedList<E>
 *            
 * 리스트(list)의 특징:
 *  1. 값들을 저장(add)할 때 순서가 중요 - 인덱스(index)를 갖는 자료 구조
 *  2. 값들을 저장할 때 마다 인덱스는 자동으로 증가됨 (인덱스는 0부터 시작)
 *  3. 리스트 중간에 있는 값을 삭제하면 인덱스가 자동으로 재배열(인덱스를 삭제하면 당겨옴 빈자리 채움)
 *  4. 같은 값들을 여러번 저장할 수 있음 - Set<E>가 다른 점.
 *  5. List<E>에서 <E>는 리스트에 저장하는 원소(element)의 타입을 의미
 *   ★주의★ 원소 타입은 클래스 이름(Integer, Boolean ...)만 사용. 기본 타입을 사용불가(int,boolean 등등)
 *    기본 타입 대신에 wrapper 클래스 사용!
 *  
 *  ArrayList<E>의 특징:
 *    1. 배열을 이용한 리스트 -> 값들이 연속된 메모리 공간에 저장
 *    2. 값을 저장(add), 삭제(remove) 속도가 느림. (이유는 새롭게 배열을 생성하면서 작업하기 때문)
 *    3. 검색(get) 처리 속도가 빠름 (연속된 배열의 메모리 공간이기 때문에 데이터를 찾기 쉬움)
 *    
 *  LikedList<E>의 특징:  
 *    1. liked list 알고리즘을 이용한 리스트 - 이전/이후 노드의 주소를 저장하는 알고리즘.
 *    2. 값을 저장(add), 삭제(remove) 처리 속도가 빠름
 *    3. 검색(get) 처리 속도가 느림
 *  
 */




public class ListMain01 {

	public static void main(String[] args) {
		// 정수들을 저장하는 ArrayList를 생성 (타입,원소들의 타입, 변수 이름 ArrayList타입 뒤에 <래퍼 클래스>를 넣어야함 
		ArrayList<Integer> numbers = new ArrayList<Integer>(); // new ArrayList<>(); 동일
		//-> 생성자 호출에는 ArrayList의 원소 타입을 생략할 수 있음.
		
		
		//ArrayList에 저장된 원소 개수
		System.out.println("size = " + numbers.size()); // 비어 있는 ArrayList ( 0을 출력 )
		System.out.println(numbers);
		
		// ArrayList에 정수들을 저장
		numbers.add(100);
		numbers.add(1);
		numbers.add(-100);
		System.out.println("size = " + numbers.size());
		
		
		// ArrayList에 저장된 원소(값) 가져오기. (원하는 인덱스 번호 꺼낼 때)
		System.out.println("[1] = " + numbers.get(1));
		System.out.println("[2] = " + numbers.get(2));
		
		// for문을 이용한 ArrayList 값 확인 
		for(int i = 0 ; i < numbers.size(); i++) {
			System.out.print(numbers.get(i) + ", ");
		}
		System.out.println();
		
		
		// 향상된 for문을 이용한 ArrayList 값 확인(순서대로 꺼낼 때)
		for(Integer x :numbers) {
			System.out.print(x + ", ");
		}
		System.out.println();
		
		// ArrayList는 전체 원소를 보여주는 toString()을 override 하고 있음.
		System.out.println(numbers); 
		
		
		// ArrayList의 원소 삭제 // remove(int index): 해당 인덱스의 원소 삭제 아규먼트가 인트면 인덱스로 인식
		numbers.remove(1);
		System.out.println(numbers);
		
		// ArrayList 원소에서 특정 값을 삭제하고 싶은 경우 - remove(wrapper클래스.valueOf(값));
		numbers.remove(Integer.valueOf(-100)); // remove(Object x): 같은 값의 원소를 지움
		System.out.println(numbers); // 아규먼트가 인티저(Integer)이면 해당 값 원소 삭제
		
		// ArrayList 원소 내 값을 수정하는 경우 set(index, value)
		numbers.set(0, 50); // > 0번 인덱스에 있는 값을 50으로 변경
		System.out.println(numbers);
	
		
		
		// 저장 및 불러오는건 메서드를 이용하여 진행

	}

}
