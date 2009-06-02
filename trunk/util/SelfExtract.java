/*
 * lawu
 * Copyright (C) 2009 Miorel-Lucian Palii
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class SelfExtract {
	private final String[] arguments;
	
	public SelfExtract(String[] arguments) {
		this.arguments = arguments;
	}
	
	public static void main(String[] arg) {
		new SelfExtract(arg).run();
	}
	
	public void run() {
		setLookAndFeel();
		if(this.arguments.length == 0) {
			JFrame frame = new JFrame();
			GridBagLayout gb = new GridBagLayout();
			JPanel contentPane = new JPanel(gb);
			String text = "<html><p>Hello</p><p>World!</p></html>";
			contentPane.add(new JLabel(text));
			contentPane.add(new JButton("Extract"));
			frame.setContentPane(contentPane);
			frame.pack();
	        frame.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
	        frame.setResizable(false);
	        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		}
		else {
			
		}
	}
	
	protected void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {}
	}
}