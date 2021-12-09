package com.peterpl.hanoi;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import com.peterpl.hanoi.graphics.*;

public class CreateGame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JFrame frameParent;
	private JLabel desc, text;
	private Buttons button;

	public static final int width = 500;
	public static final int height = 300;

	public CreateGame(JFrame frameParent) {
		this.frameParent = frameParent;
		frameParent.setEnabled(false);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		setSize(width, height);
		setTitle(Game.title);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		create();
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frameParent.setEnabled(true);
			}
		});
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				requestFocusInWindow();
			}
		});
	}

	private void create() {
		desc = new JLabel("Circles Amount (4-8):");
		desc.setBounds(0, 0, width, 100);
		desc.setHorizontalAlignment(SwingConstants.CENTER);
		desc.setFont(new Font("Courier", Font.PLAIN, 25));
		add(desc);

		text = new JLabel();
		text.setBounds(width / 2 - 100, 90, 200, 50);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("Courier", Font.PLAIN, 25));
		text.setOpaque(true);
		text.setBackground(Color.white);
		text.setBorder(new LineBorder(Color.gray));
		text.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		text.setText("4");
		add(text);

		text.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				text.requestFocusInWindow();
			}
		});
		text.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				text.setBorder(new LineBorder(Color.gray, 2));
			}

			public void focusLost(FocusEvent e) {
				text.setBorder(new LineBorder(Color.gray));
			}
		});
		text.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				String[] chars = { "4", "5", "6", "7", "8" };
				for (String str : chars) {
					String key = e.getKeyChar() + "";
					if (key.equals(str)) {
						text.setText(str);
						break;
					}
				}
			}
		});

		button = new Buttons("Play");
		button.setBounds(width / 2 - 80, 180, 160, 40);
		add(button);

		button.setAction(() -> {
			String str = text.getText();
			if (!str.equals("")) {
				Game.circlesCount = Integer.parseInt(str);
				frameParent.setEnabled(true);
				frameParent.setVisible(false);
				setVisible(false);
				Game.game = new Game();
			}
		});
	}
}
