package com.itwill.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Event;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;



public class AppMain04 {

	private JFrame frame;
	private JTextField num1field;
	private JTextField num2field;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMultiply;
	private JButton btnDivide;
	private JTextArea textArea;	
	private JLabel lblnum1;
	private JLabel lblnum2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
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
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblnum1 = new JLabel("num 1");
		lblnum1.setFont(new Font("굴림", Font.BOLD, 16));
		lblnum1.setHorizontalAlignment(SwingConstants.CENTER);
		lblnum1.setBounds(12, 58, 120, 50);
		frame.getContentPane().add(lblnum1);
		
		lblnum2 = new JLabel("num 2");
		lblnum2.setHorizontalAlignment(SwingConstants.CENTER);
		lblnum2.setFont(new Font("굴림", Font.BOLD, 16));
		lblnum2.setBounds(12, 139, 120, 50);
		frame.getContentPane().add(lblnum2);
		
		num1field = new JTextField();
		num1field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		num1field.setHorizontalAlignment(SwingConstants.CENTER);
		num1field.setFont(new Font("굴림", Font.BOLD, 16));
		num1field.setBounds(144, 58, 260, 50);
		frame.getContentPane().add(num1field);
		num1field.setColumns(10);
		
		num2field = new JTextField();
		num2field.setHorizontalAlignment(SwingConstants.CENTER);
		num2field.setFont(new Font("굴림", Font.BOLD, 16));
		num2field.setColumns(10);
		num2field.setBounds(144, 139, 260, 50);
		frame.getContentPane().add(num2field);
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnPlus.setFont(new Font("굴림", Font.BOLD, 20));
		btnPlus.setBounds(12, 224, 80, 60);
		frame.getContentPane().add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);				
			}
		});
		btnMinus.setFont(new Font("굴림", Font.BOLD, 20));
		btnMinus.setBounds(121, 224, 80, 60);
		frame.getContentPane().add(btnMinus);
		
		btnMultiply = new JButton("x");
		btnMultiply.addActionListener(e -> handleButtonClick(e));
		btnMultiply.setFont(new Font("굴림", Font.BOLD, 20));
		btnMultiply.setBounds(230, 224, 80, 60);
		frame.getContentPane().add(btnMultiply);
		
		btnDivide = new JButton("/");
		btnDivide.addActionListener(this::handleButtonClick);
		// AppMain04.this::handleButtonCilck
		btnDivide.setFont(new Font("굴림", Font.BOLD, 20));
		btnDivide.setBounds(342, 224, 80, 60);
		frame.getContentPane().add(btnDivide);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea.setBounds(12, 335, 410, 141);
		frame.getContentPane().add(textArea);
	}
	
	private void handleButtonClick(ActionEvent event) {
		// JTextField에 입력된 문자열을 숫자(double)로 변환
		double x = 0;
		double y = 0;
		try {
			x = Double.parseDouble(num1field.getText());
			y = Double.parseDouble(num2field.getText());
		} catch (NumberFormatException ex) {
			textArea.setText("정수만 입력하세요");
			return; // 메서드 종료
		}
		double result = 0; // 사칙연산 결과를 저장할 변수
		String operator = ""; // 사칙연산 기호(+, -, x, /)
		
		Object source = event.getSource();
		if (source == btnPlus) {
			result = x + y;
			operator = "+";
		} else if (source == btnMinus){
			result = x - y;
			operator = "-";
		} else if (source == btnMultiply){
			result = x * y;
			operator = "*";
		} else if (source == btnDivide) {
			result = x / y;
			operator = "/";
		}
		
		String msg = String.format("%f %s %f = %f",x, operator, y, result);
		textArea.setText(msg);
	}

}
