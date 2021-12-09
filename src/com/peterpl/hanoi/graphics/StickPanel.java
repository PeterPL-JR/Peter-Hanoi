package com.peterpl.hanoi.graphics;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import com.peterpl.hanoi.*;

public class StickPanel extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	public String action = "stay"; // stay OR checked
	
	public ArrayList<Circle> circles;
	public StickPanel[] sticks;
	private ColorSquare stick;
	public Buttons button;
	
	public static final int width = Game.width / 3;
	public static final int height = Game.height;
	
	public static final int stickWidth = 24;
	public static final int stickHeight = 350;
		
	public StickPanel(int index, StickPanel[] sticks) {
		circles = new ArrayList<>();
		this.sticks = sticks;

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
		}
		
		setSize(width, height);
		setLocation(index * width, 0);
		setLayout(null);
		
		stick = new ColorSquare(new Color(0x1a1a1a), stickWidth, stickHeight);
		stick.setLocation(width / 2 - stickWidth / 2, 130);
		add(stick);
		
		button = new Buttons((index + 1) + "");
		button.setLocation(width / 2 - Buttons.width / 2, 600);
		add(button);
		
		button.setAction(() -> {
			for(int i = 0; i < sticks.length; i++) {
				if(sticks[i] == this) continue;
				
				for(int j = 0; j < sticks[i].circles.size(); j++) {
					Circle c = sticks[i].circles.get(j);
					
					boolean validIndex;
					if(this.circles.size() == 0)
						validIndex = true;
					else
						validIndex = this.circles.get(circles.size() - 1).size >= c.size;
					
					if(!validIndex)
						c.setChecked(false);
					
					if(c.isChecked() && validIndex) {
						c.setChecked(false);
						sticks[i].removeCircle(j);
						this.addCircle(c);
						Game.game.moves.addMove();
						isVictory();
						return;
					}
				}
			}
			
			int getIndex = circles.size() - 1;
			if(getIndex >= 0) {
				Circle c = circles.get(getIndex);
				c.setChecked(c.isChecked() ? false : true);
				action = action == "stay" ? "checked" : "stay";
			}
		});
	}
	
	public void addCircle(Circle circle) {
		circles.add(circle);
		add(circle, 0);
		drawCircles();
	}
	
	public void removeCircle(int index) {
		remove(circles.get(index));
		circles.remove(index);
		drawCircles();
	}
	
	private void drawCircles() {
		for(int i = 0; i < circles.size(); i++) {
			Circle c = circles.get(i);
			c.setLocation(width / 2 - c.size / 2, 425 - (Circle.height) * i); // 4
		}
		repaint();
	}
	
	public void isVictory() {
		int count = 0;
		for(int i = 0; i < sticks[2].circles.size(); i++) {
			count++;
		}
		if(count == Game.circlesCount)
			Game.win();
	}
}
