package cometc_05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class RegisterWindow {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow window = new RegisterWindow();
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
	public RegisterWindow() {
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

		JLabel nameLabel = new JLabel("用户名");
		nameLabel.setBounds(55, 52, 54, 15);
		frame.getContentPane().add(nameLabel);

		JLabel passwordLabel = new JLabel("密码");
		passwordLabel.setBounds(55, 87, 54, 15);
		frame.getContentPane().add(passwordLabel);

		JLabel sexlLabel = new JLabel("性别");
		sexlLabel.setBounds(55, 124, 54, 15);
		frame.getContentPane().add(sexlLabel);

		JLabel birthdayLabel = new JLabel("生日");
		birthdayLabel.setBounds(55, 160, 54, 15);
		frame.getContentPane().add(birthdayLabel);

		JLabel hoppyLabel = new JLabel("喜好");
		hoppyLabel.setBounds(55, 194, 54, 15);
		frame.getContentPane().add(hoppyLabel);

		textField = new JTextField();
		textField.setBounds(119, 49, 116, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(119, 84, 116, 21);
		frame.getContentPane().add(passwordField);

		final JRadioButton maleRadioButton = new JRadioButton("男");
		buttonGroup.add(maleRadioButton);
		maleRadioButton.setBounds(115, 120, 50, 23);
		frame.getContentPane().add(maleRadioButton);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("女");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(167, 120, 121, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1990",
				"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998",
				"1999", "2000" }));
		comboBox.setBounds(91, 157, 54, 21);
		frame.getContentPane().add(comboBox);

		JLabel label = new JLabel("年");
		label.setBounds(145, 160, 18, 15);
		frame.getContentPane().add(label);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

		comboBox_1.setBounds(167, 157, 33, 21);
		frame.getContentPane().add(comboBox_1);

		JLabel lbll = new JLabel("月");
		lbll.setBounds(210, 160, 25, 15);
		frame.getContentPane().add(lbll);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBox_2.setBounds(228, 157, 32, 21);
		frame.getContentPane().add(comboBox_2);

		JLabel label_1 = new JLabel("日");
		label_1.setBounds(270, 160, 32, 15);
		frame.getContentPane().add(label_1);
		final JCheckBox basketballCheckBox = new JCheckBox("篮球");
		basketballCheckBox.setBounds(97, 190, 68, 23);
		frame.getContentPane().add(basketballCheckBox);

		final JCheckBox footballCheckBox = new JCheckBox("足球");
		footballCheckBox.setBounds(167, 190, 103, 23);
		frame.getContentPane().add(footballCheckBox);

		JButton button = new JButton("完成");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 获取
				String name = textField.getText();
				char[] password = passwordField.getPassword();
				String str = String.valueOf(password);
				String sex = "女";
				if (maleRadioButton.isSelected()) {
					sex = "男";
				}

				String year = comboBox.getSelectedItem() + "";
				String month = comboBox_1.getSelectedItem() + "";
				String day = comboBox_2.getSelectedItem() + "";
				String birthday = year + "-" + month + "-" + day;
				String hobby = "";
				if (basketballCheckBox.isSelected()) {

					hobby += basketballCheckBox.getText()+",";

				}
				if (footballCheckBox.isSelected()) {

					hobby += footballCheckBox.getText();

				}
		
				// System.out.println(name);
				// System.out.println(str);
				// System.out.println(sex);
				// System.out.println(year+"-"+month+"-"+day);
				

//				util.getConnection();
//				try {
//					if (util.updateByPreparedStatement(sql, params)) {
//						JOptionPane.showMessageDialog(null, "注册成功");
//
//					}
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//			}
				
				User u = new User(name, str, sex, birthday, hobby);
				UsersDao dao = new UsersDao();
				try {
					if(dao.addUsers(u)){
						JOptionPane.showMessageDialog(null, "添加成功");
					}else{
						
						JOptionPane.showMessageDialog(null, "添加失败");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
				});
		button.setBounds(119, 221, 93, 31);
		frame.getContentPane().add(button);

	}
}
