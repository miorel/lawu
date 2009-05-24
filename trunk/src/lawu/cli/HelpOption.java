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
package lawu.cli;

/**
 * @author miorel
 *
 */
public class HelpOption extends NamedOption {
	private final ArgumentSet argumentSet;
	private final String header;
	private final String footer;
	
	public HelpOption(String shortOption, String longOption, String description, ArgumentSet argumentSet, String header, String footer) {
		super(shortOption, longOption, description);
		if(argumentSet == null)
			throw new NullPointerException();
		this.argumentSet = argumentSet;
		this.header = header;
		this.footer = footer;
	}
	
	public HelpOption(char shortOption, String longOption, String description, ArgumentSet argumentSet, String header, String footer) {
		this(Character.toString(shortOption), longOption, description, argumentSet, header, footer);
	}
	
	public HelpOption(String description, ArgumentSet argumentSet, String header, String footer) {
		this("help", description, argumentSet, header, footer); //$NON-NLS-1$
	}

	public HelpOption(String longOption, String description, ArgumentSet argumentSet, String header, String footer) {
		this('?', longOption, description, argumentSet, header, footer);
	}
	
	public HelpOption(String description, ArgumentSet argumentSet) {
		this(description, argumentSet, null, null);
	}
	
	public HelpOption(ArgumentSet argumentSet, String header, String footer) {
		this("display this help and exit", argumentSet, header, footer);
	}
	
	public HelpOption(ArgumentSet argumentSet) {
		this(argumentSet, null, null);
	}
	
	@Override
	public void writeHelp(Appendable appendable) {
		writeHelp(appendable, 17);
	}
	
	@Override
	public void trigger() {
		trigger(true);
	}
	
	public void trigger(boolean exit) {
		if(this.header != null)
			System.out.print(this.header);
		for(Option opt: this.argumentSet.getOptions())
			opt.writeHelp(System.out);
		if(this.footer != null)
			System.out.print(this.footer);
		if(exit)
			System.exit(0);
	}
	
	public static String formatHelpFooter(String bugReportEmail, String homePage) {
		return formatHelpFooter(bugReportEmail, homePage, "Project");
	}
	
	public static String formatHelpFooter(String bugReportEmail, String homePage, String projectString) {
		StringBuilder sb = new StringBuilder();
		sb.append('\n');
		if(bugReportEmail != null) {
			sb.append(String.format("Report bugs to %s", bugReportEmail));
			sb.append('\n');
		}
		sb.append(String.format("%s home page: <%s>", projectString, homePage));
		sb.append('\n');
		return sb.toString();
	}
}
