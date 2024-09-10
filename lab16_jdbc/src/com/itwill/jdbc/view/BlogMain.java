package com.itwill.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;
import com.itwill.jdbc.view.BlogCreateFrame.CreateNotify;

import oracle.sql.OPAQUE;

import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogMain implements CreateNotify{
	private static final String[] SEARCH_TYPES = {"제목", "내용", "제목+내용", "작성자"}; // 콤보박스 보기
	
	private static final String[] COLUMN_NAMES = {"번호", "제목", "작성자", "수정시간"}; // J테이블에 기준이 되는 Column name
	

	private JFrame frame;
	private JComboBox<String> comboBox;
	private JPanel searchPanel;
	private JTextField textSearchKeyword;
	private JButton btbSearch;
	private JPanel buttonPanel;
	private JButton btnReadAll;
	private JButton btnCreate;
	private JButton btnDetails;
	private JButton btnDelete;
	private JTable table;
	private JScrollPane scrollPane;
	
	private DefaultTableModel tableModel;
	
	private BlogDao dao = BlogDao.getInstance(); // 싱글턴 객체 생성 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogMain window = new BlogMain();
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
	public BlogMain() {
		initialize();
		initializeTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("블로그 메인"); // 화면창 이름 설정
		
		searchPanel = new JPanel();
		frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
		
		comboBox = new JComboBox<String>();
		final DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(SEARCH_TYPES); // 콤보박스 보기 상수 객체 생성
		comboBox.setModel(comboBoxModel); //setModel 메서드에 콤보박스 객체 넣기
		
		comboBox.setFont(new Font("굴림", Font.BOLD, 12));
		searchPanel.add(comboBox);
		
		textSearchKeyword = new JTextField();
		textSearchKeyword.setFont(new Font("굴림", Font.BOLD, 12));
		searchPanel.add(textSearchKeyword);
		textSearchKeyword.setColumns(10);
		
		btbSearch = new JButton("검색"); // 콤보박스에 선택된 값을 찾아야함. 검색 필드에 입력된 값을 찾아야함
		btbSearch.addActionListener((e) -> search());
		btbSearch.setFont(new Font("굴림", Font.BOLD, 12));
		searchPanel.add(btbSearch);
		
		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		btnReadAll = new JButton("목록보기");
		btnReadAll.addActionListener((e) -> initializeTable());
		btnReadAll.setFont(new Font("굴림", Font.BOLD, 12));
		buttonPanel.add(btnReadAll);
		
		btnCreate = new JButton("새 블로그");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 새 블로그 작성 창 띄우기
				BlogCreateFrame.showBlogCreateFrame(frame, BlogMain.this);
			}
		});
		btnCreate.setFont(new Font("굴림", Font.BOLD, 12));
		buttonPanel.add(btnCreate);
		
		btnDetails = new JButton("상세보기");
		btnDetails.setFont(new Font("굴림", Font.BOLD, 12));
		buttonPanel.add(btnDetails);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener((e) -> deleteBlog());
		btnDelete.setFont(new Font("굴림", Font.BOLD, 12));
		buttonPanel.add(btnDelete);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		tableModel = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 메인 컬럼 리스트
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
	}
	
	private void search() {
		int type = comboBox.getSelectedIndex(); // 콤보박스에서 선택된 아이템의 인덱스
		String keyword = textSearchKeyword.getText(); // 검색어
		if (keyword.equals("")) {
			JOptionPane.showMessageDialog(frame, "검색어를 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			textSearchKeyword.requestFocus(); // -> 검색어 입력 JTextField에 포커스를 줌(커서 깜박깜박).
			return;
		}
		
		// DAO 메서드를 호출해서 검색 결과를 가져옴.
		List<Blog> blogs = dao.search(type, keyword);
		resetTable(blogs); // 테이블 리셋.
	}

	
	
	
	
	
	
	private void initializeTable() {
		// DAO를 사용해서 DB 테이블에서 검색.
		List<Blog> blogs = dao.read();
		resetTable(blogs); // 테이블 리셋
		
		
	}
	
	
	
	private void resetTable(List<Blog> blogs) {
		// 검색한 내용을 JTable에 보여줌. - JTable의 테이블 모델을 재설정.
		tableModel = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 모델 리셋
		for (Blog b : blogs) {
			// DB 테이블에서 검색한 행 레코드를 JTable에서 사용할 행 데이터로 변환
			Object[] row = { 
					b.getId(),
					b.getTitle(),
					b.getWriter(),
					b.getCreatedTime()
			};
			tableModel.addRow(row); // 테이블 모델에 행 데이터를 추가
		}
		table.setModel(tableModel); // JTable의 모델을 다시 세팅
	}
	
	
	private void deleteBlog() {
		int index = table.getSelectedRow(); // 테이블에서 선택된 행의 인덱스
		if(index == -1) { //JTable에서 선택되너 행이 없을 때
			JOptionPane.showMessageDialog(frame, "삭제 할 행을 선택하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) {
			// 선택된 행에서 블로그 번호(id)를 읽음
			Integer id = (Integer)tableModel.getValueAt(index, 0);
			// DAO의 delete 메서드를 호출
			int result = dao.delete(id);
			if (result == 1) {
				initializeTable(); // 테이블을 새로고침
				JOptionPane.showMessageDialog(frame, "삭제 성공");				
			} else {
				JOptionPane.showMessageDialog(frame, "삭제 실패");				
			}
		}
		
	}
	
	@Override
	public void notifyCreateSuccess() {
		// 테이블에 insert 성공했을 때 BlogCreateFrame이 호출하는 메서드
		initializeTable();
		JOptionPane.showMessageDialog(frame, "새 블로그 등록 성공");
	}
	
	
	

}
