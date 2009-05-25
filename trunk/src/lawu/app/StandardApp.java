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

import static lawu.cli.VersionOption.*;

import lawu.cli.ArgumentSet;
import lawu.cli.HelpOption;
import lawu.cli.VersionOption;

/**
 * @author Miorel-Lucian Palii
 */
public abstract class StandardApp extends App {
	private String name;
	private String version;
	private String copyright;
	private String helpHeader;
	private String helpFooter;
	private String versionFooter;
	
	public StandardApp(String name, String version, String copyright, String helpHeader, String helpFooter, String versionFooter, String[] arguments) {
		super(arguments);
		setName(name);
		setVersion(version);
		setCopyright(copyright);
		setHelpHeader(helpHeader);
		setHelpFooter(helpFooter);
		setVersionFooter(versionFooter);
	}
	
	public StandardApp(String name, String version, String copyright, String[] arguments) {
		this(name, version, copyright, null, null, null, arguments);
	}
	
	public StandardApp(String[] arguments) {
		this(null, "(pre-alpha)", null, arguments); //$NON-NLS-1$
		setName(getClass().getName());
	}
	
	protected String getName() {
		return this.name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected String getVersion() {
		return this.version;
	}
	
	protected void setVersion(String version) {
		this.version = version;
	}

	protected String getCopyright() {
		return this.copyright;
	}
	
	protected void setCopyright(String copyright) {
		this.copyright = copyright;
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
	
	@Override
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
		return formatVersionOutput(getTitle(), getCopyright(), getVersionFooter());	
	}
	
	protected String getTitle() {
		return formatProgramTitle(getName(), getVersion());
	}
}
