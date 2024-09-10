package com.itwill.print;

public class PrintMain {

	public static void main(String[] args) {
		// 여러가지 콘솔 출력 방법:
		
		System.out.println("한 줄 출력(print line)");
		System.out.println("1+2"); // "1 + 2" 라고 하는 문자열(string)을 출력
		System.out.println(1+2); // 1+2 덧셈 결과를 출력 따옴표 있고 없고 차이
		System.out.println("1+2="+3); // 문자열이 아닌 + 는 이어주는 역할(마치 엑셀 & 느낌)
		System.out.println("1+2="+1+2); // 1+2=12 이라고 나와야 정상
		System.out.println("1+2="+(1+2)); // 1+2=3 이라고 나와야 정상 문자열이 있는지 체크
		
		System.out.print("안녕하세요~");
		System.out.println("Hello");
		
		//formatted printing: 형식을 갖는 출력문(숫자간 일정한 간격을 유지하고 싶을 때 사용)
		// \n: 줄바꿈(new line)
		// \t: 탭(tap)
		System.out.printf("문자열 포맷: 정수(%d), 실수(%f), 문자열(%s)\n", 123, 3.14,"하이");
		System.out.printf("%d + %d = %d",1,2,(1+2));
	}

}
