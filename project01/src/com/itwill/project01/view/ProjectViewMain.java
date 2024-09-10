package com.itwill.project01.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectViewMain {
	private static final String[] SEARCH_TYPES = {"카테고리", "상호명", "지역", "세부지역"}; // 콤보박스 보기
	private static final String[] COLUMB_TYPES = {"번호", "카테고리", "상호명", "지역", "세부지역", "방문여부"}; // 콤보박스 보기

	private JFrame frame;
	private JLabel lblMainText;
	private JPanel ButtonPanel;
	private JButton btnEdit;
	private JButton btnDelete;
	private JPanel panel;
	private JComboBox comboBox;
	private JTextField textField;
	private JLabel lblSearch;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectViewMain window = new ProjectViewMain();
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
	public ProjectViewMain() {
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
		
		lblMainText = new JLabel("TASTY RESTAURANT GUIDE");
		lblMainText.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblMainText.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainText.setBounds(12, 10, 410, 60);
		frame.getContentPane().add(lblMainText);
		
		ButtonPanel = new JPanel();
		ButtonPanel.setBounds(12, 57, 410, 40);
		frame.getContentPane().add(ButtonPanel);
		ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCreate = new JButton("ADD");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		ButtonPanel.add(btnCreate);
		
		btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		ButtonPanel.add(btnEdit);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		ButtonPanel.add(btnDelete);
		
		panel = new JPanel();
		panel.setBounds(12, 98, 410, 40);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		DefaultComboBoxModel<String> comboBoxMedel = new DefaultComboBoxModel<>(SEARCH_TYPES);
		comboBox.setModel(comboBoxMedel);
		comboBox.setBounds(118, 5, 76, 30);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(206, 6, 151, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		lblSearch = new JLabel("검색");
		lblSearch.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setBounds(54, 5, 60, 30);
		panel.add(lblSearch);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 148, 410, 403);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("굴림", Font.BOLD, 12));
		DefaultTableModel tableModel = new DefaultTableModel(null, COLUMB_TYPES);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
	}
}
