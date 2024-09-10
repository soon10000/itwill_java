package com.itwill.loop09;

public class LoopMain09 {

	public static void main(String[] args) {
		// 중첩 while문을 사용해서 구구단 1단부터 12단까지 출력하시오
		
		int x = 1;
		while ( x < 13) {
			System.out.println( x + " 단 -----");
			
			int y =1;
			while (y < 13) {
				System.out.printf("%d x %d = %d\n", x, y, x*y);
				y++;
			} // 중첩 while문 종료
			
			x++;

		} // while문 종료


	}

}
