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

import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * @author Miorel-Lucian Palii
 */
public class SelfExtractMinimal {
	private final String[] arguments;
	private final ResourceBundle rb;
	private boolean console;
	
	protected SelfExtractMinimal(String[] arguments) {
		this.arguments = arguments;
		this.rb = ResourceBundle.getBundle(getClass().getName() + "Strings"); //$NON-NLS-1$
		this.console = GraphicsEnvironment.isHeadless() || getArguments().length != 0;
	}
	
	protected ResourceBundle getBundle() {
		return this.rb;
	}
	
	protected String getString(String key) {
		return getBundle().getString(key);
	}
	
	protected String[] getArguments() {
		return this.arguments;
	}
	
	protected boolean isConsole() {
		return this.console;
	}
	
	protected void setConsole(boolean console) {
		this.console = console;
	}
	
	protected void setLookAndFeel() {
		if(!isConsole())
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch(Exception e) {
				grumble(getString("look_and_feel_fail")); //$NON-NLS-1$
			}
	}
	
	protected int run() {
		int exitCode = 0;
		try {
			setLookAndFeel();
			JarFile jar = getJar();
			if(ask(getString("extract_question"))) {//$NON-NLS-1$
				unpack(jar, new File("."), "zip/"); //$NON-NLS-1$ //$NON-NLS-2$
				info(getString("extract_finish")); //$NON-NLS-1$
			}
		}
		catch(Throwable t) {
			error(t.getMessage());
			exitCode = 1;
		}
		return exitCode;
	}

	protected boolean ask(String message) {
		return ask(message, JOptionPane.QUESTION_MESSAGE);
	}
	
	protected boolean ask(String message, int messageType) {
		boolean ret;
		if(isConsole()) {
			System.out.print(message);
			System.out.print(' ');
			System.out.print(getString("yes_no_option")); //$NON-NLS-1$
			System.out.print(' ');
			System.out.flush();
			ret = new Scanner(System.in).nextLine().matches(getString("yes_regex")); //$NON-NLS-1$
		}
		else
			ret = JOptionPane.showConfirmDialog(null, message, getTitle(), 	JOptionPane.YES_NO_OPTION, messageType) == JOptionPane.YES_OPTION;
		return ret;
	}
	
	protected void grumble(String message) {
		if(isConsole())
			System.err.println(message);
	}
	
	protected void warn(String message) {
		if(isConsole())
			System.err.println(message);
		else
			JOptionPane.showMessageDialog(null, message, getTitle(), JOptionPane.WARNING_MESSAGE);
	}
	
	protected void error(String message) {
		if(isConsole())
			System.err.println(message);
		else
			JOptionPane.showMessageDialog(null, message, getTitle(), JOptionPane.ERROR_MESSAGE);
	}

	protected void info(String message) {
		if(isConsole())
			System.out.println(message);
		else
			JOptionPane.showMessageDialog(null, message, getTitle(), JOptionPane.INFORMATION_MESSAGE);
	}
	
	protected String getTitle() {
		return new File(getJarPath()).getName();
	}
	
	protected String getJarPath() {
		return SelfExtractMinimal.class.getProtectionDomain().getCodeSource().getLocation().getFile();
	}
	
	protected JarFile getJar() throws IOException {
		JarFile ret = null;
		try {
			ret = new JarFile(getJarPath());
		}
		catch(IOException e) {
			throw new IOException(getString("jar_open_fail")); //$NON-NLS-1$
		}
		return ret;
	}
	
	protected void unpack(JarFile archive, File outputDirectory, String prefix) {
		Enumeration<JarEntry> entries = archive.entries();
		while(entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			if(entry.getName().indexOf(prefix) == 0) {
				String entryName = entry.getName().substring(prefix.length());
				String outFilePath = outputDirectory.getPath() + File.separator + entryName;
				File outFile = new File(outFilePath);
				try {
					if(entry.isDirectory()) {
						outFile.mkdirs();
						if(!outFile.exists() || !outFile.isDirectory())
							throw new IOException(String.format(getString("dir_create_fail"), entryName)); //$NON-NLS-1$
					}
					else {
						if(outFile.exists() && !ask(String.format(getString("overwrite_question"), entryName), JOptionPane.WARNING_MESSAGE)) //$NON-NLS-1$
							continue;
						InputStream inStream;
						try {
							inStream = archive.getInputStream(entry);
						}
						catch(IOException e) {
							throw new IOException(String.format(getString("in_stream_get_fail"), entryName)); //$NON-NLS-1$
						}
						ReadableByteChannel inChannel = Channels.newChannel(inStream);
						outFile.getParentFile().mkdirs();
						FileOutputStream outStream;
						try {
							outStream = new FileOutputStream(outFile);
						}
						catch(FileNotFoundException e) {
							throw new FileNotFoundException(String.format(getString("out_stream_get_fail"), entryName)); //$NON-NLS-1$
						}
						try {
							FileChannel outChannel = outStream.getChannel();
							outChannel.transferFrom(inChannel, 0, entry.getSize());
						}
						catch(Exception e) {
							throw new IOException(String.format(getString("write_fail"), entryName)); //$NON-NLS-1$
						}
						finally {
							try {
								inStream.close();
							}
							catch(IOException e) {
								grumble(String.format(getString("in_stream_close_fail"), entryName)); //$NON-NLS-1$
							}
							try {
								outStream.close();
							}
							catch(IOException e) {
								grumble(String.format(getString("out_stream_close_fail"), entryName)); //$NON-NLS-1$	
							}
						}
					}
				}
				catch(IOException e) {
					error(e.getMessage());
				}
			}
		}
	}
	
	public static void main(String[] arg) {
		System.exit(new SelfExtractMinimal(arg).run());
	}
}
