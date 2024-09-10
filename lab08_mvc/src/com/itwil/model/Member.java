package com.itwil.model;

// MVC (Model View Controller) 아키텍쳐에서 모델 역할을 담당하는 클래스. 데이터 클래스
// VO(Value Object 값을 가진 객체), DTO(Data Transfer Object 데이터 전달하는 객체)
public class Member {
	// field
	private String id;
	private String password;
	
	//constructor
	public Member() {}
	
	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}
	

	// method
	public String getId() {
		return this.id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Member(id=" + id + ", password =" + password + ")";
	}
	
}
