package com.itwill.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;

import javax.security.auth.login.AccountLockedException;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbProtected;
	private JRadioButton rbPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbAbstract;
	private JCheckBox cbFinal;
	private JCheckBox cbStatic;
	private JComboBox<String> comboBox;
	private JButton btnInfo;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	
	private JRadioButton selsectedRadioButton;
	private ArrayList<JCheckBox> seletedChechBoxes = new ArrayList<JCheckBox>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 544, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rbPrivate = new JRadioButton("private");
		rbPrivate.addActionListener(new ActionListener() { // 익명클래스
			@Override
			public void actionPerformed(ActionEvent e) { 
				handleRadioButtonClick(e); 
			}
		});
		rbPrivate.setSelected(true);
		buttonGroup.add(rbPrivate);
		rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 12));
		rbPrivate.setBounds(8, 6, 121, 23);
		frame.getContentPane().add(rbPrivate);
		
		
		rbPackage = new JRadioButton("package");
		rbPackage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPackage);
		rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 12));
		rbPackage.setBounds(133, 6, 121, 23);
		frame.getContentPane().add(rbPackage);
		
		
		rbProtected = new JRadioButton("protected");
		rbProtected.addActionListener(e -> handleRadioButtonClick(e));
		buttonGroup.add(rbProtected);
		rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 12));
		rbProtected.setBounds(258, 6, 121, 23);
		frame.getContentPane().add(rbProtected);
		
		rbPublic = new JRadioButton("public");
		rbPublic.addActionListener(this::handleRadioButtonClick);
		// AppMain06.this::handleRadioButtonClick
		buttonGroup.add(rbPublic);
		rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 12));
		rbPublic.setBounds(383, 6, 121, 23);
		frame.getContentPane().add(rbPublic);
		
		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				handleCheckBoxClick(e);
			}
		});
		cbAbstract.setBounds(8, 44, 115, 23);
		frame.getContentPane().add(cbAbstract);
		
		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener( e -> handleCheckBoxClick(e));
		cbFinal.setBounds(133, 44, 115, 23);
		frame.getContentPane().add(cbFinal);
		
		cbStatic = new JCheckBox("static");
		cbStatic.addActionListener(this::handleCheckBoxClick);
		cbStatic.setBounds(258, 44, 115, 23);
		frame.getContentPane().add(cbStatic);
		
		// 제너릭 타입으로 선언을 해야하기 때문에 필드 생성자에서 제너릭 타입으로 선언해주면 오류 해결
		comboBox = new JComboBox<>(); // new JcomboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleComboBoxClick(e);
				
				
			}
		});
		comboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		final String[] emails = {"naver.com ", "gmail.com ", "kakao.com ", "yahoo.com "};
		final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(emails);
//		comboBox.setModel(new DefaultComboBoxModel<>(emails));
		comboBox.setModel(model);
		comboBox.setBounds(8, 73, 240, 23);
		frame.getContentPane().add(comboBox);
		
		btnInfo = new JButton("확인");
		btnInfo.addActionListener((e) -> handleButtonClick());
		btnInfo.setBounds(258, 73, 97, 23);
		frame.getContentPane().add(btnInfo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 106, 508, 206);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane.setViewportView(textArea);
	}
	
	
	

	private void handleButtonClick() {
		// JTextArea에 출력할 문자열들을 붙여 나갈(apeend) 문자열 버퍼
		StringBuffer buffer = new StringBuffer();
		// 어떤 라디오버튼 선택 됐는지
		if(rbPrivate.isSelected()) { // 라디오버튼 타입의 변수를 만든 후 getSource를 통해 짧은 코드로 만들 수 있음
			buffer.append(rbPrivate.getText());
		} else if (rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		} else if (rbProtected.isSelected()) {
			buffer.append(rbProtected.getText());
		} else { 
			buffer.append(rbPublic.getText());
		}
		buffer.append(" 라디오버튼 선택됨,\n");
		
		// 어떤 체크박스(들)이 선택 됐는지
		if (cbAbstract.isSelected()) {          // 체크박스 배열의 리스트 변수를 만든 후 getSource를 통해 짧은 코드로 만들 수 있음
			buffer.append(cbAbstract.getText()).append(" ");
		}
		if (cbFinal.isSelected()) {
			buffer.append(cbFinal.getText()).append(" ");
		}
		if (cbStatic.isSelected()) {
			buffer.append(cbStatic.getText()).append(" ");
		}
		buffer.append(" 체크박스 선택됨,\n");
		
		// 콤보박스에서 선택된 아이템
		Object item = comboBox.getSelectedItem();
		buffer.append(item).append("콤보박스 선택됨");
		
		
		//문자열 버퍼의 내용을 JTextArea에 출력
		textArea.setText(buffer.toString());
	}

	private void handleComboBoxClick(ActionEvent event) {
		// 이벤트가 발생한 컴포넌트(JComboBox) 찾기
		@SuppressWarnings("unchecked")
		JComboBox<String> combo = (JComboBox<String>) event.getSource();
		
		// 콤보박스에서 선택된 아이템 찾기
		 int index = combo.getSelectedIndex(); // 콤보박스에서 선택된 아이템의 인덱스
		 String item = (String) combo.getSelectedItem(); // 'combo'변수가 JComboBox<String> 원소이기 때문에 String으로 캐스팅이 가능
		 
		 //JTextArea에 정보 출력
		 textArea.setText(index + ":" + item);
		
		
		
	}

	private void handleCheckBoxClick(ActionEvent event) {
		JCheckBox jc = (JCheckBox) event.getSource();
		String text = jc.getText();
		boolean select = jc.isSelected();
		textArea.setText(text + " : " + select);
	}

	// 해당 메소드의 경우 클릭되는 라디오버튼 이벤트에 따라 작동을 다르게 진행해줘야하기 때문에 액션이벤트를 아규먼트로 받아야 함
	private void handleRadioButtonClick(ActionEvent event) {
		// 4개의 라디오버튼들 중에서 누가 클릭 됐는지 찾기
		JRadioButton rb = (JRadioButton) event.getSource();
		String text = rb.getText(); // 이벤트가 발생한 라디오 버튼의 텍스트
		boolean selected = rb.isSelected(); // 리턴 타입이 boolean인 경우 대체적으로 is 메서드를 주로 이용함 / 이벤트가 발생한 라디오 버튼의 선택 여부
		textArea.setText(text + " : " + selected);
	}
}
