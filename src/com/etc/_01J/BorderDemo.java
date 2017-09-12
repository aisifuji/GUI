package com.etc._01J;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("便捷");
		frame.setBounds(100, 100, 200, 200);
		frame.setLayout(new BorderLayout());
		JButton buttom = new JButton("西");
		frame.add(buttom, BorderLayout.WEST);
		JButton buttom1 = new JButton("东");
		frame.add(buttom1, BorderLayout.EAST);
		JButton buttom2 = new JButton("南");
		frame.add(buttom2, BorderLayout.NORTH);
		JButton buttom3 = new JButton("北");
		frame.add(buttom3, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
