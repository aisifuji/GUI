package com.etc._01J;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("刘氏");
		frame.setBounds(0, 0, 100, 100);
		frame.setLayout(new FlowLayout());
		for(int i=0;i<10;i++){
			JButton buttom=new JButton("点我");

			frame.add(buttom);
			
			
		}
		
		
		
		
		
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}

}
