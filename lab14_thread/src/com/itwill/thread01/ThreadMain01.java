package com.itwill.thread01;


/*
 * 쓰레드 사용법 1:
 *  (1). Thread 상속하는 클래스 선언
 *  (2). (1)에서 선언한 클래스에서 run 메서드를 재정의(override) -> 쓰레드가 할 일 
 *  (3). (2)에서 작성한 클래스의 객체를 생성
 *  (4). (3)에서 생성된 객체의 strat() 메서드 호출 -> 쓰레드 실행됨.
 *  (주의) 쓰레드 객체의 run 메서드를 직접 호출하면 안 됨
 *  이유 : start() 호출 -> JRE에서 쓰레드를 초기화(메모리 할당, 스케쥴링 등등...)
 *                      -> run() 메서드가 호출됨.
 *   
 */

public class ThreadMain01 {

	public static void main(String[] args) {
		
		// (1)번 절차 실행 Thread를 상속하는 클래스 선언
		class MyThread extends Thread{
			private String name;
			public MyThread(String name) {
				this.name = name;
			}
			
			//(2)번 절차 실행 run 메서드 재정의
			@Override
			public void run() { 
				for(int i = 0; i < 100 ; i++) {
					System.out.println(i + " : " + name);
					try {
						sleep(100); // Thread 클래스의 static 메서드 호출 - 0.1초(100ms = 100/1000초)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		} // MyThread 클래스 종료
		
		// (3)번 절차 진행 MyThread 객체 생성
		MyThread th1 = new MyThread("쓰레드");
		MyThread th2 = new MyThread("Hello");
		MyThread th3 = new MyThread("안녕하세요");
		
		long start = System.currentTimeMillis(); // 쓰레드 시작 시간
		
		// (4)번 절차 진행 MyTread 객체의 star() 메서드 호출
		th1.start();
		th2.start();
		th3.start();
		
		// main 프로세스가 실행시킨 다른 프로세스(쓰레드)들이 모두 종료 될 때 까지 기다림
		try {
			th1.join();
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
		long end = System.currentTimeMillis(); // 쓰레드 종료 시간
		
		System.out.println("경과시간 : " + (end - start));
		System.out.println("***** main 메서드 종료 *****");
	}

}
