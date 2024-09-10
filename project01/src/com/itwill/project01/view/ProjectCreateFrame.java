package com.itwill.project01.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.project01.controller.ProjectDao;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import static com.itwill.project01.jdbc.OracleJdbc.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton; 

public class ProjectCreateFrame extends JFrame {
	
	private static final String CATEGORI_NAME[] = {"한식", "중식", "일식", "양식", "퓨전", "고기" ,"회", "기타"};

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldSaveName;
	private JLabel lblSaveName;
	private JTextField textFielAdderess;
	private JTextField textField;
	private JPanel panel;
	private JLabel lblCategori;
	private JComboBox comboBoxCategori;
	private JComboBox comboBoxCity;
	private JLabel lblCity;
	private JComboBox comboBoxBorough;
	private JLabel lblBorough;
	private JLabel lblAddress;
	private JLabel lblMemo;
	private JPanel panel_1;
	private JRadioButton rdbtnVisiteYes;
	private JRadioButton rdbtnVisiteNo;
	private JLabel lblVisite;
	private JLabel lblMainTitle;
	
	private ProjectDao dao = ProjectDao.getInstance();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectCreateFrame frame = new ProjectCreateFrame();
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
	public ProjectCreateFrame() {
		setTitle("맛집 추가");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 401, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMainTitle = new JLabel("맛집 등록");
		lblMainTitle.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblMainTitle.setBounds(12, 10, 109, 15);
		contentPane.add(lblMainTitle);
		
		panel = new JPanel();
		panel.setBounds(12, 35, 361, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblSaveName = new JLabel("맛집 이름");
		lblSaveName.setBounds(32, 8, 70, 35);
		lblSaveName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		panel.add(lblSaveName);
		
		textFieldSaveName = new JTextField();
		textFieldSaveName.setBounds(115, 12, 216, 33);
		panel.add(textFieldSaveName);
		textFieldSaveName.setColumns(10);
		
		lblCategori = new JLabel("카테고리");
		lblCategori.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblCategori.setBounds(51, 95, 70, 35);
		contentPane.add(lblCategori);
		
		comboBoxCategori = new JComboBox();
		comboBoxCategori.setBounds(128, 102, 155, 26);
		DefaultComboBoxModel<String> comboBoxCategoriModel = new DefaultComboBoxModel<String>(CATEGORI_NAME);
		comboBoxCategori.setModel(comboBoxCategoriModel);
		contentPane.add(comboBoxCategori);
		
		comboBoxCity = new JComboBox();
		comboBoxCity.setBounds(128, 140, 155, 26);
		List<String> citis = dao.getCities();
		for(String s : citis) {
			comboBoxCity.addItem(s);
		}
		contentPane.add(comboBoxCity);
		
		lblCity = new JLabel("지역");
		lblCity.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblCity.setBounds(51, 133, 70, 35);
		contentPane.add(lblCity);
		
		
		comboBoxBorough = new JComboBox();
		comboBoxCity.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedCity = (String) comboBoxCity.getSelectedItem();
				if(selectedCity != null) {
					List<String> boroughs = dao.getBoroughs(selectedCity);
					
					comboBoxBorough.removeAllItems();
					for (String s : boroughs) {
						comboBoxBorough.addItem(s);
					}
				}
			}
		});
		comboBoxBorough.setBounds(128, 183, 155, 26);
		contentPane.add(comboBoxBorough);
		
		lblBorough = new JLabel("구");
		lblBorough.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblBorough.setBounds(51, 176, 70, 35);
		contentPane.add(lblBorough);
		
		textFielAdderess = new JTextField();
		textFielAdderess.setColumns(10);
		textFielAdderess.setBounds(95, 223, 278, 33);
		contentPane.add(textFielAdderess);
		
		lblAddress = new JLabel("세부주소");
		lblAddress.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblAddress.setBounds(23, 221, 70, 35);
		contentPane.add(lblAddress);
		
		lblMemo = new JLabel("메모");
		lblMemo.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblMemo.setBounds(23, 266, 70, 35);
		contentPane.add(lblMemo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(95, 268, 278, 33);
		contentPane.add(textField);
		
		panel_1 = new JPanel();
		panel_1.setBounds(22, 311, 351, 30);
		contentPane.add(panel_1);
		
		lblVisite = new JLabel("방문 여부");
		lblVisite.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		panel_1.add(lblVisite);
		
		
		rdbtnVisiteYes = new JRadioButton("예");
		rdbtnVisiteYes.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		panel_1.add(rdbtnVisiteYes);
		
		rdbtnVisiteNo = new JRadioButton("아니오");
		rdbtnVisiteNo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		panel_1.add(rdbtnVisiteNo);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnVisiteYes);
		buttonGroup.add(rdbtnVisiteNo);
		rdbtnVisiteNo.setSelected(true);
		
		btnSave = new JButton("저장하기");
		btnSave.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnSave.setBounds(78, 351, 100, 30);
		contentPane.add(btnSave);
		
		btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnCancel.setBounds(205, 351, 100, 30);
		contentPane.add(btnCancel);
	}
	
	static final String SQL_SELECT_CITY = "SELECT CITY FROM ADDRESS";
	private JButton btnSave;
	private JButton btnCancel;
}
