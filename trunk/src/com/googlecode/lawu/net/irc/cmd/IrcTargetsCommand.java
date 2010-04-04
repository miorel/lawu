/*
 * Copyright (C) 2010 Miorel-Lucian Palii
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
package com.googlecode.lawu.net.irc.cmd;

import static com.googlecode.lawu.util.Iterators.adapt;
import static com.googlecode.lawu.util.Iterators.iterator;
import static com.googlecode.lawu.util.Iterators.list;

import java.util.List;
import java.util.Locale;

import com.googlecode.lawu.dp.Iterator;
import com.googlecode.lawu.util.Strings;
import com.googlecode.lawu.util.iterators.UniversalIterator;

/**
 * An IRC command that is directed at a list of targets.
 * 
 * @author Miorel-Lucian Palii
 */
public abstract class IrcTargetsCommand extends AbstractIrcCommand {
	private final String[] targets;
	
	public IrcTargetsCommand(Iterator<String> targets) {
		List<String> targetsList = list(adapt(targets));
		if(targetsList.isEmpty())
			throw new IllegalArgumentException("Can't " + getVerb() + " without targets.");
		for(String target: targetsList)
			validateString("targets", target, false, false);
		this.targets = targetsList.toArray(new String[targetsList.size()]);
	}
	
	/**
	 * Retrieves a string description of the action this command represents.
	 * 
	 * @return the command's verb
	 */
	protected String getVerb() {
		return getCommand().toLowerCase(Locale.ENGLISH);
	}
	
	/**
	 * Returns an iterator over this command's targets.
	 * 
	 * @return this command's targets
	 */
	public UniversalIterator<String> getTargets() {
		return iterator(this.targets);
	}
	
	@Override
	public UniversalIterator<String> getArguments() {
		return iterator(Strings.join(" ", this.targets));
	}
}
