package com.peterpl.hanoi.graphics;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;

import com.peterpl.hanoi.Game;
import com.peterpl.hanoi.Print;

public class Circle extends ColorSquare {
	private static final long serialVersionUID = 1L;
	private static final int incWidth = 36;
	public static final int height = 36;

	public final int size;
	private boolean checked = false;

	public static final Color[] colors = { 
		new Color(0xbb0000), // Red
		new Color(0xc77700), // Orange
		new Color(0xffbb00), // Yellow
		new Color(0x2ba200), // Green
		new Color(0x002882), // Blue
		new Color(0x660088), // Purple
		new Color(0xda00ad), // Pink
	};

	public Circle(Color color, int index) {
		super(color, 45 * Game.circlesCount - index * incWidth, height);
		size = 45 * Game.circlesCount - index * incWidth;
		createIconImage(false, null);
		
		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {
				int mouseX = e.getX();
				int mouseY = e.getY();
				
				Print.p(mouseX + " " + mouseY);
				
				int newX = mouseX + getX();
				int newY = mouseY + getY();
				
				setLocation(newX, newY);
			}

			public void mouseMoved(MouseEvent e) {
			}
		});
	}

	public void createIconImage(boolean border, Color borderColor) {
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = image.createGraphics();
		
		graphics.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
		graphics.setColor(color);
		graphics.fillRoundRect(0, 0, width, height, 40, 40);
		if(border) {
			graphics.setStroke(new BasicStroke(3));
			graphics.setColor(borderColor);
			graphics.drawRoundRect(0, 0, width, height, 40, 40);
		}
		
		imageIcon = new ImageIcon(image);
		setIcon(imageIcon);
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
		
		int r = color.getRed() - 50;
		int g = color.getGreen() - 50;
		int b = color.getBlue() - 50;
		
		if(r >= 256) r = 255;
		if(g >= 256) g = 255;
		if(b >= 256) b = 255;
		
		if(r < 0) r = 0;
		if(g < 0) g = 0;
		if(b < 0) b = 0;
		
		createIconImage(checked ? true : false, new Color(r, g, b));
	}
	
	public boolean isChecked() {
		return checked;
	}
	
	public void setRandomColor() {
		Random rand = new Random();
		int colorIndex = rand.nextInt(colors.length);

		color = colors[colorIndex];
		createIconImage(false, null);
	}
}
