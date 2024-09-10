package com.itwill.swing03;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AppMain03 {
	
	private static final String[] IMAGES = {
			"images/image1.jpg",
			"images/image2.jpg",
			"images/image3.jpg",
			"images/image4.jpg",
			"images/image5.jpg"
	};
	
	private int curIndex; // 현재 화면에 보여지는 이미지 아이콘의 인덱스
	
	private JFrame frame;
	private JLabel lblImage;
	private JButton btnNext;
	private JButton btnPrev;
	private JLabel ImageName;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain03 window = new AppMain03();
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
	public AppMain03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblImage = new JLabel(new ImageIcon(IMAGES[curIndex]));
		lblImage.setBounds(80, 40, 400, 400);
		frame.getContentPane().add(lblImage);
		
		btnPrev = new JButton("<");
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 이전 이미지 보여주기 5 > 4 > 3 > 2 > 1 > 5 > 4
				showPrevImage();
			}
		});
		btnPrev.setFont(new Font("굴림", Font.BOLD, 22));
		btnPrev.setBounds(80, 464, 120, 60);
		frame.getContentPane().add(btnPrev);
		
		btnNext = new JButton(">");
		// 람다 표현식을 사용한 이벤트 리스너 등록
		btnNext.addActionListener(e -> showNextImage());
		btnNext.setFont(new Font("굴림", Font.BOLD, 22));
		btnNext.setBounds(360, 464, 120, 60);
		frame.getContentPane().add(btnNext);
		
		ImageName = new JLabel(IMAGES[curIndex]);
		ImageName.setFont(new Font("굴림", Font.BOLD, 12));
		ImageName.setHorizontalAlignment(SwingConstants.CENTER);
		ImageName.setBounds(212, 464, 136, 60);
		frame.getContentPane().add(ImageName);
	}
	
	private void showPrevImage() {
		if (curIndex > 0) { // 현재 이미지의 인덱스가 0보다 크면
			curIndex --; // 인덱스를 1씩 감소
		} else { // 현재 이미지 인덱스가 0인 경우(첫번째 이미지인 경우)
			curIndex = IMAGES.length -1; // 배열의 마지막 인덱스
		}
		// JLabel의 이미지 아이콘을 이전 이미지 아이콘으로 변경
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
		ImageName.setText(IMAGES[curIndex]);
	}
	
	private void showNextImage() {
		if (curIndex < IMAGES.length -1) {
			curIndex ++;
		} else {
			curIndex = 0;
		}
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
		ImageName.setText(IMAGES[curIndex]);
	}
}
