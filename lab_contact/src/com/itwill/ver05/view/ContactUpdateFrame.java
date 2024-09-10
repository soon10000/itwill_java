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
import java.lang.Thread.Builder.OfPlatform;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {
	public interface UpdateNotify {
		void notifyContactUpdated();
	}
	
	private UpdateNotify app; // 메인 쓰레드 주소를 저장하기 위한 객체

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
	
	private Component parentComponent; // 부모 컴포넌트를 저장하기 위한 필드
	private int index; // 업데이트 할 연락처의 리스트 index를 저장하기 위한 필드
	private ContactDao dao = ContactDaoImpl.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void showContactUpdateFrame(Component parentComponent, int index, UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(parentComponent, index, app);
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
	public ContactUpdateFrame(Component parentComponent, int index, UpdateNotify app) {
		this.parentComponent = parentComponent;
		this.index = index;
		this.app = app;
		initialize();
		initializeTextFields();
		
	}
	
	private void initializeTextFields() {
		// 3개의 텍스트 필드에 해당 인덱스의 연락처 정보를 채움.
		Contact contact = dao.read(index);
		textName.setText(contact.getName());
		textPhone.setText(contact.getPhone());
		textEmail.setText(contact.getEmail());
		
	}
	
	
	public void initialize() {
		setTitle("연락처 업데이트");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 0;
		int y = 0;
		if (parentComponent != null) {
			x = parentComponent.getX();
			y = parentComponent.getY();
		}
		setBounds(x, y, 450, 300);
		if (parentComponent == null) {
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
		btnSave.addActionListener((e) -> updateContact());
		buttonPanel.add(btnSave);
		
		btnCancle = new JButton("취소");
		btnCancle.addActionListener((e) -> dispose());
		buttonPanel.add(btnCancle);
	}
	
	private void updateContact() {
		// 업데이트 할 내용을 읽는다.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		Contact contact = new Contact(0, name, phone, email);
		int result = dao.update(index, contact);
		if (result == 1) {
			// 메인 쓰레드에게 업데이트 성공을 알려줌.
			app.notifyContactUpdated();
			// 현재 창 닫기
			dispose();
		} 
	}

}
