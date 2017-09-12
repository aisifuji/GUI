package com.etc._06Task;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextField;

public class PuWindow {

	public JFrame frame;
	private String name;
	private String password;
	private String sex;
	private String birthday;
	private String hobby;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_1;

	public PuWindow(String name) {
		this.name = name;
		initialize();
	}

	public PuWindow(JFrame frame, String name, String password, String sex,
			String birthday, String hobby) {
		super();
		this.frame = frame;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.hobby = hobby;
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuWindow window = new PuWindow();
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
	public PuWindow() {
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

		JLabel label = new JLabel("欢迎" + name + "光临");
		label.setFont(new Font("宋体", Font.PLAIN, 45));
		label.setBounds(42, 10, 313, 31);
		frame.getContentPane().add(label);

		JButton button = new JButton("查看个人信息");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ShowWindow window = new ShowWindow();
				window.frame.setVisible(true);

			}
		});
		button.setBounds(10, 210, 105, 31);
		frame.getContentPane().add(button);

		JButton btnNewButton = new JButton("显示信息");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Object[][] data=new Object[20][20]; data[0][0]="1";
				 * data[0][1]="rose"; data[0][2]="男"; data[0][3]="足球";
				 * 
				 * data[1][0]="2"; data[1][1]="tom"; data[1][2]="女";
				 * data[1][3]="阅读";
				 * 
				 * data[2][0]="3"; data[2][1]="jcak"; data[2][2]="男";
				 * data[2][3]="足球"; String[] columnNames={"编号","名字","性别","爱好"};
				 * 
				 * DefaultTableModel model=new DefaultTableModel(data,
				 * columnNames);
				 * 
				 * JTable table = new JTable(model); JScrollPane scrollPane =
				 * new JScrollPane(table); scrollPane.setBounds(100, 100, 200,
				 * 200); table.setFillsViewportHeight(true);
				 * frame.getContentPane().add(scrollPane);
				 */

				 JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(135, 78, 253, 163);
				frame.getContentPane().add(scrollPane);
				table = new JTable();
				UsersDao dao = new UsersDao();

				try {
					Object[][] all = dao.showAll();
					// System.out.println(Arrays.deepToString(all));

					table.setModel(new DefaultTableModel(

					all, new String[] { "编号", "姓名", "性别", "爱好" }));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				scrollPane.setViewportView(table);

			}
		});
		btnNewButton.setBounds(331, 18, 93, 23);
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(340, 82, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(340, 127, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_1 = new JButton("查询");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JScrollPane scrollPane1 = new JScrollPane();
				scrollPane1.setBounds(114, 51, 205, 163);
				frame.getContentPane().add(scrollPane1);

				table_1 = new JTable();
				UsersDao ud = new UsersDao();
				try {
					List<User> list = ud.tofindone(textField.getText(),textField_1.getText());
					Object[][] data = new Object[10][4];
					for (int i = 0; i < list.size(); i++) {
						data[i][0] = list.get(i).getName();
						data[i][1] = list.get(i).getSex();
						data[i][2] = list.get(i).getBirthday();
						data[i][3] = list.get(i).getHobby();

					}

					table_1.setModel(new DefaultTableModel(data, new String[] {
							"姓名", "性别", "生日", "兴趣" }));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				scrollPane1.setViewportView(table_1);
                
			}
		});

		btnNewButton_1.setBounds(331, 178, 93, 23);
		frame.getContentPane().add(btnNewButton_1);

	}
}
