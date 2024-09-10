package com.itwil.view;

import java.util.Scanner;
import com.itwil.controller.MemberDaoImpl;
import com.itwil.model.Member;

// MVC 아키텍쳐에서 뷰(UI:User Interface) 역할을 담당하는 클래스
public class MemberMain {

	private final Scanner scanner = new Scanner(System.in);
	private MemberDaoImpl dao = MemberDaoImpl.getInstance(); // 컨트롤러(controller)
	
	public static void main(String[] args) {
		System.out.println("*** 회원 관리 프로그램 ***");
		
		// MemberMain 타입 객체의 인스턴스 맴버(필드, 메서드)를 사용하기 위해서
		MemberMain app = new MemberMain();
		boolean run = true; // 프로그램을 종료 할 때 false로 변경하기 위한 변수
		
		while(run) {
			int menu = app.selectMainMenu();
			switch(menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveNewMember(); 
				break;
			case 2:
				app.readAllMembers();
				break;
			case 3:
				app.readMemberByIndex();
				break;
			case 4:
				app.updateMember();
				break;
			default:
				System.out.println("0~4 범위의 정수로 입력해주세요");	
			}
		}
		
		System.out.println("***** 프로그램 종료 *****");
	}
	
	
	
	
	private void updateMember() {
		System.out.println("\n------ 회원 정보 업데이트 ------");

		System.out.print("업데이트 할 인덱스>> ");
		int index = Integer.parseInt(scanner.nextLine());

		if (index >= 0 && index < dao.count()) {
			Member member = dao.read(index);
			System.out.println("수정 전" + member);
			System.out.print("새 비밀번호>> ");
			String password = scanner.nextLine();

			// View에서 Controller의 기능을 사용해서 비밀번호 업데이트
			int result = dao.update(index, password);
			if (result == 1) {
				System.out.println("비밀번호 업데이트 성공");
			} else {
				System.out.println("비밀번호 업데이트 실패");
			}
		} else {
			System.out.println("올바른 인덱스를 입력하세요.");
		}

	}

	private void readMemberByIndex() {
		System.out.println("\n------인덱스 검색-------");
		
		System.out.println("검색할 인덱스 입력해주세요>> ");
		int index = Integer.parseInt(scanner.nextLine());
		
		// View에서 Controller의 기능을 사용해서 해당 인덱스의 회원 정보를 가져옴
		Member member = dao.read(index);
		if (member != null) {
		System.out.println(member);
		} else {
			System.out.println("올바른 인덱스를 입력하세요");
		}
	}
	

	private void readAllMembers() {
		System.out.println("\n--------- 회원 목록 ---------");
		Member[] members = dao.read(); // View에서 Controller 기능을 사용, 출력할 데이터를 가져옴.
		for (Member m : members) {
			if (m != null) {
				System.out.println(m);
			}
		}

	}

	private void saveNewMember() {
		System.out.println("\n-------------- 새 회원 정보 저장 ---------------");
		
		MemberDaoImpl daoImpl = (MemberDaoImpl) dao;
		if (daoImpl.isMemoryFull()) {
			System.out.println("회원 정보를 저장할 메모리가 부족합니다.");
			return;
		}
		
		
		System.out.print("ID를 입력하세요>>");
		String id = scanner.nextLine();
		System.out.print("비밀번호를 입력하세요>>");
		String password = scanner.nextLine();
		Member member = new Member(id, password);
		int result = dao.create(member); // View 객체에서 Controller 객체의 기능을 사용
		if (result == 1 ) {
			System.out.println("회원 정보 저장 성공");
		} else {
			System.out.println("회원 정보 저장 실패");
		}
	
	}

	int selectMainMenu() {
		System.out.println("\n---------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.print("메뉴를 선택해주세요>> ");
		int menu = Integer.parseInt(scanner.nextLine());
		return menu;
	}
	
	
	

}
