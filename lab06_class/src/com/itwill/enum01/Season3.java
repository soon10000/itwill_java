package com.itwill.enum01;

public enum Season3 { // enum은 private static final 로 생성된 상수
	SPRING("봄"),
	SUMMER("여름"),
	FALL("가을"),
	WINTER("겨울");
	
	
	private String name;
	
	
	// enum의 생성자의 접근 수식어는 private만 사용 가능. private은 생략 가능
	Season3(String name) { // enum의 생성자는 public으로 공개할 수 없음.
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
