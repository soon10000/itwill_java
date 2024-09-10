package com.itwill.inheritance01;

// 스마트TV는 기본 TV를 확장(상속)한다.
// 상위(super), 부모(parent), 기본(base) 클래스 - BasicTv
// 하위(sub), 자식(child), 유도(derived) 클래스 - SmartTv
// 모든 클래스의 최상위 클래스는 java.lang.object 클래스.
// 상위클래스가 java.lang.object인 경우 extends object는 생략 가능하다.

public class SmartTv extends BasicTv {

	private String ip;

	public void webBrowsing() {
		System.out.println("인터넷 연결");

	}

	
}
