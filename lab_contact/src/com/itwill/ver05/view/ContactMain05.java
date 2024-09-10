package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;
import com.itwill.ver05.view.ContactCreateFrame.CreateNotify;
import com.itwill.ver05.view.ContactUpdateFrame.UpdateNotify;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactMain05 implements CreateNotify, UpdateNotify {

	private static final String[] COLUMN_NAMES = { "이름", "전화번호" };

	private ContactDao dao = ContactDaoImpl.getInstance();

	private JFrame frame;
	private JPanel buttonPanel;
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;
	private DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain05 window = new ContactMain05();
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
	public ContactMain05() {
		initialize(); // UI 컨포넌트들(버튼, 테이블, ...)을 생성, 초기화
		loadContactData(); // ContactDao를 사용해서 연락처 파일에 저장된 연락처 데이터를 테이블에 로딩
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 530, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("연락처 ver0.5");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

		btnCreate = new JButton("새 연락처");
		btnCreate.addActionListener(e -> ContactCreateFrame.showContactCreateFrame(frame, ContactMain05.this));

		btnCreate.setFont(new Font("굴림", Font.BOLD, 14));
		buttonPanel.add(btnCreate);

		btnUpdate = new JButton("업데이트");
		btnUpdate.addActionListener((e) -> updateContact()); // 행을 선택 후 업데이트 버튼을 눌렀을 때 정보가 넘어가 수정할 수 있도록 폼을 작성
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 14));
		buttonPanel.add(btnUpdate);

		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(e -> deleteContact());
		btnDelete.setFont(new Font("굴림", Font.BOLD, 14));
		buttonPanel.add(btnDelete);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(e -> ContactSearchFrame.showContactSearchFrame(frame));
		btnSearch.setFont(new Font("굴림", Font.BOLD, 14));
		buttonPanel.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		// 테이블에서 컬럼 이름의 폰트 설정	
		table = new JTable();
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

	private void loadContactData() {
		// DAO를 사용해서 파일에 저장된 데이터를 읽어옴.
		List<Contact> list = dao.read();
		// 리스트의 연락처들을 테이블에 행으로 추가
		for (Contact c : list) {
			Object[] row = { c.getName(), c.getPhone() };
			model.addRow(row);
		}
	}

	private void resetTable() { // 테이블을 새로 그리는 메서드
		// 데이터를 모두 지운 새로운 테이블 모델 객체를 생성
		model = new DefaultTableModel(null, COLUMN_NAMES);
		// 파일에 저장된 연락처(새 연락처가 추가된 데이터)를 로딩
		loadContactData();
		// 새 테이블 모델을 테이블에 다시 세팅
		table.setModel(model);
		// 사용자에게 알림
	}

	public void notifyContactCreated() {
		resetTable(); // 테이블을 처음부터 다시 새로 그림
		JOptionPane.showMessageDialog(frame, "새 연락처 저장 성공");
	}

	private void deleteContact() {
		int index = table.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(frame, "테이블에서 삭제할 행을 선택하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제 할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			int result = dao.delete(index);
			if (result == 1) {
				JOptionPane.showMessageDialog(frame, "삭제 성공");
				// 테이블 새로 그리기
				resetTable();
			} else {
				// TODO 삭제 실패 알림 메시지
			}

		}

	}

	private void updateContact() {
		int index = table.getSelectedRow();
		// 테이블에서 업데이트하기 위해서 선택한 행의 인덱스를 찾음
		if (index == -1) {
			JOptionPane.showMessageDialog(frame, "업데이트 할 행을 선택하세요.");
			return;
		}
		// 업데이트 프레임
		ContactUpdateFrame.showContactUpdateFrame(frame, index, ContactMain05.this);
	}

	@Override
	public void notifyContactUpdated() {
		// ContactUpdateFrame에서 연락처 정보를 성공적으로 업데이트 하면 호출 호출하는 메서드
		// 테이블을 새로 그림(리셋)
		resetTable();
		// 사용자에게 메세지
		JOptionPane.showMessageDialog(frame, "업데이트 성공");
	}

}
