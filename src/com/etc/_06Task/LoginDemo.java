package com.etc._06Task;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class LoginDemo {

	public JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton btnregister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDemo window = new LoginDemo();
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
	public LoginDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel userlabel = new JLabel("用户名");
		userlabel.setFont(new Font("宋体", Font.PLAIN, 15));
		userlabel.setBounds(57, 82, 54, 21);
		frame.getContentPane().add(userlabel);

		JLabel passwordlabel = new JLabel("密码");
		passwordlabel.setFont(new Font("宋体", Font.PLAIN, 15));
		passwordlabel.setBounds(57, 121, 54, 21);
		frame.getContentPane().add(passwordlabel);

		usernameField = new JTextField();
		usernameField.setBounds(132, 79, 135, 24);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(132, 118, 135, 24);
		frame.getContentPane().add(passwordField);

		JButton btnLogin = new JButton("登入");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 获取
				String str = usernameField.getText();
				char[] password = passwordField.getPassword();
				String str1 = new String(password);
				// 判断空
				if (StringUtil.haslength(str) && StringUtil.haslength(str1)) {
					User u = new User(str, str1, null, null, null);
					UsersDao dao = new UsersDao();
					try {
						User user1 = dao.findOne(u);

						if (user1 != null) {
                              TempData.name=user1.getName();
                              TempData.password=user1.getPassword();
                              TempData.sex=user1.getSex();
                              TempData.birthday=user1.getBirthday();
                              TempData.hobby=user1.getHobby();
							
							PuWindow window = new PuWindow(str);
							window.frame.setVisible(true);
							frame.dispose();
						} else {

							JOptionPane.showMessageDialog(null, "账号或密码错误，登入失败");

						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// 判断正确jdbc
					/*
					 * String sql =
					 * "SELECT name,password FROM t_users WHERE name=? AND password=?"
					 * ; JDBCUtils util = new JDBCUtils(); util.getConnection();
					 * List<Object> params = new ArrayList<Object>(); User n1 =
					 * new User(str, str1); params.add(n1.getName());
					 * params.add(n1.getPassword()); User n2 = null; try { if
					 * ((n2 = util.findSimpleRefResult(sql, params, User.class))
					 * != null) {
					 * 
					 * PuWindow window = new PuWindow(frame, n2.getName());
					 * window.frame.setVisible(true);
					 * 
					 * } else {
					 * 
					 * JOptionPane.showMessageDialog(null, "账号或密码错误，登入失败"); }
					 * 
					 * } catch (Exception e1) { // TODO Auto-generated catch
					 * block e1.printStackTrace(); }
					 * 
					 * } else { JOptionPane.showMessageDialog(null,
					 * "账号或密码为空，登入失败");
					 */

				} else {

					JOptionPane.showMessageDialog(null, "账号或密码为空，登入失败");
				}

			}
		});
		btnLogin.setBounds(132, 172, 106, 45);
		frame.getContentPane().add(btnLogin);

		btnregister = new JButton("注册");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RegisterWindow window = new RegisterWindow();
				window.frame.setVisible(true);
				frame.setVisible(false);

			}
		});
		btnregister.setBounds(292, 172, 106, 45);
		frame.getContentPane().add(btnregister);
	}
}
