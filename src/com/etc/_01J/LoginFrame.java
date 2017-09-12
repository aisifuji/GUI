package com.etc._01J;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame {

	private JFrame frame;
	private JTextField usernametextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
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
	public LoginFrame() {
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
		frame.setLocationRelativeTo(null);
		JLabel usernamelabel = new JLabel("用户名");
		usernamelabel.setFont(new Font("宋体", Font.PLAIN, 15));
		usernamelabel.setBounds(58, 73, 54, 15);
		frame.getContentPane().add(usernamelabel);
		
		JLabel passwordlabel = new JLabel("密码");
		passwordlabel.setFont(new Font("宋体", Font.PLAIN, 15));
		passwordlabel.setBounds(58, 122, 54, 15);
		frame.getContentPane().add(passwordlabel);
		
		usernametextField = new JTextField();
		usernametextField.setBounds(164, 70, 133, 21);
		frame.getContentPane().add(usernametextField);
		usernametextField.setColumns(10);
		
		JButton button = new JButton("登入");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取
				String name = usernametextField.getText();
			   char[] password = passwordField.getPassword();
				String str=new String(password);
				System.out.println(name+","+str);
				//判断
				if(StringUtil.haslength(str)&&StringUtil.haslength(name)){
					if(name.equals("admin")&&str.equals("123456")){
//						JOptionPane.showMessageDialog(null, "登入成功");
						
						LoginSuccess window = new LoginSuccess(name);
						window.frame.setVisible(true);
						
						frame.setVisible(false);
					}else{
						
						JOptionPane.showMessageDialog(null, "账户或者密码错误");
					}
					
					
				}else{
					JOptionPane.showMessageDialog(null, "输入为空登入失败");
					
				}
				
			}
		});
		button.setBounds(151, 169, 118, 49);
		frame.getContentPane().add(button);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 119, 133, 21);
		frame.getContentPane().add(passwordField);
	}
}
