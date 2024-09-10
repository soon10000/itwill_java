package com.itwill.inner03;

public class Button {
	// public static 내부 인터페이스 -> 내부 인터페이스의 경우 static 인터페이스만 사용이 가능하므로 static 수식어는 생략이 가능
	public interface OnClickListener {
		void onClick(); // public abstract 메서드
		
	} 
	
	// field
	private String btnName;
	private OnClickListener listener;
	
	// constructor
	public Button(String btnName) {
		this.btnName = btnName;
	}
	
	// setter
	public void setOnClickListener (OnClickListener listener) {
		this.listener = listener;
	}
	
	// method
	public void click() {
		System.out.print(btnName + " 버튼 : " );
		listener.onClick();
	}
	

}
