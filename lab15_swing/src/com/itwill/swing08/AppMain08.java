package com.itwill.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain08 {
	private static final String[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};

	private JFrame frame;
	private JLabel lblKorean;
	private JTextField textKorean;
	private JTextField textEnglish;
	private JTextField textMath;
	private JScrollPane scrollPane;
	private JButton btnEnter;
	private JLabel lblMath;
	private JLabel lblEnglish;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain08 window = new AppMain08();
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
	public AppMain08() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 538, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblKorean = new JLabel("국어");
		lblKorean.setFont(new Font("굴림", Font.BOLD, 16));
		lblKorean.setHorizontalAlignment(SwingConstants.CENTER);
		lblKorean.setBounds(44, 7, 120, 40);
		frame.getContentPane().add(lblKorean);
		
		textKorean = new JTextField();
		textKorean.setHorizontalAlignment(SwingConstants.CENTER);
		textKorean.setFont(new Font("굴림", Font.BOLD, 16));
		textKorean.setBounds(176, 7, 282, 48);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);
		
		lblEnglish = new JLabel("영어");
		lblEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnglish.setFont(new Font("굴림", Font.BOLD, 16));
		lblEnglish.setBounds(44, 60, 120, 40);
		frame.getContentPane().add(lblEnglish);
		
		textEnglish = new JTextField();
		textEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		textEnglish.setFont(new Font("굴림", Font.BOLD, 16));
		textEnglish.setColumns(10);
		textEnglish.setBounds(176, 60, 282, 48);
		frame.getContentPane().add(textEnglish);
		
		lblMath = new JLabel("수학");
		lblMath.setHorizontalAlignment(SwingConstants.CENTER);
		lblMath.setFont(new Font("굴림", Font.BOLD, 16));
		lblMath.setBounds(44, 113, 120, 40);
		frame.getContentPane().add(lblMath);
		
		textMath = new JTextField();
		textMath.setHorizontalAlignment(SwingConstants.CENTER);
		textMath.setFont(new Font("굴림", Font.BOLD, 16));
		textMath.setColumns(10);
		textMath.setBounds(176, 113, 282, 48);
		frame.getContentPane().add(textMath);
		
		btnEnter = new JButton("입력");
		btnEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputScoreToTable();
				
				
			}
		});
		btnEnter.setFont(new Font("굴림", Font.BOLD, 16));
		btnEnter.setBounds(37, 166, 201, 40);
		frame.getContentPane().add(btnEnter);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 216, 421, 176);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteScoreFromTable();
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 16));
		btnDelete.setBounds(257, 166, 201, 40);
		frame.getContentPane().add(btnDelete);
	}

	private void deleteScoreFromTable() {
		// JTable에서 선택된 행의 인덱스 찾음
			int index = table.getSelectedRow();
			if (index == -1) { // 테이블에서 선택된 행이 없을 때
				JOptionPane.showMessageDialog(frame, "삭제할 행을 선택하세요.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제 할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				model.removeRow(index); // 테이블 (모델)에서 해당 인덱스의 행(row)를 삭제
			} else if (confirm == JOptionPane.YES_NO_OPTION) {
				return;
			}
	}

	private void inputScoreToTable() {
		// 1. JTextField에서 3과목의 점수를 읽는다.
		int korean = 0;
		int english = 0;
		int math = 0;
		
		try {
			korean =  Integer.parseInt(textKorean.getText());
			english =  Integer.parseInt(textEnglish.getText());
			math =  Integer.parseInt(textMath.getText());
		} catch (NumberFormatException e) {
			// TODO 메시지 다이얼로그 띄우기
			JOptionPane.showMessageDialog(frame, "과목별 점수는 정수만 입력하세요", "입력 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		textKorean.getText();
		textEnglish.getText();
		textMath.getText();
		
		// 2. Score 타입의 객체를 생성
		Score score = new Score(korean, english, math);
		
		
		// 3. JTable에 행(row)을 추가.
		Object[] row = {score.getKorean(), score.getEnglish(), score.getMath(), score.getTotal(), score.getMean()};
		model.addRow(row);
		
		// 4. JTextField의 값을 초기화한다(삭제)
		clearAllTextFields();
	}
	
	private void clearAllTextFields() {
		textKorean.setText("");
		textEnglish.setText("");
		textMath.setText("");
	}
}
