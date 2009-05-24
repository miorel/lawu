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

import java.io.IOException;

import lawu.dp.Iterator;
import lawu.util.Strings;

/**
 * @author Miorel-Lucian Palii
 */
public abstract class NamedOption implements Option {
	private final String shortOption;
	private final String longOption;
	private final String description;
	
	public NamedOption(char shortOption, String longOption, String description) {
		this(Character.toString(shortOption), longOption, description);
	}
	
	public NamedOption(String shortOption, String longOption, String description) {
		if(shortOption == null && longOption == null)
			throw new RuntimeException("");
		if(shortOption != null && !shortOption.matches("[A-Za-z\\d\\?]")) //$NON-NLS-1$
			throw new RuntimeException("");
		if(longOption != null && !longOption.matches("[A-Za-z]([A-Za-z\\d\\-]*[A-Za-z\\d])?")) //$NON-NLS-1$
			throw new RuntimeException("");
		if(description == null)
			throw new NullPointerException("");
		this.shortOption = shortOption;
		this.longOption = longOption;
		this.description = description;
	}
	
	protected void writeHelp(Appendable appendable, int indentAmount, int specificationWidth, int totalWidth) {
		String s = getShortSpecification();
		String l = getLongSpecification();
		StringBuilder sb = new StringBuilder();
		String ws = Strings.multiply(' ', indentAmount);
		sb.append(ws);
		if(s == null)
			sb.append(String.format("    %s", l)); //$NON-NLS-1$
		else if(l == null)
			sb.append(s);
		else
			sb.append(String.format("%s, %s", s, l)); //$NON-NLS-1$
		sb.append(ws);
		sb.append(Strings.multiply(' ', Math.max(0, specificationWidth - sb.length())));
		ws += Strings.multiply(' ', specificationWidth);
		sb.append(getDescription().trim().replaceAll("\\n\\s*", '\n' + ws)); //$NON-NLS-1$
		try {
			while(sb.length() > totalWidth) {
				boolean rep = false;
				for(int i = totalWidth; i >= specificationWidth + indentAmount; --i)
					if(sb.charAt(i) == ' ') {
						appendable.append(sb.subSequence(0, i));
						appendable.append('\n');
						sb.replace(0, i + 1, ws);
						rep = true;
						break;
					}
				if(!rep)
					break;
			}
			appendable.append(sb);
			appendable.append('\n');
		}
		catch(IOException e) {
			throw new RuntimeException("", e);
		}		
	}
	
	public void writeHelp(Appendable appendable) {
		writeHelp(appendable, 24);
	}
	
	protected void writeHelp(Appendable appendable, int specificationWidth) {
		writeHelp(appendable, 2, specificationWidth, 80);
	}
	
	public void parse(Iterator<String> args) {
		String arg = args.current();
		if(arg.equals(getShortSpecification()) || arg.equals(getLongSpecification())) {
			args.advance();
			trigger();
		}
	}
	
	protected void trigger() {
	}
	
	public String getLongSpecification() {
		return this.longOption == null ? null : String.format("--%s", this.longOption); //$NON-NLS-1$
	}
	
	public String getShortSpecification() {
		return this.shortOption == null ? null : String.format("-%s", this.shortOption); //$NON-NLS-1$
	}
	
	public String getDescription() {
		return this.description;
	}
}
