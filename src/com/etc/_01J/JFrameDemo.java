package com.etc._01J;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JFrameDemo {
	public static void main(String[] args) {
		
		JFrame frame=new JFrame();
		frame.setTitle("Hello，World");
		frame.setBounds(100, 100, 200, 200);
		frame.setLayout(new FlowLayout());
		
//		 frame.show();
		 JLabel label=new JLabel("你好");
		 frame.add(label);
		 JButton button=new JButton("点我");
		 frame.add(button);
		 button.setBounds(0,0, 0, 0);
		 button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "点我干嘛");
			}
		});
		 frame.setVisible(true);
		 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		
		
	}

}
