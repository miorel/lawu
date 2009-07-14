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
package lawu.app;

import static lawu.cli.HelpOption.formatHelpFooter;
import static lawu.cli.VersionOption.GPLED;

import java.awt.Desktop;
import java.net.URI;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

/**
 * Houses the <code>main</code> method and serves as access point for program
 * messages.
 * 
 * @author Miorel-Lucian Palii
 */
public class Main extends App {
	public Main() {
		this(new String[0]);
	}
	
	public Main(String... arguments) {
		super(new SoftwareInfo(Main.class), arguments);
		setHelpFooter(formatHelpFooter(getActualInfo().getBugReportEmail(), getActualInfo().getHomePage()));
		setVersionFooter(GPLED);
	}
		
	@Override
	protected void doRun() {
		String msg = String.format(ResourceBundle.getBundle("lawu.nls.str").getString("RunApp.0"), getActualInfo().getHomePage()); //$NON-NLS-1$ //$NON-NLS-2$
		
		int ans = JOptionPane.showConfirmDialog(null, msg, getTitle(),
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
		if(ans == JOptionPane.YES_OPTION)
			try {
				Desktop.getDesktop().browse(new URI(getActualInfo().getHomePage()));
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), getTitle(),
						JOptionPane.ERROR_MESSAGE, null);
			}
	}

	/**
	 * Entry point for project execution.
	 * 
	 * @param arg command-line options
	 */
	public static void main(String[] arg) {
		new Main(arg).run();
	}
}
