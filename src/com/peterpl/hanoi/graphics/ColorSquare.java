package com.peterpl.hanoi.graphics;

import java.awt.*;
import java.awt.image.*;

import javax.swing.*;

public class ColorSquare extends JLabel {
	private static final long serialVersionUID = 1L;

	protected final int width;
	protected final int height;

	protected ImageIcon imageIcon;
	public Color color;

	public ColorSquare(Color color, int width, int height) {
		this.width = width;
		this.height = height;
		this.color = color;

		createIconImage();

		setSize(width, height);
		setLocation(0, 0);
	}

	private void createIconImage() {
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		for (int i = 0; i < pixels.length; i++)
			pixels[i] = color.getRGB();

		imageIcon = new ImageIcon(image);
		setIcon(imageIcon);
	}
}
