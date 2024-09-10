package com.itwill.swing07;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPanel;
	private JButton cancelButton;
	private JButton okButton;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	
	// 부모 컴포넌트를 저장하기 위한 필드
	private Component parentComponent;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void showMyDialogn(Component parentComponent) {
		try {
			MyDialog dialog = new MyDialog(parentComponent);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MyDialog(Component parentComponent) {
		this.parentComponent = parentComponent;
		initialize();
	}

	private void initialize() {
		// 다이얼로그의 좌표(x, y)와 크기(width, height)
		setBounds(100, 100, 450, 300);
		
		//setBounds의 (x, y)좌표를 무시하고 항상 부모 컴포넌트에 상대적으로(부모의 가운데 위치) 배치
		// 아규먼트가 null인 경우에는 화면 중앙에 배치
		setLocationRelativeTo(parentComponent);
		
		
		// 다이얼로그의 닫기 버튼(X)의 기본 동작을 설정:
		// DISPOSE_ON_CLOSE: 현재 다이얼로그만 닫고, 메인 프로세스는 계속 실행
		// EXIT_ON_CLOSE: 현재 다이얼로그와 함께 메인 프로세스까지 종료
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// getContentPane(): 컨텐트 영역 & 버튼 영역
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(32, 0, 95, 34);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(32, 41, 182, 41);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(32, 92, 102, 34);
		contentPanel.add(btnNewButton);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("굴림", Font.PLAIN, 12));
		cancelButton.setActionCommand("Cancel");
		buttonPanel.add(cancelButton);
		
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPanel.add(okButton);
				getRootPane().setDefaultButton(okButton);

	} // end initialize()
}
