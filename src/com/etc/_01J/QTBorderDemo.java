
package com.etc._01J;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class QTBorderDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(500, 500, 500, 500);
		frame.setTitle("嵌套");
		frame.setLayout(new BorderLayout());
		//西边按钮
		JButton button=new JButton();
		frame.add(button, BorderLayout.WEST);
		button.setPreferredSize(new Dimension(100,100));
		button.setBackground(Color.BLUE);
		
		//南边按钮
		JButton button1=new JButton();
		frame.add(button1, BorderLayout.SOUTH);
		button1.setPreferredSize(new Dimension(100,100));
		button1.setBackground(Color.ORANGE);
		
		JPanel panel=new JPanel();
		frame.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.GREEN);
		JButton button2=new JButton("点我");
		button2.setPreferredSize(new Dimension(50,50));
		panel.add(button2, BorderLayout.NORTH);
		JPanel center_center=new JPanel();
		panel.add(center_center, BorderLayout.CENTER);
		center_center.setLayout(new FlowLayout());
		center_center.setBackground(Color.PINK);
		for(int i=0;i<5;i++){
			JButton button5=new JButton("点我");
			button5.setPreferredSize(new Dimension(50,50));
			center_center.add(button5);
			
		}
		
		
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		
		
	}

}
