package com.etc._06Task;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ShowWindow {

	public JFrame frame;
	private User user;

	public ShowWindow(User user) {
		super();
		this.user = user;
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowWindow window = new ShowWindow();
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
	public ShowWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JTextArea textArea = new JTextArea(TempData.name);
		textArea.setBounds(118, 32, 100, 24);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea(TempData.password);
		textArea_1.setBounds(118, 79, 100, 24);
		frame.getContentPane().add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea(TempData.sex);
		textArea_2.setBounds(118, 122, 100, 24);
		frame.getContentPane().add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea(TempData.birthday);
		textArea_3.setBounds(118, 170, 100, 24);
		frame.getContentPane().add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea(TempData.hobby);
		textArea_4.setBounds(118, 212, 100, 24);
		frame.getContentPane().add(textArea_4);
		
		
		JButton button = new JButton("保存修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		button.setBounds(310, 122, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(310, 170, 93, 23);
		frame.getContentPane().add(button_1);
	}
}
