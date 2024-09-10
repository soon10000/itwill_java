package traning01;

import java.util.Scanner;

public class LoopMain142 {

	public static void main(String[] args) {
	
		boolean run = true; // 프로그램을 계속 실행할 지 종료할 지를 결정하기 위한 변수
		int balance = 0; // 은행 계좌의 잔고를 저장하기 위한 변수.
		Scanner scanner = new Scanner(System.in); // 콘솔 입력을 위해서
		
		while (run) {
			System.out.println("--------------------------------------------");
			System.out.println("1. 입금 || 2. 출금 || 3. 잔고 || 4. 종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택 >> ");
			int menu = scanner.nextInt();
			switch(menu) {
			case 1:
				System.out.print("입금액 >> ");
				int deposit = scanner.nextInt();
				balance += deposit;
				break;
			case 2:
				System.out.print("출금액 >> ");
				int withdraw = scanner.nextInt();
				balance -= withdraw;
				break;
			case 3:
				System.out.println("잔고 : " + balance);
				break;
			case 4:
				run = false; // 변수 run이 false로 변경이 되기 때문에 while 무한루프가 끝남.
				System.out.println("안녕히 가세요~");
				break; // switch 문장을 종료
			default:
				System.out.println("1 ~ 4 중에서 선택하세요.");
			}
			
		}

	}
}