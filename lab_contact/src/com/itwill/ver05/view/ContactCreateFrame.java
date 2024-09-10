package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {
	
	public interface CreateNotify{
		public void notifyContactCreated();
	}
	
	private CreateNotify app; // 연락처 저장 성공을 알려줄 객체

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPanel;
	private JPanel buttonPanel;
	private JButton btnSave;
	private JButton btnCancle;
	private JLabel lblName;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblPhone;
	
	private Component parentComponent; // CreateFrame의 부모 컴포넌트
	private ContactDao dao = ContactDaoImpl.getInstance();
	

	/**
	 * Launch the application.
	 */
	public static void showContactCreateFrame(Component parentComponent, CreateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactCreateFrame frame = new ContactCreateFrame(parentComponent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public ContactCreateFrame(Component parentComponent, CreateNotify app) {
		this.parentComponent = parentComponent;
		this.app = app;
		initialize();
	}
	
	
	
	
	
	public void initialize() {
		setTitle("새 연락처 저장");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 0;
		int y = 0;
		if (parentComponent != null) {
			// 부모 컴포넌트가 있으면 부모 컴포넌트와 같은 좌표(x, y)에 위치 시킴
			x = parentComponent.getX();
			y = parentComponent.getY();
		}
		setBounds(x, y, 450, 300);
		if(parentComponent == null) {
			// 부모 컴포넌트가 없으면 화면 중앙에 위치시킴.
			setLocationRelativeTo(null);
		}
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPanel = new JPanel();
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.BOLD, 16));
		lblName.setBounds(12, 10, 120, 40);
		contentPanel.add(lblName);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setFont(new Font("굴림", Font.PLAIN, 16));
		textName.setBounds(159, 10, 253, 40);
		contentPanel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("굴림", Font.BOLD, 16));
		lblPhone.setBounds(12, 77, 120, 40);
		contentPanel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setHorizontalAlignment(SwingConstants.CENTER);
		textPhone.setFont(new Font("굴림", Font.PLAIN, 16));
		textPhone.setColumns(10);
		textPhone.setBounds(159, 77, 253, 40);
		contentPanel.add(textPhone);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("굴림", Font.BOLD, 16));
		lblEmail.setBounds(12, 139, 120, 40);
		contentPanel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setFont(new Font("굴림", Font.PLAIN, 16));
		textEmail.setColumns(10);
		textEmail.setBounds(159, 139, 253, 40);
		contentPanel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener((e) -> saveContact()); // 입력한 내용을 저장
		buttonPanel.add(btnSave);
		
		btnCancle = new JButton("취소");
		btnCancle.addActionListener( e -> dispose()); // 현재 창만 닫음
		buttonPanel.add(btnCancle);
	}






	private void saveContact() {
		// 1. JTextField에서 저장할 이름, 전화번호, 이메일을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		// 2. Contact 타입 객체 생성
		Contact contact = new Contact(0, name, phone, email);
				
		// 3. DAO를 사용하여 파일에 저장
		int result = dao.create(contact);
		if (result == 1) { // 파일 저장 성공
			app.notifyContactCreated();
			dispose();
		} else { // 연락처 저장 실패
			JOptionPane.showMessageDialog(parentComponent, "연락처 저장 실패", "실패", JOptionPane.PLAIN_MESSAGE);
		}
	}

}
