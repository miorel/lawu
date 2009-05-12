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
package lawu;

import java.awt.Desktop;
import java.net.URI;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Houses the <code>main</code> method and serves as access point for program
 * messages.
 * 
 * @author Miorel-Lucian Palii
 */
public class Main {
	public static final String PROJECT_NAME = Main.class.getPackage().getName();
	public static final String PROJECT_VERSION;

	private static final String BUNDLE_NAME = PROJECT_NAME + ".nls.str"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE;

	static {
		ResourceBundle rb;
		try {
			rb = ResourceBundle.getBundle(BUNDLE_NAME);
		}
		catch(MissingResourceException e) {
			rb = null;
		}
		RESOURCE_BUNDLE = rb;
		PROJECT_VERSION = getString("project.version"); //$NON-NLS-1$
	}

	private Main() {
		// no initialization work necessary
	}

	private void run() {
		String uri = getString("project.uri"); //$NON-NLS-1$
		String msg = String.format(getString("RunApp.0"), uri); //$NON-NLS-1$
		String title = PROJECT_NAME + " " + PROJECT_VERSION; //$NON-NLS-1$

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {}

		int ans = JOptionPane.showConfirmDialog(null, msg, title,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
		if(ans == JOptionPane.YES_OPTION)
			try {
				Desktop.getDesktop().browse(new URI(uri));
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), title,
						JOptionPane.ERROR_MESSAGE, null);
			}
	}

	/**
	 * Entry point for project execution.
	 * 
	 * @param arg command-line options
	 */
	public static void main(String[] arg) {
		new Main().run();
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
