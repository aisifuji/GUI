package com.etc._01J;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("便捷");
		frame.setBounds(100, 100, 200, 200);
		frame.setLayout(new GridLayout(3,2));
		for(int i=0;i<6;i++){
			JButton button = new JButton("点我");
			frame.add(button);		
		}
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
