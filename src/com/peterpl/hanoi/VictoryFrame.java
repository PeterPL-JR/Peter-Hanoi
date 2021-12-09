package com.peterpl.hanoi;

import java.awt.*;

import javax.swing.*;

import com.peterpl.hanoi.graphics.*;

public class VictoryFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel desc, again1, again2;
	private Buttons button;

	public static final int width = 500;
	public static final int height = 320;

	public VictoryFrame(JFrame frameParent) {
		frameParent.setEnabled(false);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		setSize(width, height);
		setTitle("Peter Hanoi - Victory!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		button = new Buttons("Play");
		button.setBounds(width / 2 - 80, 180, 160, 40);
		add(button);
		
		button.setAction(() -> {
			setVisible(false);
			Game.game.setVisible(true);
			
			CreateGame create = new CreateGame(Game.game);
			create.setDefaultCloseOperation(EXIT_ON_CLOSE);
			create.toFront();
		});
		
		create();
		setVisible(true);
	}

	private void create() {
		desc = new JLabel("Victory!");
		desc.setBounds(0, 0, width, 90);
		desc.setHorizontalAlignment(SwingConstants.CENTER);
		desc.setFont(new Font("Courier", Font.BOLD, 45));
		add(desc);

		again1 = new JLabel("You've won the game!");
		again1.setHorizontalAlignment(SwingConstants.CENTER);
		again1.setFont(new Font("Courier", Font.PLAIN, 25));
		again1.setBounds(0, 0, width, 190);
		add(again1);

		again2 = new JLabel("Play again?");
		again2.setHorizontalAlignment(SwingConstants.CENTER);
		again2.setFont(new Font("Courier", Font.PLAIN, 27));
		again2.setBounds(0, 115, width, 40);
		add(again2);
	}
}
