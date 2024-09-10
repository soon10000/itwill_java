package com.itwill.loop14;

import java.util.Scanner;

public class LoopMain14 {

	public static void main(String[] args) {
		// 7번 문제를 할 때 
		
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("------------김다인 님의 통장-------------");
			System.out.println("1. 예금 || 2. 출금 || 3. 잔고 || 4. 종료");
			System.out.println("-----------------------------------------");
			System.out.print("선택 : ");
			int x = scanner.nextInt();
			if(x == 1) {
				System.out.println("예금을 선택하셨습니다.");
				System.out.println("입금 하실 금액을 입력하세요.");
				System.out.print("입력하실 금액 : ");
				int y = scanner.nextInt();
				System.out.println(y + "원이 입금되었습니다.");
				System.out.println("현재 잔고는 총 : " + (balance + y) + "원 입니다.");
				balance += y;
			}
			if(x == 2) {
				System.out.println("출금을 선택하셨습니다.");
				System.out.println("출금 하실 금액을 입력하세요.");
				System.out.print("입력하실 금액 : ");
				int z = scanner.nextInt();
				System.out.println(z + "원이 출금 되었습니다.");
				System.out.println("현재 잔고는 총 : " + (balance - z) + "원 입니다.");
				balance -= z;
			}
			if(x == 3) {
				System.out.println("잔고 확인을 선택하셨습니다.");
				System.out.println("고객님의 현재 남은 잔고는 " + balance + "원입니다.");
			}
			if(x == 4) {
				System.out.println("종료를 선택하였습니다.");
				break;
			}
		} 
		System.out.println("프로그램을 종료하겠습니다.");
	}

}
