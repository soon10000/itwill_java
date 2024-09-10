package com.itwill.inner02;

public class Book {
	private String title; // 제목
	private String auther; // 저자
	private String publisher;  // 출판사
	
	// constructor overloading
	public Book() {}
	public Book(String title, String auther, String publisher) {
		this.title = title;
		this.auther = auther;
		this.publisher = publisher;
	}
	public Book(String title) {
//		this.title = title;
		this(title, null, null); // 오버로딩 된 다른 생성자 호출
	}
	
	// overloading 되지 않는 경우:
//	public Book(String auther) {
//		this.auther = auther;
//	}
	
	// overloading 가능한 경우
//	public Book(String title, String auther) {
//		this(title, auther, null);
//	}
//	
//	public Book(String title, String publisher) {
//		
//	}
	
	@Override
	public String toString() {
		return String.format("Book(제목:%s, 저자:%s, 출판사:%s)", title, auther, publisher);
	}
	
	// --- Builder(Factory) 디자인 패턴
	public static BookBuilder builder() {
		return new BookBuilder();
		 // 외부 클래스에서 내부 클래스의 private 생성자를 호출할 수 있음.
	}
	
	public static class BookBuilder{
		private String title;
		private String auther;
		private String publisher;
		
		private BookBuilder() {}
		
		public BookBuilder title(String title) {
			this.title = title;
			return this; // 생성된 객체(인스턴스)를 리턴
		}
		
		public BookBuilder auther(String auther) {
			this.auther = auther;
			return this;
		}
		
		public BookBuilder publisher(String publisher) {
			this.publisher = publisher;
			return this;
		}
		
		public Book build() {
			return new Book(title, auther, publisher);
		}
	} // end class boolbuilder
	
	// --- 

}
