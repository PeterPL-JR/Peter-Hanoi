package com.peterpl.hanoi;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import com.peterpl.hanoi.graphics.*;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;

	public static final int width = 800;
	public static final int height = 600;

	private JLabel logo;
	private Buttons[] buttons;

	public Menu() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		setSize(width, height);
		setTitle(Game.title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		logo = new JLabel("Peter Hanoi");
		logo.setBounds(width / 2 - 250, 20, 480, 100);
		logo.setFont(new Font("Courier New", Font.BOLD, 55));
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setOpaque(true);
		logo.setBackground(Color.lightGray);
		logo.setBorder(new LineBorder(Color.gray, 6));
		add(logo);

		createButtons();
		setVisible(true);
	}

	private void createButtons() {

		buttons = new Buttons[3];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Buttons(null);
			buttons[i].setBounds(width / 2 - 135, 200 + i * 60, 250, 50);
			buttons[i].setFocusPainted(false);
			add(buttons[i]);
		}

		buttons[0].setText("Play");
		buttons[1].setText("Options");
		buttons[2].setText("Quit");

		buttons[0].setAction(() -> {
			new CreateGame(this);
		});
		buttons[1].setAction(() -> {
		});
		buttons[2].setAction(() -> {
			System.exit(0);
		});
	}
}
