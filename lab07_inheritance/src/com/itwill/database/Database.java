package com.itwill.database;

public interface Database {
	// field
	int DB_VERSION = 1; // public static final 필드
	
	/**
	 * 데이터베이스의 테이블에서 자료들을 검색하고 정수를 리턴.
	 * @return 검색된 자료 개수
	 */
	int select(); // 추상 메서드 public abstract method
	
	
	/**
	 * 데이터베이스의 테이블에 자료를 추가하고 성공이면 1, 실패하면 0을 리턴
	 * @return 1 = 성공, 0 = 실패
	 */
	int insert();

}
