package com.peterpl.hanoi;

import java.awt.*;

import javax.swing.*;

public class Timer extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private boolean active = false;
	private int seconds = 0;
	private int minutes = 0;
	
	private JLabel time;
	private Thread thread;

	public static final int width = 250;
	public static final int height = 65;

	public Timer() {
		setSize(width, height);
		setLayout(null);

		time = new JLabel("Time: 0:00");
		time.setBounds(0, 0, width, height);
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("Verdana", Font.PLAIN, 30));
		add(time);
		
		start();
	}
	
	public void start() {
		active = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop() {
		active = false;
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			
			if(!active) {
				break;
			}
			
			seconds++;
			
			if(seconds >= 60) {
				seconds = 0;
				minutes++;
			}
			
			String correct = seconds < 10 ? "0" : "";
			time.setText("Time: " + minutes + ":" + correct + seconds);
		}
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	public int getMinutes() {
		return minutes;
	}
}
