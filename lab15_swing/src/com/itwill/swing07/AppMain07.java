package com.itwill.swing07;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import com.itwill.swing07.MyFrame.Notifiable;

public class AppMain07 implements Notifiable{

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnInputDlg;
	private JButton btnCustomDlg;
	private JButton btnMyFrame;

	
	@Override
	public void notifyMessage(String message) { // MyFrame 내 Notifiable 인터페이스 내 추상 메서드를 오버라이드하는 메서드 
		btnMyFrame.setText(message);
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMsgDlg = new JButton("Message Dialog");
		btnMsgDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메시지 다이얼로그 보여주기
//				JOptionPane.showMessageDialog(frame, "안녕하세요");
				JOptionPane.showMessageDialog(
						frame,									// 부모 컴포넌트 
						"안녕하세요, swing!",					// 다이얼로그 메시지
						"연습", 								// 다이어롤그 타이틀(제목)
						JOptionPane.INFORMATION_MESSAGE);		// 메시지 타입 -> 메시지 아이콘
			}
		});
		btnMsgDlg.setBounds(12, 10, 410, 29);
		frame.getContentPane().add(btnMsgDlg);
		
		btnConfirmDlg = new JButton("Confirm Dialog");
		btnConfirmDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Confirm(확인) 다이얼로그 보여주기
				int result = JOptionPane.showConfirmDialog(
						frame, 									// 부모 컴포넌트
						"정말 삭제 할까요??", 					// 메시지
						"삭제 확인", 							// 타이틀
						JOptionPane.YES_NO_OPTION, 				// 옵션 타입(버튼 종류, 버튼 개수)
						JOptionPane.QUESTION_MESSAGE);			// 메시지 타입
				btnConfirmDlg.setText("confirm=" + result);
			}
		});
		btnConfirmDlg.setBounds(12, 49, 410, 29);
		frame.getContentPane().add(btnConfirmDlg);
		
		btnInputDlg = new JButton("Input Dialog");
		btnInputDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // showinputdialog 메서드를 이용해서 만들어보기
//				String text = JOptionPane.showInputDialog(frame, "검색어");
				final String[] selections = {"인*", "얼굴장부", "X", "너튜브"};
				Object text = JOptionPane.showInputDialog(
						frame,								// 부모 컴포넌트 
						"검색어를 입력하세요", 				// 메세지
						"검색어", 							// 타이틀
						JOptionPane.PLAIN_MESSAGE,			// 메세지 타입 																
						null, 								// 아이콘
						selections, 								// 선택값들
						selections[1]);								// 초기 선택값
				btnInputDlg.setText("입력 : " + text);
//				textArea.setText("이름 : " + text);
			}
		});
		btnInputDlg.setBounds(12, 88, 410, 29);
		frame.getContentPane().add(btnInputDlg);
		
		btnCustomDlg = new JButton("Custom Dialog");
		btnCustomDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 내가 만든 다이얼로그 보여주기
				MyDialog.showMyDialogn(frame);
			}
		});
		btnCustomDlg.setBounds(12, 127, 410, 29);
		frame.getContentPane().add(btnCustomDlg);
		
		
		// 순만 과제 
		btnMyFrame = new JButton("Custom Frame");
		btnMyFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomFrame.showCostomFrame();
			}
		});
		btnMyFrame.setBounds(12, 166, 410, 29);
		frame.getContentPane().add(btnMyFrame);
		
		
		
		// 선생님 문풀이 
		JButton btnOh = new JButton("Oh Frame");
		btnOh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JFrame을 상속받는 객체 보여주기
				MyFrame.showMyFrame(frame, AppMain07.this); // < 메인에 생성된 JFream 클래스의 frame 객체를 아규먼트로 전달
				// -> 아규먼트 frame : MyFrame 클래스가 부모 컴포넌트(JFrame) 정보를 사용할 수 있도록. 
				// -> 아규먼트 AppMain07.this : AppMain07 타입으로 생성된 객체(의 주소). 현재 객체
				//	MyFrame 클래스에서 AppMain07 객체의 public 메서드를 호출할 수 있도록 AppMain07.this 아규먼트 전달 
			}
		});
		btnOh.setBounds(12, 205, 410, 29);
		frame.getContentPane().add(btnOh);
		
	}
}
