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

import static lawu.util.iterator.Iterators.iterator;

import java.util.ArrayList;
import java.util.List;

import lawu.dp.Iterator;
import lawu.util.Wrapper;
import lawu.util.iterator.IteratorAdapter;
import lawu.util.iterator.UniversalIterator;

/**
 * @author Miorel-Lucian Palii
 */
public class ArgumentSet {
	private final List<String> nonOptionArguments;
	private final List<Option> options;

	public ArgumentSet() {
		this.nonOptionArguments = new ArrayList<String>();
		this.options = new ArrayList<Option>();
	}

	public void clear() {
		this.nonOptionArguments.clear();
		this.options.clear();
	}

	public void addOption(Option option) {
		if(!this.options.contains(option))
			this.options.add(option);
	}

	public void removeOption(Option option) {
		this.options.remove(option);
	}

	public UniversalIterator<String> getNonOptionArguments() {
		return iterator(this.nonOptionArguments);
	}

	public UniversalIterator<Option> getOptions() {
		return iterator(this.options);
	}

	public void parse(String... arguments) {
		parse(iterator(arguments));
	}

	public void parse(Iterator<String> arguments) {
		final Wrapper<Boolean> advanced = new Wrapper<Boolean>();
		Iterator<String> iter = new IteratorAdapter<String>(arguments) {			
			@Override
			public void advance() {
				super.advance();
				advanced.value = Boolean.TRUE;
			}
		};
		for(iter.reset(); !iter.isDone(); ) {
			advanced.value = Boolean.FALSE;
			for(Option option: this.options) {
				option.parse(iter);
				if(advanced.value.booleanValue())
					break;
			}
			if(!advanced.value.booleanValue()) {
				this.nonOptionArguments.add(iter.current());
				iter.advance();
			}
		}
	}
}
