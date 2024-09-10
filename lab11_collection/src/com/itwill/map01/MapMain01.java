package com.itwill.map01;

import java.util.HashMap;
import java.util.Set;

/*
 * Collection<E>
 *  |__ List<E>, Set<E>
 * 
 * Map<K, V>
 *  |__ HashMap<K, V>, TreeMap<K, V>
 *  
 *  Map<K, V>: 키(Key)와 값(Value)의 쌍으로 구성된 데이터를 저장하는 자료 구조.
 *   (1) Key: 중복된 값을 가질 수 없음. Map에서 하나의 값을 찾기 위한 인덱스와 비슷한 역할
 *      - 데이터를 저장/검색/수정/삭제 할 때 값을 찾기 위한 용도
 *      - 연속된 값을 가질 필요는 없음.
 *   (2) Value: 중복된 값을 가질 수 있음.
 *   
 *  
 * HashMap<K, V>: Key를 기준으로 검색을 빠르게 할 수 있는 Map.
 * TreeMap<K, V>: Key를 기준으로 정렬을 빠르게 할 수 있는 Map.  
 */


public class MapMain01 {

	public static void main(String[] args) {
		// 정수를 key로 하고, 문자열을 value으로 하는 HashMap을 선언하고 초기화
		HashMap<Integer, String> map = new HashMap<>(); // new HashMap<Integer, String>();
		System.out.println(map); // Map은 {}로 오버라이딩이 되어 있음.
		System.out.println(map.size());
		
		// map에 key=value 데이터를 저장: // put(key, value)
		map.put(1,  "홍길동");
		map.put(10, "오쌤");
		map.put(101, "홍길동");
		
		System.out.println(map);
		
		// map에 저장된 값(value)을 되찾는 메서드: get(key) - key를 아규먼트로 달하면 해당 key에 맞는 value(값)을 전달한다,.
		String value = map.get(1); // -> key가 존재하면 value를 리턴
		System.out.println(value);
		
		value = map.get(100); // -> key가 없으면 null을 리턴(기본값)
		System.out.println(value);
		
		
		value = map.getOrDefault(10, "무명씨"); // -> key가 존재하면 key에 매핑된 value(값)을 리턴
		System.out.println(value);
		
		value = map.getOrDefault(11,"무명씨"); // -> key가 없으면, 아규먼트로 defaultValue를 리턴
		System.out.println(value);
		
		// keySet(): Map의 키(key)들로 이루어진 집합(set)을 리턴 
		Set<Integer> keySet = map.keySet(); 
		System.out.println(keySet);
		
		for(Integer k : keySet) {
			System.out.println(k + " : " + map.get(k));
		}
		
		// Map에 저장된 데이터 삭제: remove(key)
		map.remove(101);
		System.out.println(map);
		
		// put (key, value):
		// (1) key가 존재하지 않으면 새로운 key-value 쌍의 데이터를 저장
		// (2) key가 존재하는 경우, 해당 키의 값을 변경.(해당 key의 값을 수정)
		map.put(10, "No Name"); // -> 10번 키의 값을 "No Name"으로 변경
		System.out.println(map);
		
		

	}

}
