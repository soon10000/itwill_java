package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05 {

	private JFrame frame;
	private final JLabel lblName = new JLabel("이름");
	private JTextField nameText;
	private JTextField phoneText;
	private JTextField emailText;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JTextArea textArea;
	private JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
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
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblName.setFont(new Font("굴림", Font.BOLD, 12));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 10, 101, 31);
		frame.getContentPane().add(lblName);
		
		nameText = new JTextField();
		nameText.setBounds(125, 10, 150, 31);
		frame.getContentPane().add(nameText);
		nameText.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("굴림", Font.BOLD, 12));
		lblPhone.setBounds(12, 51, 101, 31);
		frame.getContentPane().add(lblPhone);
		
		phoneText = new JTextField();
		phoneText.setColumns(10);
		phoneText.setBounds(125, 51, 150, 31);
		frame.getContentPane().add(phoneText);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("굴림", Font.BOLD, 12));
		lblEmail.setBounds(12, 92, 101, 31);
		frame.getContentPane().add(lblEmail);
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(125, 92, 150, 31);
		frame.getContentPane().add(emailText);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 16));
		textArea.setBounds(12, 146, 410, 93);
		frame.getContentPane().add(textArea);
		
		btn = new JButton("입력");
		btn.addActionListener( e -> personInfo());
		btn.setFont(new Font("굴림", Font.BOLD, 18));
		btn.setBounds(287, 10, 135, 113);
		frame.getContentPane().add(btn);
	}
	
	private void personInfo() {
		String name = nameText.getText();
		String phone = phoneText.getText();
		String email = emailText.getText();
		String info = String.format("이름:%s, 전화번호:%s, 이메일:%s\n",name, phone, email);
		textArea.append(info);
		nameText.setText("");
		phoneText.setText("");
		emailText.setText("");
	}

}
