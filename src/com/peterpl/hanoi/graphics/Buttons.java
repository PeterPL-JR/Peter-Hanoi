package com.peterpl.hanoi.graphics;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import com.peterpl.hanoi.*;

public class Buttons extends JButton {
	private static final long serialVersionUID = 1L;

	public static final int width = 250;
	public static final int height = 50;
	
	private Actions action;
	
	public Buttons(String text) {
		super(text);
		setSize(width, height);
		setFocusPainted(false);
		setFont(new Font("Verdana", Font.BOLD, 15));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBorder(new LineBorder(Color.gray, 3));
		
		action = () -> {};
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action.action();
			}
		});
	}

	public void setAction(Actions action) {
		this.action = action;
	}
}
