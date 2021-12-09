package com.peterpl.hanoi;

import java.awt.*;

import javax.swing.*;

public class Moves extends JPanel {
	private static final long serialVersionUID = 1L;
	private int moves = 0;
	private JLabel count;
	
	public static final int width = 180;
	public static final int height = 65;
	
	public Moves() {
		setSize(width, height);
		setLayout(null);

		count = new JLabel("Moves: 0");
		count.setBounds(0, 0, width, height);
		count.setHorizontalAlignment(SwingConstants.CENTER);
		count.setFont(new Font("Verdana", Font.PLAIN, 30));
		add(count);
	}
	
	public void addMove() {
		moves++;
		count.setText("Moves: " + moves + "");
	}
	
	public int getMoves() {
		return moves;
	}
}
