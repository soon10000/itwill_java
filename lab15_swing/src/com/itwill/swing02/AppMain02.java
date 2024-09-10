package com.itwill.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

	private JFrame frame;
	private JTextField textInput;
	private JLabel lblMessage; // 기존 initialize 메서드 안에 지역변수였지만, 외부 메서드에서도 호출하기 위해 외부 클래스 필드로 지정해줌

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain02 window = new AppMain02();
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
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 596, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // Absolute layout
		
		lblMessage = new JLabel("메세지를 입력하세요...");
		lblMessage.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(10, 10, 558, 67);
		frame.getContentPane().add(lblMessage);
		
		textInput = new JTextField();
		textInput.setHorizontalAlignment(SwingConstants.CENTER);
		textInput.setFont(new Font("D2Coding", Font.BOLD, 18));
		textInput.setBounds(10, 87, 558, 176);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		JButton btnInput = new JButton("입력"); // JButton 객체 생성
		
		// 버튼에 ActionListener 이벤트 핸들러(리스너)를 설정(등록) 
		btnInput.addActionListener(new ActionListener() {
			@Override // 버튼이 클릭 됐을 때 할 일을 작성
			public void actionPerformed(ActionEvent e) {
				// (지역) 내부 클랙스에서는 외부 클래스의 메서드를 사용할 수 있음.
				handleInputButtonClick();
			}
		});
		
		btnInput.setFont(new Font("D2Coding", Font.BOLD, 24));
		btnInput.setBounds(146, 273, 316, 99);
		frame.getContentPane().add(btnInput);
	}

	
	
	private void handleInputButtonClick() {
		// 1. JTextField에 입력된 문자열을 읽음
		String msg = textInput.getText();
		// 2. (1)에서 읽은 내용을 JLabel에 씀
		lblMessage.setText(msg);
		// 3. JTextFiled를 비움(JTextField)에 입력된 내용을 지움)
		textInput.setText(null);
	}	
}
