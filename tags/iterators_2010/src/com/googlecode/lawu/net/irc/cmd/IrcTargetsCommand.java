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
	
	protected String getVerb() {
		return getCommand().toLowerCase(Locale.ENGLISH);
	}
	
	public UniversalIterator<String> getTargets() {
		return iterator(targets);
	}
	
	@Override
	public UniversalIterator<String> getArguments() {
		return iterator(new String[] {Strings.join(" ", getTargets())});
	}
}
