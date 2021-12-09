package com.peterpl.hanoi;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import com.peterpl.hanoi.graphics.*;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Game game;

	public static final int width = 1200;
	public static final int height = 800;

	public static int circlesCount;
	public static final String title = "Peter Hanoi - Beta 1.0";

	public StickPanel[] sticks;
	public Circle[] circles;
	public Timer timer;
	public Moves moves;

	public Game() {
		setSize(width, height);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		sticks = new StickPanel[3];
		for (int i = 0; i < 3; i++) {

			sticks[i] = new StickPanel(i, sticks);
			sticks[i].setBorder(new LineBorder(Color.black));
			add(sticks[i]);
		}

		circles = new Circle[circlesCount];
		for (int i = 0; i < circles.length; i++) {
			circles[i] = new Circle(new Color(0x630e0e), i);
			circles[i].setRandomColor();
		}

		for (int i = 0; i < circles.length; i++) {
			sticks[0].addCircle(circles[i]);
		}

		for (int i = 0; i < circles.length; i++) {
			for (int j = 0; j <= circles.length; j++) {

				if (i == j)
					break;
				while (circles[i].color.equals(circles[j].color)) {
					circles[i].setRandomColor();
				}
			}
		}

		timer = new Timer();
		timer.setLocation(width - 250, 5);
		add(timer);

		moves = new Moves();
		moves.setLocation(5, 5);
		add(moves);

		setVisible(true);
	}

	public static void win() {
		game.timer.stop();
		new VictoryFrame(game);
	}

	public static void main(String[] args) {
		new Menu();
	}
}
