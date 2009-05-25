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
 * @author Miorel-Lucian Palii
 */
public class VersionOption extends NamedOption {
	private final String output;
	
	public static final String GPLED = "License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>.\nThis is free software: you are free to change and redistribute it.\nThere is NO WARRANTY, to the extent permitted by law."; 
	
	public VersionOption(char shortOption, String longOption, String description, String output) {
		this(Character.toString(shortOption), longOption, description, output);
	}
	
	public VersionOption(String shortOption, String longOption, String description, String output) {
		super(shortOption, longOption, description);
		if(output == null)
			throw new NullPointerException("");
		this.output = output;
	}
	
	public VersionOption(String longOption, String description, String output) {
		this('V', longOption, description, output);
	}
	
	public VersionOption(String description, String output) {
		this("version", description, output); //$NON-NLS-1$
	}
	
	public VersionOption(String output) {
		this("output version information and exit", output);
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
		System.out.print(this.output);
		if(exit)
			System.exit(0);
	}

	public static String formatProgramTitle(String programName, String packageName, String version) {
		if(programName == null)
			throw new NullPointerException("");
		if(version == null)
			throw new NullPointerException("");
		if(!version.matches("\\S+")) //$NON-NLS-1$
			throw new RuntimeException("");
		StringBuilder sb = new StringBuilder(programName);
		if(packageName != null)
			sb.append(String.format(" (%s)", packageName)); //$NON-NLS-1$
		sb.append(' ');
		sb.append(version);
		return sb.toString();
	}

	public static String formatCopyright(String holder, String date) {
		if(holder == null)
			throw new NullPointerException("");
		if(date == null)
			throw new NullPointerException("");
		return String.format("Copyright (C) %s %s", date, holder); //$NON-NLS-1$
	}
	
	public static String formatCopyright(String holder, int year) {
		return formatCopyright(holder, Integer.toString(year));
	}
	
	public static String formatVersionOutput(String title, String copyright, String footer) {
		if(title == null)
			throw new NullPointerException("");
		StringBuilder sb = new StringBuilder(title);
		sb.append('\n');
		if(copyright != null) {
			sb.append(copyright);
			sb.append('\n');
		}
		if(footer != null) {
			sb.append(footer);
			sb.append('\n');
		}
		return sb.toString();
	}
	
	public static String formatProgramTitle(String programName, String version) {
		return formatProgramTitle(programName, null, version);
	}
	
	public static String formatVersionString(int major) {
		if(major < 0)
			throw new RuntimeException("");
		return String.format("%d", Integer.valueOf(major)); //$NON-NLS-1$
	}
	
	public static String formatVersionString(int major, int minor) {
		if(minor < 0)
			throw new RuntimeException("");
		return String.format("%s.%d", formatVersionString(major), Integer.valueOf(minor)); //$NON-NLS-1$
	}
	
	public static String formatVersionString(int major, int minor, int revision) {
		if(revision < 0)
			throw new RuntimeException("");
		return String.format("%s.%d", formatVersionString(major, minor), Integer.valueOf(revision)); //$NON-NLS-1$
	}
}
