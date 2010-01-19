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

import static lawu.cli.VersionOption.formatProgramTitle;
import static lawu.cli.VersionOption.formatVersionOutput;

import javax.swing.UIManager;

import lawu.cli.ArgumentSet;
import lawu.cli.HelpOption;
import lawu.cli.VersionOption;

/**
 * @author Miorel-Lucian Palii
 */
public abstract class App extends AbstractSoftwareElement {
	private String helpHeader;
	private String helpFooter;
	private String versionFooter;
	
	private final String[] arguments;

	public App(SoftwareInfo info, String helpHeader, String helpFooter, String versionFooter, String[] arguments) {
		super(info);
		this.arguments = arguments != null ? arguments : new String[0];
		setHelpHeader(helpHeader);
		setHelpFooter(helpFooter);
		setVersionFooter(versionFooter);
	}
	
	public App(String name, String version, String copyright, String helpHeader, String helpFooter, String versionFooter, String[] arguments) {
		this(new SoftwareInfo(name, version, copyright), helpHeader, helpFooter, versionFooter, arguments);
	}
	
	public App(SoftwareInfo info, String[] arguments) {
		this(info, null, null, null, arguments);
	}
	
	public App(String name, String version, String copyright, String[] arguments) {
		this(name, version, copyright, null, null, null, arguments);
	}
	
	public App(String[] arguments) {
		this.arguments = arguments != null ? arguments : new String[0];
		setHelpHeader(null);
		setHelpFooter(null);
		setVersionFooter(null);
	}
	
	public App() {
		this(null);
	}
	
	protected String getHelpHeader() {
		return this.helpHeader;
	}
	
	protected void setHelpHeader(String helpHeader) {
		this.helpHeader = helpHeader;
	}

	protected String getHelpFooter() {
		return this.helpFooter;
	}
	
	protected void setHelpFooter(String helpFooter) {
		this.helpFooter = helpFooter;
	}

	protected String getVersionFooter() {
		return this.versionFooter;
	}
	
	protected void setVersionFooter(String versionFooter) {
		this.versionFooter = versionFooter;
	}
	
	protected String[] getArguments() {
		return this.arguments;
	}
	
	protected void parseArguments() {
		ArgumentSet argSet = new ArgumentSet();
		addOptions(argSet);
		addStandardOptions(argSet);
		argSet.parse(getArguments());
	}
	
	protected void addOptions(@SuppressWarnings("unused") ArgumentSet argumentSet) {
	}
	
	protected void addStandardOptions(ArgumentSet argumentSet) {
		argumentSet.addOption(new HelpOption(argumentSet, getHelpHeader(), getHelpFooter()));
		argumentSet.addOption(new VersionOption(getVersionOutput()));
	}
	
	protected String getVersionOutput() {
		return formatVersionOutput(getTitle(), getActualInfo().getCopyright(), getVersionFooter());	
	}
	
	protected String getTitle() {
		return formatProgramTitle(getActualInfo().getName(), getActualInfo().getVersion());
	}
	
	protected void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
		}
	}
	
	public void run() {
		setLookAndFeel();
		parseArguments();
		doRun();
	}
	
	protected void doRun() {
	}
}
