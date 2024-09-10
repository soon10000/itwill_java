package com.itwill.inheritance06;

import java.util.Objects;

public class User {
	// field
	private String id;
	private String password;
	
	// constructor
	public User() {}
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	
	// toString 재정의 - id와 password를 출력
	@Override
	public String toString() {
		return "User 아이디 : " + id + ", 비밀번호 : " + password;
	}
	
	// equals 재정의 - id만 같으면 같은 객체, 그렇지 않으면 다른 객체
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof User && id != null) {
			User other = (User) obj;
			result = id.equals(other.id);
		}
		return result;
	}
	
	// hashCode 재정의 - id가 같은 User 객체는 같은 정수값이 리턴되도록.
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	
	

}
