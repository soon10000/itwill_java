package com.itwill.map03;

import java.util.HashMap;
import java.util.TreeMap;

public class MapMain03 {

	public static void main(String[] args) {
		// 단어 개수 세기(word counting):
		// 문자열에 등장하는 단어를 key로 하고
		// 단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고 출력
		
		
		String sentence = "짜장면 짬뽕 짜장면 볶음밥 김치찌개 부대찌개 김치찌개 된장찌개"; // split으로 짜르고 배열에서 단어를 꺼내고 맵으로 이동
		// -> 결과: {짜장면=2, 짬뽕=1, 볶음밥=1, 김치쨰=2, 부대찌개=1, 된장찌개=1}
		TreeMap<String, Integer> wordsCount = new TreeMap<>();
		
		//String[]
		//Map<String, Integer>
		String[] words = sentence.split(" ");
		for(String w : words) {
			Integer count = wordsCount.getOrDefault(w, 0);
			wordsCount.put(w, count+1);
		}
		System.out.println(wordsCount);

		
		System.out.println();
		
		
		HashMap<String, Integer> wordCount2 = new HashMap<>();
		for(String w : words) {
			Integer count = wordCount2.get(w);
			if(count != null) {
				wordCount2.put(w, count+1);
			} else {
				wordCount2.put(w, 1);
			}
			System.out.println(wordCount2);
		}

		
		
		
		
	}

}
