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
import static lawu.cli.VersionOption.formatCopyright;
import static lawu.cli.VersionOption.formatProgramTitle;
import static lawu.cli.VersionOption.formatVersionOutput;

import java.awt.Desktop;
import java.net.URI;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import lawu.cli.ArgumentSet;
import lawu.cli.HelpOption;
import lawu.cli.VersionOption;

/**
 * Houses the <code>main</code> method and serves as access point for program
 * messages.
 * 
 * @author Miorel-Lucian Palii
 */
public class Main extends StandardApp {
	private static final String BUNDLE_NAME = "lawu.nls.str"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE;

	static {
		ResourceBundle rb = null;
		try {
			rb = ResourceBundle.getBundle(BUNDLE_NAME);
		}
		catch(MissingResourceException e) {
		}
		RESOURCE_BUNDLE = rb;
	}

	private Main(String... arguments) {
		super(arguments);
		setName("lawu"); //$NON-NLS-1$
		setVersion(getString("project.version")); //$NON-NLS-1$
		setCopyright(formatCopyright("Miorel-Lucian Palii", 2009));
		setHelpFooter(formatHelpFooter("mlpalii@gmail.com", getHomePage()));
		setVersionFooter(GPLED);
	}
	
	protected String getHomePage() {
		return getString("project.uri"); //$NON-NLS-1$
	}
		
	@Override
	protected void doRun() {
		String msg = String.format(getString("RunApp.0"), getHomePage()); //$NON-NLS-1$
		
		int ans = JOptionPane.showConfirmDialog(null, msg, getTitle(),
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
		if(ans == JOptionPane.YES_OPTION)
			try {
				Desktop.getDesktop().browse(new URI(getHomePage()));
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

	/**
	 * Retrieves the externalized string corresponding to the specified key.
	 * 
	 * @param key externalized string identifier
	 * @return the corresponding value
	 */
	public static String getString(String key) {
		String ret;
		try {
			ret = RESOURCE_BUNDLE.getString(key);
		}
		catch(Exception e) {
			ret = '!' + key + '!';
		}
		return ret;
	}
}
