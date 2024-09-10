package com.itwill.swing07;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame { // 선생님 문풀이 클래스
	public interface Notifiable { // 펑션 인터페이스를 생성하여 아래에 있는 추상 메서드를 구현하고 있는 클래스만 사용할 수 있도록 세팅
		public void notifyMessage(String msg);
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btn;
	
	private Component parentComponent; // 부모 컴포넌트를 저장하기 위한 필드
	private Notifiable app; // nitifyMessage(String msg) 메서드를 갖는 객체의 주소를 저장할 필드.

	/**
	 * Launch the application.
	 */
	// 메인 메서드를 쓰레드 메서드로 변경 (메서드는 run 메서드를 재정의
	public static void showMyFrame(Component parentComponent, Notifiable app) { // 메인 메서드 해당 창을 호출하는 메서드내에서 보내는 아규먼트를 전달받기 위해
		/*
		 * Component
		 * |__ Frame, JDialog 
		 */
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame(parentComponent, app);	// JFrame 생성
					frame.setVisible(true);							//JFrame 을 화면에 보여줌
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MyFrame(Component parentComponent, Notifiable app) { // 생성자 추가
		this.parentComponent = parentComponent; // 메인 필드값으로 만들어진 parentComponent 필드를 전달받은 아규먼트 parentComponent로 초기화
		this.app = app;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	public void initialize() { // 기존 MyFrame 생성자였지만, initialize 메서드로 변경
		// JFrame의 닫기 버튼의 기본 동작을 설정
		// EXIT_ON_CLOSE: 프로그램 종료(메인 쓰레드 종료)
		// DISPOSE_ON_CLOSE: 현재 JFrame만 닫음(메인 쓰레드는 계속 실행)
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if (parentComponent != null) {
			x = parentComponent.getX(); // 부모 컴포넌트의 x좌표
			y = parentComponent.getY(); // 부모 컴포넌트의 y좌표
		}
		setBounds(x, y, 450, 300);
		
		if (parentComponent ==  null) { // 부모 컴포넌트 정보가 없을 때 
			setLocationRelativeTo(null); // 화면 중앙에 위치시킴 
		}
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane); // contentPame = 팝업창 메인 화면
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.BOLD, 16));
		textField.setBounds(12, 10, 410, 69);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btn = new JButton("확인");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// JTextField의 내용을 읽음
			String msg = textField.getText();
			app.notifyMessage(msg);			
			}
		});
		btn.setBounds(12, 89, 410, 59);
		contentPane.add(btn);
	}
}
