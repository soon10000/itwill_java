package com.itwill.contactoh;

import java.util.Scanner;


////////////// MVC의 역할을 명확하게 파악하기 필수!!!!! 정말 각 클래스들이 어떤 기능을 하는지!!!!!!


import com.itwill.ver02.ContactDao;
import com.itwill.ver02.ContactDaoImpl;

public class ContactMain {
	
	private final Scanner scanner =new Scanner(System.in); // 입력받을 스캐너 선언
	private ContactDao dao = ContactDaoImpl.getInstace(); // 다형성 이용

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.2 ***");

		ContactMain02 app = new ContactMain02(); // ? 왜 객체를 생성하는지 생성자 ㅇㄷ?

		boolean run = true;
		while (run) {
			int menu = app.selectMainMenu();
			switch (menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveNewContact();
				break;
			case 2:
				app.readAllContacts();
				break;
			case 3:
				app.readContactByIndex();
				break;
			case 4:
				app.updateContactByIndex();
				break;
			default:
				System.out.println("메뉴 번호(0 ~ 4)를 확인하세요.");
			}
		}

		System.out.println("*** 프로그램 종료 ***");
	}

	
	
	
	
	
	
	
	private void updateContactByIndex() {
		System.out.println("\n--- 연락처 수정 ---");

		System.out.print("인덱스 입력>> ");
		int index = inputInteger(); // inpurIntger 메소드를 호출(정수를 입력 받을 때 까지 재입력 받는 메소드) 

		if (!((ContactDaoImpl) dao).isValidIndex(index)) { // 만약 daoimple 객체 내 isValidIndex 메소드를 호출하고 조건부와 맞지 않으면 연락처 정보가 없습니다 후 리턴
			System.out.println("해당 인덱스에는 수정할 정보가 없습니다...");
			return;
		}

		Contact old = dao.read(index);
		System.out.println("수정전: " + old);

		System.out.print("이름 수정>> ");
		String name = scanner.nextLine();

		System.out.print("전화번호 수정>> ");
		String phone = scanner.nextLine();

		System.out.print("이메일 수정>> ");
		String email = scanner.nextLine();

		Contact updated = new Contact(name, phone, email); // Contact타입에 입력 받은 새로운 정보를 update(모델 생성자) 저장 

		int result = dao.update(index, updated); // daoImpl에 작성 된 update 메소드를 호출하여 인덱스 번호를 받고 update 파라미터에 저장
		if (result == 1) {
			System.out.println(">>> 연락처 수정 성공");
		} else {
			System.out.println(">>> 연락처 수정 실패");
		}

	}
	
	
	
	
	
	
	

	private void readContactByIndex() {
		System.out.println("\n--- 인덱스 검색 ---");

		System.out.print("인덱스 입력>> ");
		int index = inputInteger(); // inputInteger 메소드를 그대로 호출

		if (!((ContactDaoImpl) dao).isValidIndex(index)) { // 만약 daoimple 객체 내 isValidIndex 메소드를 호출하고 조건부와 맞지 않으면 연락처 정보가 없습니다 후 리턴
			System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
			return;
		}

		Contact contact = dao.read(index); // 그렇지 않으면 인덱스 넘버를 입력 받고 null이 아니면 해당 문구 노출(toString 오버라이드 메소드 노출)
		if (contact != null) {
			System.out.println(contact);
		} else {
			System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
		}
	}
	
	
	
	
	
	
	
	
	
	

	private void readAllContacts() { // 0으로 초기화된 인덱스 전용 변수를 생성하고 배열 인덱스가 null이 아닌 인덱스들만 프린트문을 이용하여 출력 
		System.out.println("\n--- 연락처 목록 ---");

		Contact[] contacts = dao.read();
		int index = 0;
		for (Contact c : contacts) {
			if (c != null) {
				System.out.println("[" + index + "] " + c);
				index++;
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	private void saveNewContact() {
		System.out.println("\n--- 새 연락처 저장 ---");

		if (((ContactDaoImpl) dao).isMemoryFull()) { // 다오임플 타입으로 캐스팅하면 isMemory 메소드가 보여 호출이 가능 (count가 MAX_LENGTH 값이랑 동일한지
			System.out.println("저장 공간이 부족합니다...");  // 동일하면 리턴, 그렇지 그 아래 코드 실행 
			return; // 메서드 종료
		}

		System.out.print("이름 입력>> "); // 입력한 스트링을 name 에 저장
		String name = scanner.nextLine();

		System.out.print("전화번호 입력>> "); 입력한 스트링을 phone 에 저장
		String phone = scanner.nextLine();

		System.out.print("이메일 입력>> ");
		String email = scanner.nextLine(); 입력한 스트링을 email 에 저장

		Contact contact = new Contact(name, phone, email); // 위에서 입력받은 스트링들을 Contact 타입 contact배열 생성하며 저장
		int result = dao.create(contact); // dao변수(Impl 객체 다형성) 내에 있는 create 메소드를 입력받고 조건부에 맞으면 1을 리턴 받으니 result에 저장
		if (result == 1) {                // 1이 맞으면 성공 아니면 실패
			System.out.println(">>> 연락처 저장 성공");
		} else {
			System.out.println(">>> 연락처 저장 실패");
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	private int selectMainMenu() { //  해당 메소드가 작동하면 위에 보이는 프린트문을 출력하고 inputInteger() 메소드를 호출하고 입력 받은 값을 
		System.out.println("\n----------------------------------------------");  // menu 변수값에 저장하고 리턴
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.println("----------------------------------------------");
		System.out.print("선택> ");

		int menu = inputInteger();

		return menu;
	}

	
	
	
	
	
	
	
	
	
	
	
	private int inputInteger() { //try-catch문을 이용하여 정수가 입력될 때 까지(Excention이 발생 안 할때 까지  
		int result = 0;          //재입력을 받고, 정수가 이렵되면 result 변수에 해당 정수를 넣고 리턴

		while (true) {
			try {
				result = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("입력값은 정수여야 합니다.");
				System.out.print("정수 입력>> ");
			}
		}

		return result;
	}

}
