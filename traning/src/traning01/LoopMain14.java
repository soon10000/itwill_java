package traning01;

import java.util.Scanner;

public class LoopMain14 {

	public static void main(String[] args) {
		// 교재 연습문제 7 (선생님 해답)
		
		boolean run = true; // 프로그램을 계속 실행할 지 종료할 지를 결정하기 위한 변수
		int balance = 0; // 은행 계좌의 잔고를 저장하기 위한 변수.
		Scanner scanner = new Scanner(System.in); // 콘솔 입력을 위해서
		
		while (run ) {
			System.out.println("--------------------------------------------");
			System.out.println("1. 입금 || 2. 출금 || 3. 잔고 || 4. 종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택 >> ");
			int menu = scanner.nextInt();
			System.out.println("menu = " + menu);
			if (menu == 1) {
				// todo : 입금 기능 구현 
			} else if (menu == 2) {
				// todo : 출금 기능 구현
			} else if (menu == 3) {
				// todo : 잔고 확인
			} else if (menu == 4) {
				System.out.println("안녕히 가세요~");
				break;
			} else { // 에러메세지
				System.out.println("1 ~ 4 중에서 선택하세요.");
			}
		}
		
		System.out.println("프로그램 종료");

	}

}
