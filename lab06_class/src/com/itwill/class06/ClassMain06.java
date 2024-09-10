package com.itwill.class06;


public class ClassMain06 {

	public static void main(String[] args) {
		// Account 타입 객체 생성
		Account account1 = new Account(3925, 1000);
		account1.info();

		
		Account account2 = new Account(3158, 10000);
		account2.info();
		
		
		// account1 계좌에 10,000원 입금
		account1.deposit(10_000);
		System.out.println("입금 후 잔액 : " + account1.balance);
		
		// account1 계좌에서 5,000원 출금
		account1.withdraw(5_000);
		
		
		account1.transfer(account2, 2000);
		
		account1.info();
		account2.info();
		
		// account2 에서 account1으로 10,000원 이체
		account2.transfer(account1, 10_000);
		
		account1.info();
		account2.info();

	}

}
