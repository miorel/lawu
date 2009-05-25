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

import static lawu.util.iterator.Iterators.iterator;

import javax.swing.UIManager;

import lawu.util.iterator.UniversalIterator;

/**
 * @author Miorel-Lucian Palii
 */
public abstract class App {
	private final String[] arguments;
	
	public App(String[] arguments) {
		if(arguments == null)
			throw new NullPointerException("");
		this.arguments = arguments;
	}
	
	protected UniversalIterator<String> getArguments() {
		return iterator(this.arguments);
	}
	
	protected void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {}
	}
	
	protected void parseArguments() {
	}
	
	public void run() {
		setLookAndFeel();
		parseArguments();
		doRun();
	}
	
	protected void doRun() {
	}
}
